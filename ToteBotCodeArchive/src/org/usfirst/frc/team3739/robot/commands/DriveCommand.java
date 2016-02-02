package org.usfirst.frc.team3739.robot.commands;

import org.usfirst.frc.team3739.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCommand extends Command {

    public DriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double power = Robot.oi.rightJoystick.getdeadY();
    	double l = 0;
    	double right = power;
		if (Robot.oi.leftJoystick.getdeadX() < 0){
			l = Robot.oi.leftJoystick.getdeadX();
		}
		else if(Robot.oi.leftJoystick.getdeadX() > 0){
			right *= Robot.oi.leftJoystick.getdeadX()*-1;
		}
		
		if(Robot.oi.rightJoystick.getdeadY() < 0 && Robot.oi.leftJoystick.getdeadX() < 0)
		{
			Robot.driveTrain.drive(power*l,(right*0.90));//right motor is slightly stronger normally
		}
		
		else if(Robot.oi.rightJoystick.getdeadY() > 0 && Robot.oi.leftJoystick.getdeadX() < 0)
		{
			Robot.driveTrain.drive(power*l*0.96,(right*0.95));//right motor is slightly stronger normally
		}
		
		else if(Robot.oi.rightJoystick.getdeadY() < 0)
		{
			Robot.driveTrain.drive(power,(right*0.90));//right motor is slightly stronger normally
		}
		
		else if(Robot.oi.rightJoystick.getdeadY() > 0)
		{
			Robot.driveTrain.drive(power*0.96,(right*0.95));//right motor is slightly stronger normally
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
