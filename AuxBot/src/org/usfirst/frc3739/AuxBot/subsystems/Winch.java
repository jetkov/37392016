package org.usfirst.frc3739.AuxBot.subsystems;

import org.usfirst.frc3739.AuxBot.Config;

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

	public Winch() {
		// Declarations
		winchMotors = new Victor(Config.winchMotorsPort);
		winchMotors.setInverted(Config.winchMotorsInverted);

		// Displaying this in the LiveWindow
		LiveWindow.addActuator("Winch", "Winch Motor", winchMotors);
	}

	public void initDefaultCommand() {
	}

	public void log() {
	};

	public void winchUp() {
		winchMotors.set(1);
	}

	public void winchDown() {
		winchMotors.set(-1);
	}

	public void killwinch() {
		winchMotors.set(0);
	}

}
