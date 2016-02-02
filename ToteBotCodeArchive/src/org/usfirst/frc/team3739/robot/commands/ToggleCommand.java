package org.usfirst.frc.team3739.robot.commands;
 
import org.usfirst.frc.team3739.robot.Robot;
 
import edu.wpi.first.wpilibj.command.Command;
 
/**
 *ONLY IF YOU WANT ONE BUTTON TO BOTH CLOSE AND OPEN
 */
public class ToggleCommand extends Command {
 
    public ToggleCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.opencloseTrain);
        setTimeout(0.2);//2 seconds
        setInterruptible(false);
    }
 
    // Called just before this Command runs the first time
    protected void initialize() {
    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {      
    	                   
      	Robot.opencloseTrain.toggle();  
      	
       
    }
 
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();//correct placement?
    }
 
    // Called once after isFinished returns true
    protected void end() {
    	Robot.opencloseTrain.isOpen=!Robot.opencloseTrain.isOpen;
        Robot.opencloseTrain.openclose(0);        
    }
 
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}