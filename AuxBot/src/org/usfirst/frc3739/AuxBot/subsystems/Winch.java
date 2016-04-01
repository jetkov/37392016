package org.usfirst.frc3739.AuxBot.subsystems;

import org.usfirst.frc3739.AuxBot.Config;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The winch subsystem currently includes the winch motor pair.
 *
 * @author Alex
 */
public class Winch extends Subsystem {
	private Victor winchMotors;
	public static Servo lockServo;

	public Winch() {
		// Declarations
		winchMotors = new Victor(Config.winchMotorsPort);
		winchMotors.setInverted(Config.winchMotorsInverted);

		lockServo = new Servo(Config.lockServoPort);
		lockServo.setAngle(0);

		// Displaying this in the LiveWindow
		LiveWindow.addActuator("Winch", "Winch Motor", winchMotors);
		LiveWindow.addActuator("Winch", "Lock Servo", lockServo);
	}

	public void initDefaultCommand() {
	}

	public void log() {
	};

	public void setSpeed(double speed) {
		winchMotors.set(speed);
	}

	public void winchIn() {
		for (double i = 0.1; i <= 1; i += 0.05) {
			Timer.delay(0.01);
			winchMotors.set(i);
		}
	}

	public void winchOut() {
		for (double i = -0.1; i >= -1; i -= 0.05) {
			Timer.delay(0.01);
			winchMotors.set(i);
		}
	}

	public void killWinch() {
		winchMotors.set(0);
	}

	public void setLockServo(double degrees) {
		lockServo.setAngle(degrees);
		SmartDashboard.putNumber("Servo", lockServo.getAngle());
	}

	public void killServo() {
		lockServo.set(0.5);
	}
}
