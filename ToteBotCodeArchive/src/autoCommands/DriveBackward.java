package autoCommands;

import org.usfirst.frc.team3739.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveBackward extends Command {

    public DriveBackward(double time) {
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	setTimeout(time);
    	requires(Robot.driveTrain);    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.driveTrain.getEncoderLeft().reset();
    	//Robot.driveTrain.getEncoderRight().reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() { 		
		Robot.driveTrain.drive(0.6,0);
		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {    	
    	//if(Robot.driveTrain.getEncoderLeft().getDistance()>distance&&Robot.driveTrain.getEncoderRight().getDistance()>distance){
    	//return true;
    	//}
    	//return false;
    	return isTimedOut();
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
