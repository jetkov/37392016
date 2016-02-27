package org.usfirst.frc3739.AuxBot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
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
	private Servo testServo;
	private VictorSP testJoint;
	private Encoder testEncoder;

	public Arm() {
		// Declarations
		testServo = new Servo(9);
		testJoint = new VictorSP(6);
		testEncoder = new Encoder(0, 1, true);
		testEncoder.setDistancePerPulse(0.27211);

		// Displaying these in the LiveWindow
		LiveWindow.addActuator("Arm", "Test Servo", testServo);
		LiveWindow.addActuator("Arm", "Test Joint", testJoint);
		LiveWindow.addSensor("Arm", "Test Encoder", testEncoder);
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
		double firstDist = testEncoder.getDistance();
		double currDist = firstDist;

		if (degrees > 0) {
			while (currDist < firstDist + degrees) {
				testJoint.set(1);
				currDist = testEncoder.getDistance();
				SmartDashboard.putNumber("Motor Raw", testJoint.getRaw());
				SmartDashboard.putNumber("Current Distance", currDist);
			}
			testJoint.set(0);
			SmartDashboard.putNumber("Motor Raw", testJoint.getRaw());
		}
		else if (degrees < 0) {
			while (currDist > firstDist + degrees) {
				testJoint.set(-1);
				currDist = testEncoder.getDistance();
				SmartDashboard.putNumber("Current Distance", currDist);
				SmartDashboard.putNumber("Motor Raw", testJoint.getRaw());
			}
			testJoint.set(0);
			SmartDashboard.putNumber("Motor Raw", testJoint.getRaw());
		}
		else testJoint.set(0);
		
		//testServo.setAngle(degrees);
	}
	public void stopJoint() {
		testJoint.set(0);
		Timer.delay(1);
	}

	// public boolean rotateFinsihed() {
	// return testJointCntrl.onTarget();
	// }
}
