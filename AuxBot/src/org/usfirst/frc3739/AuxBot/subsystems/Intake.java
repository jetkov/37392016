package org.usfirst.frc3739.AuxBot.subsystems;

import org.usfirst.frc3739.AuxBot.Config;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The Arm subsystem will include the shoulder and elbow joint actuators of the
 * arm, their encoders, and sensors related to the relative movement of the arm.
 * Currently it only includes a test joint actuator and its encoder.
 *
 * @author Alex
 * @version 1.0.0a
 */
public class Intake extends Subsystem {
	private Victor rollerMotor;

	public Intake() {
		// Declarations
		rollerMotor = new Victor(Config.loaderRollerMotorPort);

		// Displaying these in the LiveWindow
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
