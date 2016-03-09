package org.usfirst.frc3739.AuxBot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class Config {

	// Is this the main or auxiliary robot?
	public static boolean isArchBot = false;
	
	// Computer port configurations
	public static final int joystickA = 0;
	public static final int joystickB = 1;
	public static final int joystickC = 2;

	// Robot port configurations
	public static final int leftDriveMotorsPort = 0, rightDriveMotorsPort = 1;
	public static final int loaderJointMotorPort = 8, loaderRollerMotorPort = 9;
	
	// Motor Polarity
	public static final boolean leftDriveMotorsInverted = false;
	public static final boolean rightDriveMotorsInverted = false;
	
	public static final boolean loaderJointMotorInverted = true;
	public static final boolean loaderRollerMotorInverted = false;
	
	// Split Arcade drive control
	public static final double precisionSensitivity = 0.5;
	public static final double rotateValueThreshold = 0.05;
	public static final double rotateValueCurveModifier = 4;
	public static final double turnTrim = -0.15;

}
