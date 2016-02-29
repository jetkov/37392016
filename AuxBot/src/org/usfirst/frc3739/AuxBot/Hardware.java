package org.usfirst.frc3739.AuxBot;

import org.usfirst.frc3739.AuxBot.commands.Autonomous;
import org.usfirst.frc3739.AuxBot.commands.UniArcadeDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class Hardware {

	private static final boolean isArchBot = false;

	private static final int leftMotorsPort = 0, rightMotorsPort = 1;

	private Joystick joystickA = new Joystick(0);
	private Joystick joystickB = new Joystick(1);

	public Hardware() {
		// SmartDashboard Buttons
		SmartDashboard.putData("Autonomous", new Autonomous());
		SmartDashboard.putNumber("Shoulder Encoder", 0.0);

		// Creating buttons
		JoystickButton triggerA = new JoystickButton(joystickA, 1);

		// Mapping buttons
		triggerA.whileHeld(new UniArcadeDrive());
	}

	public Joystick getJoystick(char joystickLetter) {
		switch (joystickLetter) {
		case 'a':
			return joystickA;
		case 'b':
			return joystickB;
		}
		return joystickA;
	}

}
