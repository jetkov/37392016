package org.usfirst.frc3739.AuxBot.commands;

import org.usfirst.frc3739.AuxBot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class GrabBall extends Command {
    
    public GrabBall() {
        requires(Robot.hand);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.hand.grab();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.hand.grabComplete();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.hand.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
