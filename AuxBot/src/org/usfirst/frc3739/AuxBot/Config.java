package org.usfirst.frc3739.AuxBot;

/**
 * This class contains all hardware-dependent configuration--port mapping,
 * hardware constants, motor inversions, etc...
 * 
 * @author Alex
 */
public class Config {

	// Is this the main or auxiliary robot?
	public static boolean isArchBot = false;

	// Computer port configurations
	public static final int joystickA = 1;
	public static final int joystickB = 2;
	public static final int joystickC = 0;

	// Robot port configurations
	public static final int leftDriveMotorsPort = 0, rightDriveMotorsPort = 1;
	public static final int scissorMotorPort = 9;
	public static final int loaderJointMotorPort = 7, loaderRollerMotorPort = 8;

	// Motor Polarity
	public static final boolean leftDriveMotorsInverted = false;
	public static final boolean rightDriveMotorsInverted = false;
	public static final boolean scissorMotorInverted = true;
	public static final boolean loaderJointMotorInverted = false;
	public static final boolean loaderRollerMotorInverted = true;

	// Split Arcade drive control
	public static final double precisionSensitivity = 0.5;
	public static final double rotateValueThreshold = 0.05;
	public static final double rotateValueCurveModifier = 4;
	public static final double turnTrim = -0.15;

	// Gyro Straight Drive Trim
	public static final double gyroDriveTrim = 0.03;

}
