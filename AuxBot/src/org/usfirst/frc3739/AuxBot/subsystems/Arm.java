package org.usfirst.frc3739.AuxBot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.VictorSP;
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
public class Arm extends Subsystem {
	private VictorSP testJoint;
	private Encoder testEncoder;
	private PIDController testJointCntrl;

	public Arm() {
		// Declarations
		testJoint = new VictorSP(6);
		testEncoder = new Encoder(0, 1);
		testJointCntrl = new PIDController(0.1, 0.001, 0.0, testEncoder, testJoint);

		// Displaying these in the LiveWindow
		LiveWindow.addActuator("Arm", "Test Joint", testJoint);
		LiveWindow.addSensor("Arm", "Test Encoder", testEncoder);
		LiveWindow.addActuator("Arm", "Test Joint PID", testJointCntrl);
	}

	public void initDefaultCommand() {
	}

	public void log() {
		SmartDashboard.putNumber("Test Encoder Count", testEncoder.get());
		SmartDashboard.putNumber("Test Encoder Distance", testEncoder.getDistance());
		SmartDashboard.putNumber("Test Encoder Rate", testEncoder.getRate());
	};

	/**
	 * Rotates the joint to the specified degree.
	 *
	 * @param degrees The amount for the joint to rotate
	 */
	public void rotateJoint(double degrees) {
		testEncoder.reset();
		testJointCntrl.enable();
		testJointCntrl.setSetpoint(degrees);
	}

	// public boolean rotateFinsihed() {
	// return testJointCntrl.onTarget();
	// }
}
