package org.usfirst.frc3739.AuxBot.subsystems;

import org.usfirst.frc3739.AuxBot.Config;
import org.usfirst.frc3739.AuxBot.commands.OperateLoader;

import edu.wpi.first.wpilibj.Talon;
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
public class Loader extends Subsystem {
	private Talon jointMotor;

	public Loader() {
		// Declarations
		jointMotor = new Talon(Config.loaderJointMotorPort);

		// Displaying these in the LiveWindow
		LiveWindow.addActuator("Loader", "Joint", jointMotor);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new OperateLoader());
	}

	public void log() {};
	
	public void setJointSpeed(double speed) {
		jointMotor.set(speed);
	}
	
	public void killJoint() {
		jointMotor.set(0);
	}

}
