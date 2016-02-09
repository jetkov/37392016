package org.usfirst.frc3739.AuxBot;

import org.usfirst.frc3739.AuxBot.commands.UniArcadeDrive;
import org.usfirst.frc3739.AuxBot.commands.Autonomous;
import org.usfirst.frc3739.AuxBot.commands.FireBall;
import org.usfirst.frc3739.AuxBot.commands.GrabBall;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick joystickA = new Joystick(0);
	private Joystick joystickB = new Joystick(1);

	public OI() {
		
		// SmartDashboard Buttons
		SmartDashboard.putData("Grab Ball", new GrabBall());
		SmartDashboard.putData("Fire Ball", new FireBall());
		SmartDashboard.putData("Autonomous", new Autonomous());
		
		// Creating buttons
		JoystickButton triggerA = new JoystickButton(joystickA, 1);
		JoystickButton dUpA = new JoystickButton(joystickA, 3);
		JoystickButton dDownA = new JoystickButton(joystickA, 2);
		
		// Mapping buttons
		triggerA.whileHeld(new UniArcadeDrive());
		dDownA.whileHeld(new GrabBall());
		dUpA.whileHeld(new FireBall());

	}

	public Joystick getJoystickA() {
		return joystickA;
	}

	public Joystick getJoystickB() {
		return joystickB;
	}

}
