package org.usfirst.frc3739.AuxBot.commands;

import org.usfirst.frc3739.AuxBot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class LiftSystemUp extends Command {

	private double winchSpeed = 0.5;

	public LiftSystemUp() {
		requires(Robot.scissor);
		requires(Robot.winch);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.scissor.setSpeed(1);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (winchSpeed >= 0.25) {
			winchSpeed -= 0.01;
		}
		Robot.winch.setSpeed(-winchSpeed);
		Timer.delay(0.2);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.scissor.killScissor();
		Robot.winch.killWinch();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
