package org.usfirst.frc3739.AuxBot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class Config {

	// Is this the main or auxiliary robot?
	public static boolean isArchBot = false;

	// Port configurations
	public static final int leftMotorsPort = 0, rightMotorsPort = 1;
	public static final int loaderJointMotorPort = 8, loaderRollerMotorPort = 9;

	// Split Arcade drive control
	public static final double precisionSensitivity = 0.5;
	public static final double rotateValueThreshold = 0.05;
	public static final double rotateValueCurveModifier = 4;
	public static final double turnTrim = 0;

}
