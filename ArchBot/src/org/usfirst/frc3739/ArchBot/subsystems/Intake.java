package org.usfirst.frc3739.ArchBot.subsystems;

import org.usfirst.frc3739.ArchBot.Config;

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
		rollerMotor.set(1);
	}

	public void rollOut() {
		rollerMotor.set(-1);
	}

	public void killRoller() {
		rollerMotor.set(0);
	}

}
