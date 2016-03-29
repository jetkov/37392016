package org.usfirst.frc3739.AuxBot.commands;

import org.usfirst.frc3739.AuxBot.Config;
import org.usfirst.frc3739.AuxBot.Robot;
import org.usfirst.frc3739.AuxBot.utilities.LogitechDualAction;
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

	private double subSensitivity = 1;

	private LogitechDualAction driveController = Robot.oi.driveController;
	private SmartJoystick joystickA = Robot.oi.joystickA;
	private SmartJoystick joystickB = Robot.oi.joystickB;

	public SplitArcadeDrive(boolean subsensitized) {
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double rawTurn, throttle;

		if (Config.usingDriveController) {

			if (driveController.getRawButton(0) || driveController.getRawButton(0)) {
				subSensitivity = Config.precisionSensitivity;
			} else {
				subSensitivity = 1;
			}

			throttle = driveController.getLY();
			rawTurn = driveController.getRX();
		} else {

			if (joystickA.getRawButton(1) || joystickB.getRawButton(1)) {
				subSensitivity = Config.precisionSensitivity;
			} else {
				subSensitivity = 1;
			}

			throttle = joystickA.getSmartY();
			rawTurn = joystickB.getSmartX();
		}

		// By using a logarithmic function to create a curve, the smooth
		// modification of the turn joystick's sensitivity, depending in the
		// throttle value, is possible.
		// Choosing the greater value of either zero or the modifier causes
		// below-threshold values to be eliminated.
		double turn = rawTurn * Math.max(0,
				(Math.log(Math.abs(throttle) - Config.turnValueThreshold) / Config.turnValueCurveModifier + 1));

		throttle *= subSensitivity;
		turn += -turn * subSensitivity + Config.turnTrim;

		Robot.driveTrain.drive(throttle, turn);

		SmartDashboard.putNumber("Throttle", throttle);
		SmartDashboard.putNumber("Turn", turn);
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
