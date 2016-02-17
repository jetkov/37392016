package org.usfirst.frc3739.AuxBot.subsystems;

import org.usfirst.frc3739.AuxBot.commands.SplitArcadeDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The DriveTrain subsystem currently includes the two pairs of drive motors.
 *
 * @author Alex
 * @version 1.0.3b
 */
@SuppressWarnings("unused")
public class DriveTrain extends Subsystem {

	private RobotDrive drive;
	private Victor lMotors, rMotors;

	public DriveTrain() {
		// Talon speed controller declarations on PWM ports 1 and 2
		lMotors = new Victor(0);
		rMotors = new Victor(1);

		// Setting the motors to inverted (due to the gearboxes)
		lMotors.setInverted(true);
		rMotors.setInverted(true);

		// Initializing new RobotDrive object
		drive = new RobotDrive(lMotors, rMotors);

		// Displaying the Talons in the LiveWindow
		LiveWindow.addActuator("Drive Train", "Left Motors", lMotors);
		LiveWindow.addActuator("Drive Train", "Right Motors", rMotors);
	}

	// Hands the drivetrain over to joystick control when the subsystem is idle
	public void initDefaultCommand() {
		setDefaultCommand(new SplitArcadeDrive());
	}

	/**
	 * Single-stick controlled arcade style driving.
	 *
	 * @param js The joystick to use for Arcade single-stick driving. The Y-axis
	 *        will be selected for forwards/backwards and the X-axis will be
	 *        selected for rotation rate.
	 */
	public void drive(Joystick js) {
		drive.arcadeDrive(js, true);
	}

	/**
	 * Dual-stick controlled (a.k.a. East Coast?) arcade style driving.
	 *
	 * @param moveStick The Joystick object that represents the forward/backward
	 *        direction
	 * @param rotateStick The Joystick object that represents the rotation value
	 */
	public void drive(Joystick moveStick, Joystick rotateStick) {
		drive.arcadeDrive(moveStick, 1, rotateStick, 0, true);
	}

	/**
	 * Value controlled arcade style driving.
	 *
	 * @param moveValue The value to use for forwards/backwards
	 * @param rotateValue The value to use for the rotate right/left
	 */
	public void drive(double moveValue, double rotateValue) {
		drive.arcadeDrive(moveValue, rotateValue);
	}

}