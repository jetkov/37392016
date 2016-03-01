package org.usfirst.frc3739.AuxBot.commands;

import org.usfirst.frc3739.AuxBot.Robot;
import org.usfirst.frc3739.AuxBot.utilities.SmartJoystick;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Robot drives arcade style with two joysticks, controlling movement and
 * rotation separately.
 *
 * @author Alex
 * @version 1.0.1b
 */
public class SplitArcadeDrive extends Command {

	public SplitArcadeDrive() {
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartJoystick joystickA = Robot.oi.getJoystick('a');
		SmartJoystick joystickB = Robot.oi.getJoystick('b');
		if (joystickA.getSmartY() > 0.05 || joystickA.getSmartY() < 0.05) {
			Robot.driveTrain.drive(joystickA.getSmartY(), -joystickB.getSmartX(), true);
		}
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
