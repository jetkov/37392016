package org.usfirst.frc3739.AuxBot.subsystems;

import org.usfirst.frc3739.AuxBot.commands.JoyRide;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
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
	private SpeedController flMotor, blMotor, frMotor, brMotor;

	public DriveTrain() {
		// Declarations (with Talons on PWM ports 1-4)
		flMotor = new Talon(4);
		blMotor = new Talon(3);
		frMotor = new Talon(2);
		brMotor = new Talon(1);
		drive = new RobotDrive(blMotor, flMotor, brMotor, frMotor);

		// Displaying the Talons in the LiveWindow
		LiveWindow.addActuator("Drive Train", "Front Left Motor", (Talon) flMotor);
		LiveWindow.addActuator("Drive Train", "Back Left Motor", (Talon) blMotor);
		LiveWindow.addActuator("Drive Train", "Front Right Motor", (Talon) frMotor);
		LiveWindow.addActuator("Drive Train", "Back Right Motor", (Talon) brMotor);
	}

	// Hand drivetrain over to joystick control when subsystem is idle
	public void initDefaultCommand() {
		setDefaultCommand(new JoyRide());
	}

	/**
	 * Single-stick controlled arcade style driving.
	 *
	 * @param js The joystick to use to drive singlehandedly
	 */
	public void drive(Joystick js) {
		drive.arcadeDrive(js);
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
