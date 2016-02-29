package org.usfirst.frc3739.ArchBot.subsystems;

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
public class Winch extends Subsystem {
	private Victor motor;

	public Winch() {
		// Declarations
		motor = new Victor(5);

		// Displaying these in the LiveWindow
		LiveWindow.addActuator("Winch", "Winch Motor", motor);
	}

	public void initDefaultCommand() {}

	public void log() {};

}
