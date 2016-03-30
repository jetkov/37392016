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

	// ARCHBOT CONFIGURATION

	///////////////////////////////////////////////////////////////////////////////////////

	// AUXBOT CONFIGURATION

	// Are we using controllers?
	public static final boolean usingOperatorController = false, usingDriveController = false;

	// Computer port configurations
	public static final int operatorControllerPort = 0, driveControllerPort = 1;

	public static final int joystickAPort = 1, joystickBPort = 2, joystickCPort = 0;

	// Robot port configurations
	public static final int leftDriveMotorsPort = 0, rightDriveMotorsPort = 1, scissorMotorPort = 9,
			loaderJointMotorPort = 7, loaderRollerMotorPort = 8, winchMotorsPort = 5;

	// Motor Polarity
	public static final boolean leftDriveMotorsInverted = false, rightDriveMotorsInverted = false,
			scissorMotorInverted = true, loaderJointMotorInverted = false, loaderRollerMotorInverted = true,
			winchMotorsInverted = false;

	// Split Arcade drive control
	public static final double precisionSensitivity = 0.5, turnValueThreshold = 0.05, turnValueCurveModifier = 4,
			turnTrim = -0.15;

	// Gyro Straight Drive Trim
	public static final double gyroDriveTrim = 0.03;

}
