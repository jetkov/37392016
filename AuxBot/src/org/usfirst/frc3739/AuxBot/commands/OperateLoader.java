package org.usfirst.frc3739.AuxBot.commands;

import org.usfirst.frc3739.AuxBot.Config;
import org.usfirst.frc3739.AuxBot.Robot;
import org.usfirst.frc3739.AuxBot.utilities.LogitechWingman;
import org.usfirst.frc3739.AuxBot.utilities.SmartJoystick;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Allows for the control of the loader joint with a joystick.
 *
 * @author Alex
 */
public class OperateLoader extends Command {

	private LogitechWingman operatorController = Robot.oi.operatorController;
	private SmartJoystick joystickC = Robot.oi.joystickC;

	public OperateLoader() {
		requires(Robot.loader);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Config.usingOperatorController) {
			Robot.loader.setJointSpeed(operatorController.getRY());
		} else {
			Robot.loader.setJointSpeed(joystickC.getSmartY());
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.loader.killJoint();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
