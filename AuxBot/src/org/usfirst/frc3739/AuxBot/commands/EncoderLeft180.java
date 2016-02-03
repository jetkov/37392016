package org.usfirst.frc3739.AuxBot.commands;

import org.usfirst.frc3739.AuxBot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Rotates the joint 180 degrees to the left
 */
public class EncoderLeft180 extends Command {

	public EncoderLeft180() {
		requires(Robot.testArmJoint);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.testArmJoint.rotateJoint(-180);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		// return Robot.testArmJoint.rotateFinsihed();
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.testArmJoint.stopJoint();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.testArmJoint.stopJoint();
	}
}
