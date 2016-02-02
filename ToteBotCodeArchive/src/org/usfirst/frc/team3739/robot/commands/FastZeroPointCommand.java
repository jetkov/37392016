package org.usfirst.frc.team3739.robot.commands;

import org.usfirst.frc.team3739.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FastZeroPointCommand extends Command {

    public FastZeroPointCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {    	
		double left=0;
		double right=0;
		//adjust speed of ZPT here
		if (Robot.oi.leftJoystick.getdeadX() < 0){//on yasir's head
			left = 0.65;
			right = -0.65;
		}
		else if(Robot.oi.leftJoystick.getdeadX() > 0){
			left = -0.65;
			right = 0.65; 
		}
		
		Robot.driveTrain.drive(left,right);
		
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
    	end();
    }
}
