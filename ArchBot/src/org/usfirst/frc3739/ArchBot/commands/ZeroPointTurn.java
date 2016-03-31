package org.usfirst.frc3739.ArchBot.commands;

import org.usfirst.frc3739.ArchBot.Config;
import org.usfirst.frc3739.ArchBot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Robot does a zero point turn under the control of the joystick normally used
 * for turning.
 *
 * @author Alex
 */
public class ZeroPointTurn extends Command {
	private double subSensitivity = 1;

	public ZeroPointTurn() {
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.oi.joystickA.getRawButton(1) || Robot.oi.joystickB.getRawButton(1)) {
			subSensitivity = Config.precisionSensitivity;
		} else {
			subSensitivity = 1;
		}
		double rotate = Robot.oi.joystickB.getSmartX() * subSensitivity;
		Robot.driveTrain.drive(0, rotate);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
