package autoCommands;
 
import org.usfirst.frc.team3739.robot.Robot;
 
import edu.wpi.first.wpilibj.command.Command;
 
/**
 *
 */
public class Open extends Command {
 
    public Open(double time) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.opencloseTrain);
        setTimeout(time);//time it takes to open
    }
 
    // Called just before this Command runs the first time
    protected void initialize() {
    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {                         
    	double openclosepower = 0.65; //don't have to do this                         
        Robot.opencloseTrain.openclose(openclosepower); 
        System.out.println("Opening");
    }
 
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }
 
    // Called once after isFinished returns true
    protected void end() {
    	//For toggle: Robot.opencloseTrain.isOpen=false;
    	Robot.opencloseTrain.openclose(0);          
    }
 
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}