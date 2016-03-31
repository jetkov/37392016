package org.usfirst.frc3739.ArchBot.subsystems;

import org.usfirst.frc3739.ArchBot.Config;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

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
		lockServo.set(0.5);

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
		while (lockServo.getAngle() < degrees) {
			lockServo.set(1);
		}
		while (lockServo.getAngle() > degrees) {
			lockServo.set(-1);
		}
	}

	public void killServo() {
		lockServo.set(0.5);
	}
}
