package org.usfirst.frc3739.ArchBot.commands;

import org.usfirst.frc3739.ArchBot.Config;
import org.usfirst.frc3739.ArchBot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Robot drives arcade style with two joysticks, controlling movement and
 * rotation separately.
 *
 * @author Alex
 */
public class SplitArcadeDrive extends Command {

	private double subSensitivity = 1;

	public SplitArcadeDrive(boolean subsensitized) {
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

		double joyBX = Robot.oi.joystickB.getSmartX();

		double throttle = Robot.oi.joystickA.getSmartY();

		// By using a logarithmic function to create a curve, the smooth
		// modification of the rotate joystick's sensitivity, depending in the
		// throttle value, is possible.
		// Choosing the greater value of either zero or the modifier causes
		// below-threshold values to be eliminated.
		double rotate = joyBX * Math.max(0,
				(Math.log(Math.abs(throttle) - Config.turnValueThreshold) / Config.turnValueCurveModifier + 1));

		throttle *= subSensitivity;
		rotate = rotate * subSensitivity + Config.turnTrim;

		Robot.driveTrain.drive(throttle, rotate);

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
