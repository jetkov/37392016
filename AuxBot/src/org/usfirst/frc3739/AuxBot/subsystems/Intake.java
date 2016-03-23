package org.usfirst.frc3739.AuxBot.subsystems;

import org.usfirst.frc3739.AuxBot.Config;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The intake subsystem currently includes the roller inside the bucket (part of
 * the front-end loader).
 *
 * @author Alex
 */
public class Intake extends Subsystem {
	private Victor rollerMotor;

	public Intake() {
		// Declarations
		rollerMotor = new Victor(Config.loaderRollerMotorPort);
		rollerMotor.setInverted(Config.loaderRollerMotorInverted);

		// Displaying this in the LiveWindow
		LiveWindow.addActuator("Loader", "Roller", rollerMotor);
	}

	public void initDefaultCommand() {
	}

	public void log() {
	};

	public void rollIn() {
		for (double i = 0.4; i < 1; i += 0.05) { // For longevity of the plastic
													// gear...
			rollerMotor.set(i);
			Timer.delay(0.5);
		}
	}

	public void rollOut() {
		rollerMotor.set(-1);
	}

	public void killRoller() {
		rollerMotor.set(0);
	}

}
