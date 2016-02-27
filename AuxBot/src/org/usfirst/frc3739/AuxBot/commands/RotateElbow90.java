package org.usfirst.frc3739.AuxBot.commands;

import org.usfirst.frc3739.AuxBot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotateElbow90 extends Command {
	private double elbowSetPosition;

	public RotateElbow90() {
		requires(Robot.arm);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		elbowSetPosition = Robot.arm.getElbowEncoderDistance() + 90 * 2.957;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.arm.setElbowJointPosition(elbowSetPosition, 0.5);
		SmartDashboard.putNumber("Elbow Encoder", elbowSetPosition);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
