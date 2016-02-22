package org.usfirst.frc3739.AuxBot.subsystems;

import org.usfirst.frc3739.AuxBot.commands.OperateArm;

import edu.wpi.first.wpilibj.Encoder;
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
public class CanadArm extends Subsystem {
	//private Servo testServo;
	private VictorSP shoulderJoint;
	private VictorSP elbowJoint;
	private Encoder shoulderEncoder;
	private Encoder elbowEncoder;
	//private PIDController testPID;
	final double pGain = 0, iGain = 0, dGain = 0; 
	public CanadArm() {
		// Declarations
		//testServo = new Servo(9);
		shoulderJoint = new VictorSP(2);
		elbowJoint = new VictorSP(3);
		shoulderEncoder = new Encoder(9, 8, true);
		shoulderEncoder.setDistancePerPulse(0.27211);
		elbowEncoder = new Encoder(7, 6, true);
		elbowEncoder.setDistancePerPulse(0.27211);
		//testPID = new PIDController(pGain, iGain, dGain, testEncoder, testJoint);

		// Displaying these in the LiveWindow
		//LiveWindow.addActuator("Arm", "Test Servo", testServo);
		LiveWindow.addActuator("Arm", "Shoulder Joint", shoulderJoint);
		LiveWindow.addActuator("Arm", "Elbow Joint", elbowJoint);
		LiveWindow.addSensor("Arm", "Shoulder Encoder", shoulderEncoder);
		LiveWindow.addSensor("Arm", "Elbow Encoder", elbowEncoder);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new OperateArm());
	}

	public void log() {
	}
	
	public double getShoulderEncoderDistance() {
		return shoulderEncoder.getDistance();
	}
	
	public double getElbowEncoderDistance() {
		return elbowEncoder.getDistance();
	}

	public void setShoulderJointSpeed(double speed) {
		shoulderJoint.set(speed);
	}
	public void setElbowJointSpeed(double speed) {
		elbowJoint.set(speed);
	}
	/**
	 * Rotates the joint to the specified degree.
	 *
	 * @param degrees The amount for the joint to rotate
	 */
	public void rotateShoulderJoint(double degrees) {
		double firstDist = shoulderEncoder.getDistance();
		double currDist = firstDist;

		if (degrees > 0) {
			while (currDist < firstDist + degrees) {
				shoulderJoint.set(0.5);
				currDist = shoulderEncoder.getDistance();
				SmartDashboard.putNumber("Motor Raw", shoulderJoint.getRaw());
				SmartDashboard.putNumber("Current Distance", currDist);
			}
			shoulderJoint.set(0);
			SmartDashboard.putNumber("Motor Raw", shoulderJoint.getRaw());
		}
		else if (degrees < 0) {
			while (currDist > firstDist + degrees) {
				shoulderJoint.set(-0.5);
				currDist = shoulderEncoder.getDistance();
				SmartDashboard.putNumber("Current Distance", currDist);
				SmartDashboard.putNumber("Motor Raw", shoulderJoint.getRaw());
			}
			shoulderJoint.set(0);
			SmartDashboard.putNumber("Motor Raw", shoulderJoint.getRaw());
		}
		else shoulderJoint.set(0);
		
		//testServo.setAngle(degrees);
	}
	public void setJoints(double shoulderStopLocation, double elbowStopLocation) {
		if (shoulderEncoder.getDistance() < shoulderStopLocation) {
			shoulderJoint.set(-0.4);
		}
		else if (shoulderEncoder.getDistance() > shoulderStopLocation) {
			shoulderJoint.set(0.4);
		}
		if (elbowEncoder.getDistance() < elbowStopLocation) {
			elbowJoint.set(-0.4);
		}
		else if (elbowEncoder.getDistance() > elbowStopLocation) {
			elbowJoint.set(0.4);
		}
	}
	public void killJoints() {
		shoulderJoint.set(0);
		elbowJoint.set(0);
		Timer.delay(1);
	}
}
