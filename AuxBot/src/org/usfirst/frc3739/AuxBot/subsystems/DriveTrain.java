package org.usfirst.frc3739.AuxBot.subsystems;

import org.usfirst.frc3739.AuxBot.commands.JoyRide;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The DriveTrain subsystem currently includes the four drivebase motors.
 *
 * @author Alex
 * @version 1.0.0b
 */
public class DriveTrain extends Subsystem {

	private RobotDrive drive;
	private Talon lMotors, rMotors;

	public DriveTrain() {
		// Talon speed controller declarations on PWM ports 1 and 2
		lMotors = new Talon(2);
		rMotors = new Talon(1);
		
		// Setting the motors to inverted
		lMotors.setInverted(true);
		rMotors.setInverted(true);
		
		// Creating new RobotDrive object
		drive = new RobotDrive(lMotors, rMotors);

		// Displaying the Talons in the LiveWindow
		LiveWindow.addActuator("Drive Train", "Left Motors", lMotors);
		LiveWindow.addActuator("Drive Train", "Right Motors", rMotors);
	}

	// Hand drivetrain over to joystick control when subsystem is idle
	public void initDefaultCommand() {
		setDefaultCommand(new JoyRide());
	}

	/**
	 * Single-stick controlled arcade style driving.
	 *
	 * @param moveStick The Joystick object that represents the forward/backward direction
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
