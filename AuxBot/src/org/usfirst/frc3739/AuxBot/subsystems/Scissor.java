package org.usfirst.frc3739.AuxBot.subsystems;

import org.usfirst.frc3739.AuxBot.Config;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The intake subsystem currently includes the roller inside the bucket (part of
 * the front-end loader).
 *
 * @author Alex
 */
public class Scissor extends Subsystem {
	private Victor scissorMotor;

	public Scissor() {
		// Declarations
		scissorMotor = new Victor(Config.scissorMotorPort);
		scissorMotor.setInverted(Config.scissorMotorInverted);

		// Displaying this in the LiveWindow
		LiveWindow.addActuator("Scissor", "Scissor Motor", scissorMotor);
	}

	public void initDefaultCommand() {
	}

	public void log() {
	};

	public void setSpeed(double speed) {
		scissorMotor.set(speed);
	}

	public void scissorUp() {
		scissorMotor.set(1);
	}

	public void scissorDown() {
		scissorMotor.set(-1);
	}

	public void killScissor() {
		scissorMotor.set(0);
	}

}
