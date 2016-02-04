package org.usfirst.frc3739.AuxBot;

import org.usfirst.frc3739.AuxBot.commands.Autonomous;
import org.usfirst.frc3739.AuxBot.commands.EncoderLeft180;
import org.usfirst.frc3739.AuxBot.commands.EncoderRight180;
import org.usfirst.frc3739.AuxBot.commands.JoyRide;
import org.usfirst.frc3739.AuxBot.commands.ZeroPoint;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public JoystickButton triggerA;
	public JoystickButton rightButtonA;
	public JoystickButton leftButtonA;
	public Joystick joystickA;
	public Joystick joystickB;

	public OI() {

		joystickA = new Joystick(0);
		joystickB = new Joystick(1);
		
		triggerA = new JoystickButton(joystickA, 1);
		triggerA.whileHeld(new ZeroPoint());
		leftButtonA = new JoystickButton(joystickA, 4);
		leftButtonA.whenPressed(new EncoderLeft180());
		
		rightButtonA = new JoystickButton(joystickA, 5);
		rightButtonA.whenPressed(new EncoderRight180());

		// SmartDashboard Buttons
		SmartDashboard.putData("EncoderRight180", new EncoderRight180());
		SmartDashboard.putData("EncoderLeft180", new EncoderLeft180());
		SmartDashboard.putData("JoyRide", new JoyRide());
		SmartDashboard.putData("Autonomous", new Autonomous());

	}

	public Joystick getJoystickA() {
		return joystickA;
	}
	public Joystick getJoystickB() {
		return joystickB;
	}

}
