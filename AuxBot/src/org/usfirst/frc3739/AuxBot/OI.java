package org.usfirst.frc3739.AuxBot;

import org.usfirst.frc3739.AuxBot.commands.Autonomous;
import org.usfirst.frc3739.AuxBot.commands.GyroStraightDrive;
import org.usfirst.frc3739.AuxBot.commands.LiftSystemUp;
import org.usfirst.frc3739.AuxBot.commands.RollInBall;
import org.usfirst.frc3739.AuxBot.commands.RollOutBall;
import org.usfirst.frc3739.AuxBot.commands.ScissorDown;
import org.usfirst.frc3739.AuxBot.commands.ScissorUp;
import org.usfirst.frc3739.AuxBot.commands.WinchIn;
import org.usfirst.frc3739.AuxBot.commands.WinchOut;
import org.usfirst.frc3739.AuxBot.commands.ZeroPointTurn;
import org.usfirst.frc3739.AuxBot.utilities.LogitechDualAction;
import org.usfirst.frc3739.AuxBot.utilities.LogitechWingman;
import org.usfirst.frc3739.AuxBot.utilities.SmartJoystick;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public LogitechWingman operatorController;
	public LogitechDualAction driveController;

	public SmartJoystick joystickA;
	public SmartJoystick joystickB;
	public SmartJoystick joystickC;

	public OI() {
		if (Config.usingOperatorController) {
			// Declaring controller
			operatorController = new LogitechWingman(Config.operatorControllerPort);
		} else {
			// Declaring joystick
			joystickC = new SmartJoystick(Config.joystickCPort);

			// Creating buttons
			JoystickButton cDPadUp = new JoystickButton(joystickC, 3);
			JoystickButton cDPadDn = new JoystickButton(joystickC, 2);
			JoystickButton cBPadRghtUp = new JoystickButton(joystickC, 11);
			JoystickButton cBPadRghtDn = new JoystickButton(joystickC, 10);
			JoystickButton cBPadLeftUp = new JoystickButton(joystickC, 6);
			JoystickButton cBPadLeftDn = new JoystickButton(joystickC, 7);

			// Mapping buttons
			cDPadUp.whileHeld(new RollOutBall());
			cDPadDn.whileHeld(new RollInBall());

			cBPadRghtUp.whileHeld(new ScissorUp());
			cBPadRghtDn.whileHeld(new ScissorDown());

			cBPadLeftUp.whileHeld(new WinchOut());
			cBPadLeftDn.whileHeld(new WinchIn());
		}

		if (Config.usingDriveController) {
			// Declaring controller
			driveController = new LogitechDualAction(Config.driveControllerPort);

			// Creating buttons
			JoystickButton leftBmpr = new JoystickButton(driveController, 5);
			JoystickButton rghtBmpr = new JoystickButton(driveController, 6);

			// Mapping buttons
			// leftBmpr.whileHeld(new ZeroPointTurn());
			// rghtBmpr.whileHeld(new ZeroPointTurn());
		} else {
			// Declaring joysticks
			joystickA = new SmartJoystick(Config.joystickAPort);
			joystickB = new SmartJoystick(Config.joystickBPort);

			// Creating buttons
			JoystickButton aDPadUp = new JoystickButton(joystickA, 3);
			JoystickButton aDPadDn = new JoystickButton(joystickA, 2);
			JoystickButton bDPadUp = new JoystickButton(joystickB, 3);
			JoystickButton bDPadDn = new JoystickButton(joystickB, 2);

			// Mapping buttons
			aDPadDn.whileHeld(new ZeroPointTurn());
			bDPadDn.whileHeld(new ZeroPointTurn());
			aDPadUp.whileHeld(new GyroStraightDrive());
			bDPadUp.whileHeld(new GyroStraightDrive());
		}

		// SmartDashboard Buttons
		SmartDashboard.putData("Autonomous", new Autonomous());
		SmartDashboard.putData("Scissor Up", new ScissorUp());
		SmartDashboard.putData("Scissor Down", new ScissorDown());
		SmartDashboard.putData("Lift System Up", new LiftSystemUp());

	}

}
