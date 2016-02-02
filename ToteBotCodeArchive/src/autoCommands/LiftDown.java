package autoCommands;
 
import org.usfirst.frc.team3739.robot.Robot;
 
import edu.wpi.first.wpilibj.command.Command;
 
/**
 *
 */
public class LiftDown extends Command {
 
    public LiftDown(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.liftTrain);
        setTimeout(time);
    }
 
    // Called just before this Command runs the first time
    protected void initialize() {
    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double liftpower = -0.3;
    	if(!Robot.liftTrain.limitSwitch.get()){//limit switch makes it such that the lift won't continue past a point (where the limit switch is)
    		liftpower = 0;
		}
    	Robot.liftTrain.lift(liftpower);    	
    }
 
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isTimedOut();
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