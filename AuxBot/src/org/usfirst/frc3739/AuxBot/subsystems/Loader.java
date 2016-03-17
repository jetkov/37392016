package org.usfirst.frc3739.AuxBot.subsystems;

import org.usfirst.frc3739.AuxBot.Config;
import org.usfirst.frc3739.AuxBot.commands.OperateLoader;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The Loader subsystem currently is the front-end loader on the bot, while it
 * includes specifically the single joint actuator mating its arm section to the
 * channel mount.
 *
 * @author Alex
 */
public class Loader extends Subsystem {
	private Talon jointMotor;

	public Loader() {
		// Declarations
		jointMotor = new Talon(Config.loaderJointMotorPort);
		jointMotor.setInverted(Config.loaderJointMotorInverted);

		// Displaying these in the LiveWindow
		LiveWindow.addActuator("Loader", "Joint", jointMotor);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new OperateLoader());
	}

	public void log() {
	};

	public void setJointSpeed(double speed) {
		jointMotor.set(speed);
	}

	public void killJoint() {
		jointMotor.set(0);
	}

}
