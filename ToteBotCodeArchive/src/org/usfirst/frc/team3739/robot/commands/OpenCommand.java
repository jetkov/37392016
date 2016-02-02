package org.usfirst.frc.team3739.robot.commands;
 
import org.usfirst.frc.team3739.robot.Robot;
 
import edu.wpi.first.wpilibj.command.Command;
 
/**
 *
 */
public class OpenCommand extends Command {
 
    public OpenCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.opencloseTrain);
        setTimeout(5);//5 seconds
    }
 
    // Called just before this Command runs the first time
    protected void initialize() {
    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {      
    	double openclosepower = 0.6;//don't have to do this just put 0.6 in parameters                   
      	Robot.opencloseTrain.openclose(openclosepower);  
      	//System.out.println("OPENing"); 
       
    }
 
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;//correct placement?
    }
 
    // Called once after isFinished returns true
    protected void end() {
    	Robot.opencloseTrain.isOpen=true;
        Robot.opencloseTrain.openclose(0);        
    }
 
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();//important 
    }
}