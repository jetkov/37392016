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

	// // Computer port configurations
	// public static final int joystickA = 1;
	// public static final int joystickB = 2;
	// public static final int joystickC = 0;
	//
	// // Robot port configurations
	// public static final int leftDriveMotorsPort = 0, rightDriveMotorsPort =
	// 1, scissorMotorPort = 9,
	// loaderJointMotorPort = 7, loaderRollerMotorPort = 8, winchMotorsPort = 6;
	//
	// // Motor Polarity
	// public static final boolean leftDriveMotorsInverted = false,
	// rightDriveMotorsInverted = false,
	// scissorMotorInverted = true, loaderJointMotorInverted = false,
	// loaderRollerMotorInverted = true,
	// winchMotorsInverted = false;
	//
	// // Split Arcade drive control
	// public static final double precisionSensitivity = 0.5,
	// rotateValueThreshold = 0.05, rotateValueCurveModifier = 4,
	// turnTrim = -0.15;
	//
	// // Gyro Straight Drive Trim
	// public static final double gyroDriveTrim = 0.03;

	///////////////////////////////////////////////////////////////////////////////////////

	// AUXBOT CONFIGURATION

	// Computer port configurations
	public static final int joystickA = 1;
	public static final int joystickB = 2;
	public static final int joystickC = 0;

	// Robot port configurations
	public static final int leftDriveMotorsPort = 0, rightDriveMotorsPort = 1, scissorMotorPort = 9,
			loaderJointMotorPort = 7, loaderRollerMotorPort = 8, winchMotorsPort = 6;

	// Motor Polarity
	public static final boolean leftDriveMotorsInverted = false, rightDriveMotorsInverted = false,
			scissorMotorInverted = true, loaderJointMotorInverted = false, loaderRollerMotorInverted = true,
			winchMotorsInverted = false;

	// Split Arcade drive control
	public static final double precisionSensitivity = 0.5, rotateValueThreshold = 0.05, rotateValueCurveModifier = 4,
			turnTrim = -0.15;

	// Gyro Straight Drive Trim
	public static final double gyroDriveTrim = 0.03;

}
