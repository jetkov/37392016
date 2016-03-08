package org.usfirst.frc3739.AuxBot.subsystems;

import org.usfirst.frc3739.AuxBot.Config;
import org.usfirst.frc3739.AuxBot.commands.SplitArcadeDrive;
import org.usfirst.frc3739.AuxBot.utilities.SmartJoystick;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The DriveTrain subsystem currently includes the two pairs of drive motors.
 *
 * @author Alex
 * @version 1.0.3b
 */
public class DriveTrain extends Subsystem {

	private RobotDrive drive;
	private SpeedController lMotors, rMotors;
	// ADXRS450_Gyro gyro;

	// private static final double kP = 0.03;

	public DriveTrain() {
		// Speed controller declarations on PWM ports 1 and 2
		if (Config.isArchBot == true) {
			lMotors = new Victor(Config.leftDriveMotorsPort);
			rMotors = new Victor(Config.rightDriveMotorsPort);
		} else {
			lMotors = new Talon(Config.leftDriveMotorsPort);
			rMotors = new Talon(Config.rightDriveMotorsPort);
		}

		// Setting the motors to inverted (due to the gearboxes)
		lMotors.setInverted(Config.leftDriveMotorsInverted);
		rMotors.setInverted(Config.rightDriveMotorsInverted);

		// Initializing new RobotDrive object and gyro
		drive = new RobotDrive(lMotors, rMotors);
		// gyro = new ADXRS450_Gyro();

		// Displaying in the LiveWindow
		// LiveWindow.addSensor("Drive Train", "Gyro", gyro);
	}

	// Hands the drivetrain over to joystick control when the subsystem is idle
	public void initDefaultCommand() {
		setDefaultCommand(new SplitArcadeDrive());
	}

	/**
	 * Single-stick controlled arcade style driving.
	 *
	 * @param js
	 *            The joystick to use for Arcade single-stick driving. The
	 *            Y-axis will be selected for forwards/backwards and the X-axis
	 *            will be selected for rotation rate.
	 */
	public void drive(SmartJoystick js) {
		drive.arcadeDrive(js, true);
	}

	/**
	 * Dual-stick controlled (a.k.a. East Coast?) arcade style driving.
	 *
	 * @param moveStick
	 *            The Joystick object that represents the forward/backward
	 *            direction
	 * @param rotateStick
	 *            The Joystick object that represents the rotation value
	 */
	public void drive(SmartJoystick moveStick, SmartJoystick rotateStick) {
		drive.arcadeDrive(moveStick, 1, rotateStick, 0, true);
	}

	/**
	 * Value controlled arcade style driving.
	 *
	 * @param moveValue
	 *            The value to use for forwards/backwards
	 * @param rotateValue
	 *            The value to use for the rotate right/left
	 */
	public void drive(double moveValue, double rotateValue, boolean squaredInputs) {
		drive.arcadeDrive(moveValue, rotateValue, squaredInputs);
	}

	public void drive(double moveValue, double rotateValue) {
		drive.arcadeDrive(moveValue, rotateValue);
	}

	// public void autoDrive() {
	// gyro.reset();
	// double angle = gyro.getAngle();
	// drive.drive(-1.0, -angle * kP);
	// Timer.delay(0.004);
	// }

}
