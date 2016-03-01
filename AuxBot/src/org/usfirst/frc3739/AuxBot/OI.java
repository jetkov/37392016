package org.usfirst.frc3739.AuxBot;

import org.usfirst.frc3739.AuxBot.commands.Autonomous;
import org.usfirst.frc3739.AuxBot.commands.UniArcadeDrive;
import org.usfirst.frc3739.AuxBot.commands.ZeroPointTurn;
import org.usfirst.frc3739.AuxBot.utilities.SmartJoystick;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private SmartJoystick joystickA = new SmartJoystick(0);
	private SmartJoystick joystickB = new SmartJoystick(1);

	public OI() {
		// SmartDashboard Buttons
		SmartDashboard.putData("Autonomous", new Autonomous());

		// Creating buttons
		JoystickButton triggerA = new JoystickButton(joystickA, 1);
		JoystickButton triggerB = new JoystickButton(joystickB, 1);

		// Mapping buttons
		triggerA.whileHeld(new UniArcadeDrive());
		triggerB.whileHeld(new ZeroPointTurn());
	}

	public SmartJoystick getJoystick(char joystickLetter) {
		switch (joystickLetter) {
		case 'a':
			return joystickA;
		case 'b':
			return joystickB;
		}
		return joystickA;
	}

}
