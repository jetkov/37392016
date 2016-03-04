package org.usfirst.frc3739.AuxBot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class Hardware {

	public static boolean isArchBot = false;
	public static final int leftMotorsPort = 0, rightMotorsPort = 1;
	
	public static final double subSensitivity = 0.5;
	public static final double rotateValueCurveModifier = 4;
	public static final double turnTrim = 0;

}
