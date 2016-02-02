package org.usfirst.frc3739.AuxBot;

import org.usfirst.frc3739.AuxBot.commands.Autonomous;
import org.usfirst.frc3739.AuxBot.commands.EncoderLeft180;
import org.usfirst.frc3739.AuxBot.commands.EncoderRight180;
import org.usfirst.frc3739.AuxBot.commands.JoyRide;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public JoystickButton rightButton;
	public JoystickButton leftButton;
	public Joystick joystick;

	public OI() {

		joystick = new Joystick(0);

		leftButton = new JoystickButton(joystick, 4);
		leftButton.whenPressed(new EncoderLeft180());
		rightButton = new JoystickButton(joystick, 5);
		rightButton.whenPressed(new EncoderRight180());

		// SmartDashboard Buttons
		SmartDashboard.putData("EncoderRight180", new EncoderRight180());
		SmartDashboard.putData("EncoderLeft180", new EncoderLeft180());
		SmartDashboard.putData("JoyRide", new JoyRide());
		SmartDashboard.putData("Autonomous", new Autonomous());

	}

	public Joystick getJoystick() {
		return joystick;
	}

}
