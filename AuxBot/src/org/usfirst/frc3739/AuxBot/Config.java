package org.usfirst.frc3739.AuxBot;

/**
 * This class contains all hardware-dependent configuration--port mapping,
 * hardware constants, motor inversions, etc...
 *
 * @author Alex
 */
public class Config {

	// Is this the main or auxiliary robot?
	public static boolean isArchBot = true;

	// ARCHBOT CONFIGURATION

	///////////////////////////////////////////////////////////////////////////////////////

	// AUXBOT CONFIGURATION

	// Computer port configurations
	public static final int joystickA = 1;
	public static final int joystickB = 2;
	public static final int joystickC = 0;

	// Robot port configurations
	public static final int leftDriveMotorsPort = 0, rightDriveMotorsPort = 1, scissorMotorPort = 2,
			loaderJointMotorPort = 3, loaderRollerMotorPort = 4, winchMotorsPort = 5, lockServoPort = 6;

	// Motor Polarity
	public static final boolean leftDriveMotorsInverted = true, rightDriveMotorsInverted = true,
			scissorMotorInverted = true, loaderJointMotorInverted = false, loaderRollerMotorInverted = true,
			winchMotorsInverted = false;

	// Split Arcade drive control
	public static final double precisionSensitivity = 0.5, turnValueThreshold = 0.05, turnValueCurveModifier = 4,
			turnTrim = 0;

	// Gyro Straight Drive Trim
	public static final double gyroDriveTrim = 0.03;

}
