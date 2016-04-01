package org.usfirst.frc3739.AuxBot.subsystems;

import org.usfirst.frc3739.AuxBot.Config;
import org.usfirst.frc3739.AuxBot.commands.SplitArcadeDrive;
import org.usfirst.frc3739.AuxBot.utilities.SmartJoystick;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The DriveTrain subsystem currently includes the two pairs of drive motors,
 * and the gyro.
 *
 * @author Alex
 */
public class DriveTrain extends Subsystem {

	private SpeedController lMotors, rMotors;
	private RobotDrive drive;
	private BuiltInAccelerometer accel;

	public DriveTrain() {
		// Speed controller declarations
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
		accel = new BuiltInAccelerometer();

		// Displaying in the LiveWindow
		LiveWindow.addSensor("Drive Train", "Accelerometer", accel);
	}

	// Hands the drivetrain over to dual joystick control when the subsystem is
	// idle
	public void initDefaultCommand() {
		setDefaultCommand(new SplitArcadeDrive(false));
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
	 * @param throttleStick
	 *            The Joystick object that represents the forward/backward
	 *            direction
	 * @param rotateStick
	 *            The Joystick object that represents the rotation value
	 */
	public void drive(SmartJoystick throttleStick, SmartJoystick rotateStick) {
		drive.arcadeDrive(throttleStick, 1, rotateStick, 0, true);
	}

	/**
	 * Value controlled arcade style driving.
	 *
	 * @param throttleValue
	 *            The value to use for forwards/backwards
	 * @param rotateValue
	 *            The value to use for the rotate right/left
	 * @param squaredInputs
	 *            If this is true, the sensitivity is decreased at lower speeds
	 */
	public void drive(double throttleValue, double rotateValue, boolean squaredInputs) {
		drive.arcadeDrive(throttleValue, rotateValue, squaredInputs);
	}

	/**
	 * Value controlled arcade style driving.
	 *
	 * @param throttleValue
	 *            The value to use for forwards/backwards
	 * @param rotateValue
	 *            The value to use for the rotate right/left
	 */
	public void drive(double throttleValue, double rotateValue) {
		drive.arcadeDrive(throttleValue, rotateValue);
	}

	/**
	 * Throttle is controlled via input, but rotation rotation output is
	 * controlled by the gyro. This means that the bot will correct itself and
	 * continue to drive straight even if it gets hit or while driving over
	 * rough terrain.
	 *
	 * @param throttleValue
	 *            The value to use for forwards/backwards
	 */

	// Returns the accelerometer
	public BuiltInAccelerometer getAccel() {
		return accel;
	}

}
