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
	
	private Joystick joystickA = new Joystick(2);
	private Joystick joystickB = new Joystick(3);
	private Joystick joystickC = new Joystick(0);
	private Joystick joystickD = new Joystick(1);

	public OI() {
		// SmartDashboard Buttons
		SmartDashboard.putData("Grab Ball", new GrabBall());
		SmartDashboard.putData("Fire Ball", new FireBall());
		SmartDashboard.putData("Autonomous", new Autonomous());
		
		// Creating buttons
		JoystickButton triggerA = new JoystickButton(joystickA, 1);
		JoystickButton dUpD = new JoystickButton(joystickD, 3);
		JoystickButton dDownD = new JoystickButton(joystickD, 2);
		
		// Mapping buttons
		triggerA.whileHeld(new UniArcadeDrive());
		dDownD.whileHeld(new GrabBall());
		dUpD.whileHeld(new FireBall());
	}

	public Joystick getJoystick(char joystickLetter) {
		switch (joystickLetter) {
			case 'a': return joystickA;
			case 'b': return joystickB;
			case 'c': return joystickC;
			case 'd': return joystickD;
		}
		return joystickA;
	}

}
