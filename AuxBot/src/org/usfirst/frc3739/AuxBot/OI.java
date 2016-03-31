package org.usfirst.frc3739.AuxBot;

import org.usfirst.frc3739.AuxBot.commands.AThomas;
import org.usfirst.frc3739.AuxBot.commands.GyroStraightDrive;
import org.usfirst.frc3739.AuxBot.commands.LiftSystemUp;
import org.usfirst.frc3739.AuxBot.commands.LockWinch;
import org.usfirst.frc3739.AuxBot.commands.RollInBall;
import org.usfirst.frc3739.AuxBot.commands.RollOutBall;
import org.usfirst.frc3739.AuxBot.commands.ScissorDown;
import org.usfirst.frc3739.AuxBot.commands.ScissorUp;
import org.usfirst.frc3739.AuxBot.commands.UnlockWinch;
import org.usfirst.frc3739.AuxBot.commands.WinchIn;
import org.usfirst.frc3739.AuxBot.commands.WinchOut;
import org.usfirst.frc3739.AuxBot.commands.ZeroPointTurn;
import org.usfirst.frc3739.AuxBot.utilities.SmartJoystick;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public SmartJoystick joystickA = new SmartJoystick(Config.joystickA);
	public SmartJoystick joystickB = new SmartJoystick(Config.joystickB);
	private SmartJoystick joystickC = new SmartJoystick(Config.joystickC);

	public OI() {
		// SmartDashboard Buttons
		SmartDashboard.putData("Autonomous", new AThomas());
		SmartDashboard.putData("Scissor Up", new ScissorUp());
		SmartDashboard.putData("Scissor Down", new ScissorDown());
		SmartDashboard.putData("Lift System Up", new LiftSystemUp());

		// Creating buttons
		JoystickButton aDPadUp = new JoystickButton(joystickA, 3);
		JoystickButton aDPadDn = new JoystickButton(joystickA, 2);
		JoystickButton bDPadUp = new JoystickButton(joystickB, 3);
		JoystickButton bDPadDn = new JoystickButton(joystickB, 2);
		JoystickButton cDPadUp = new JoystickButton(joystickC, 3);
		JoystickButton cDPadDn = new JoystickButton(joystickC, 2);
		JoystickButton cBPadRghtUp = new JoystickButton(joystickC, 11);
		JoystickButton cBPadRghtDn = new JoystickButton(joystickC, 10);
		JoystickButton cBPadLeftUp = new JoystickButton(joystickC, 6);
		JoystickButton cBPadLeftDn = new JoystickButton(joystickC, 7);
		JoystickButton cBpadBkLeft = new JoystickButton(joystickC, 8);
		JoystickButton cBpadBkRght = new JoystickButton(joystickC, 9);

		// Mapping buttons
		aDPadDn.whileHeld(new ZeroPointTurn());
		bDPadDn.whileHeld(new ZeroPointTurn());
		aDPadUp.whileHeld(new GyroStraightDrive());
		bDPadUp.whileHeld(new GyroStraightDrive());

		cDPadUp.whileHeld(new RollOutBall());
		cDPadDn.whileHeld(new RollInBall());

		cBPadRghtUp.whileHeld(new ScissorUp());
		cBPadRghtDn.whileHeld(new ScissorDown());

		cBPadLeftUp.whileHeld(new WinchOut());
		cBPadLeftDn.whileHeld(new WinchIn());

		cBpadBkLeft.whileHeld(new UnlockWinch());
		cBpadBkRght.whileHeld(new LockWinch());

	}

	public SmartJoystick getJoystick(char joystickLetter) {
		switch (joystickLetter) {
		case 'a':
			return joystickA;
		case 'b':
			return joystickB;
		case 'c':
			return joystickC;
		}
		return joystickC;
	}

}
