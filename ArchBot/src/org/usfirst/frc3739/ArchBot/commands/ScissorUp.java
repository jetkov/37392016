package org.usfirst.frc3739.ArchBot.commands;

import org.usfirst.frc3739.ArchBot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ScissorUp extends Command {

	public ScissorUp() {
		requires(Robot.scissor);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.scissor.scissorUp();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.scissor.killScissor();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
