package org.usfirst.frc3739.AuxBot.commands;

import org.usfirst.frc3739.AuxBot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmControl extends Command {
	private Joystick joystickC = Robot.oi.getJoystick('c');
	private Joystick joystickD = Robot.oi.getJoystick('d');
	private double shoulderPausePosition;
	private double elbowPausePosition;

	private static final double joystickDeadZone = 0.05;

	public ArmControl() {
		requires(Robot.arm);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		shoulderPausePosition = Robot.arm.getShoulderEncoderDistance();
		elbowPausePosition = Robot.arm.getElbowEncoderDistance();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double joyCY = joystickC.getY(), joyDY = joystickD.getY();

		if (joyCY > joystickDeadZone || joyCY < -joystickDeadZone) {
			Robot.arm.setShoulderJointSpeed(-joyCY);
			shoulderPausePosition = Robot.arm.getShoulderEncoderDistance();
		} else {
			Robot.arm.setShoulderJointPosition(shoulderPausePosition);
		}
		if (joyDY > joystickDeadZone || joyDY < -joystickDeadZone) {
			Robot.arm.setElbowJointSpeed(joyDY);
			elbowPausePosition = Robot.arm.getElbowEncoderDistance();
		} else {
			Robot.arm.setElbowJointPosition(elbowPausePosition, 0.05);
		}
		SmartDashboard.putNumber("Shoulder Encoder", shoulderPausePosition);
		SmartDashboard.putNumber("Elbow Encoder", elbowPausePosition);
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
