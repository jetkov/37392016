package org.usfirst.frc3739.AuxBot.subsystems;

import org.usfirst.frc3739.AuxBot.commands.ArmControl;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
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
public class CanadArm extends Subsystem {

	private VictorSP shoulderJoint;
	private VictorSP elbowJoint;
	private Encoder shoulderEncoder;
	private Encoder elbowEncoder;

	private static final double jointCompensateSpeed = 0.05;

	public CanadArm() {
		// Declarations
		shoulderJoint = new VictorSP(2);
		elbowJoint = new VictorSP(3);
		shoulderEncoder = new Encoder(9, 8, true);
		shoulderEncoder.setDistancePerPulse(0.27211);
		elbowEncoder = new Encoder(7, 6, true);
		elbowEncoder.setDistancePerPulse(0.27211);

		// Displaying these in the LiveWindow
		LiveWindow.addActuator("Arm", "Shoulder Joint", shoulderJoint);
		LiveWindow.addActuator("Arm", "Elbow Joint", elbowJoint);
		LiveWindow.addSensor("Arm", "Shoulder Encoder", shoulderEncoder);
		LiveWindow.addSensor("Arm", "Elbow Encoder", elbowEncoder);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ArmControl());
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

	public void setShoulderJointPosition(double shoulderSetpoint) {
		if (shoulderEncoder.getDistance() < shoulderSetpoint) {
			shoulderJoint.set(jointCompensateSpeed);
		} else if (shoulderEncoder.getDistance() > shoulderSetpoint) {
			shoulderJoint.set(-jointCompensateSpeed);
		}
	}

	public void setElbowJointPosition(double elbowSetpoint, double speed) {
		if (elbowEncoder.getDistance() < elbowSetpoint) {
			elbowJoint.set(speed);
		} else if (elbowEncoder.getDistance() > elbowSetpoint) {
			elbowJoint.set(-speed);
		}
	}

	public void killJoints() {
		shoulderJoint.set(0);
		elbowJoint.set(0);
		Timer.delay(1);
	}
}
