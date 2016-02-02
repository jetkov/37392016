package org.usfirst.frc.team3739.robot.commands;
 
import org.usfirst.frc.team3739.robot.Robot;
 
import edu.wpi.first.wpilibj.command.Command;
 
/**
 *
 */
public class FastLiftDownCommand extends Command {
 
    public FastLiftDownCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.liftTrain);
    }
 
    // Called just before this Command runs the first time
    protected void initialize() {
    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double liftpower = Robot.oi.OPJoystick.getdeadY();   //OPJoystick please!!!!
    	//Setting speed at a constant speed of 1 or -1    	 
    	//if(liftpower>0){
    		//liftpower=1;
    	//}
    	if(liftpower<0){
    		liftpower=-0.5;
    		if(!Robot.liftTrain.limitSwitch.get()){//love limit switch
    			liftpower=0;
    		}    			
    	}                       
      
    	Robot.liftTrain.lift(liftpower);       
    }
 
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
 
    // Called once after isFinished returns true
    protected void end() {
        Robot.liftTrain.lift(0);
    }
 
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}