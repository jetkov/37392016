package org.usfirst.frc.team3739.robot.commands;
 
import org.usfirst.frc.team3739.robot.Robot;
 
import edu.wpi.first.wpilibj.command.Command;
 
/**
 *
 */
public class CloseCommand extends Command {
 
    public CloseCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.opencloseTrain);
        //setTimeout(5);//0.3 seconds
    }
 
    // Called just before this Command runs the first time
    protected void initialize() {
    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {                         
    	double openclosepower = -0.8; //don't have to do this                         
        Robot.opencloseTrain.openclose(openclosepower); 
        //System.out.println("CLOSing");
    }
 
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
        		//isTimedOut();//right place?
    }
 
    // Called once after isFinished returns true
    protected void end() {
    	//Robot.opencloseTrain.isOpen=false;
    	Robot.opencloseTrain.openclose(0);          
    }
 
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();//VERY IMPORTANT
    }
}