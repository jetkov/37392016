package org.usfirst.frc3739.ArchBot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The Arm subsystem will include the shoulder and elbow joint actuators of the
 * arm, their encoders, and sensors related to the relative movement of the arm.
 * Currently it only includes a test joint actuator and its encoder.
 *
 * @author Alex
 * @version 1.0.0a
 */
public class Hand extends Subsystem {
	private Victor motors;
	private DigitalInput contact;

	public Hand() {
		// Declarations
		motors = new Victor(4);
		contact = new DigitalInput(5);

		// Displaying these in the LiveWindow
		LiveWindow.addActuator("Hand", "Grab Motors", motors);
		LiveWindow.addSensor("Hand", "Ball Contact", contact);
	}

	public void initDefaultCommand() {}

	public void log() {
		SmartDashboard.putBoolean("Ball Contact", contact.get());
	};
	
	public void grab() {
		motors.set(1);
	}
	
	public void fire() {
		motors.set(-1);
	}
	
	public void stop() {
		motors.set(0);
	}
	
	public boolean grabComplete() {
		return contact.get();
	}

}
