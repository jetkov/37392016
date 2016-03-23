package org.usfirst.frc3739.AuxBot.commands;

import org.usfirst.frc3739.AuxBot.Config;
import org.usfirst.frc3739.AuxBot.Robot;
import org.usfirst.frc3739.AuxBot.utilities.SmartJoystick;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Robot drives arcade style with two joysticks, controlling movement and
 * rotation separately.
 *
 * @author Alex
 */
public class SplitArcadeDrive extends Command {

	private double subSensitivity;

	public SplitArcadeDrive(boolean subsensitized) {
		requires(Robot.driveTrain);

		if (subsensitized) {
			subSensitivity = Config.precisionSensitivity;
		} else {
			subSensitivity = 1;
		}
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartJoystick joystickA = Robot.oi.getJoystick('a');
		SmartJoystick joystickB = Robot.oi.getJoystick('b');

		double joyBX = joystickB.getSmartX();

		double throttle = joystickA.getSmartY();
		double rotate = joyBX
				* (Math.log(Math.abs(throttle) - Config.rotateValueThreshold) / Config.rotateValueCurveModifier + 1);

		Robot.driveTrain.drive(throttle * subSensitivity, (-rotate * subSensitivity) + Config.turnTrim);
		SmartDashboard.putNumber("Throttle", throttle);
		SmartDashboard.putNumber("Rotate", rotate);
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
