package org.usfirst.frc3739.ArchBot.commands;

import org.usfirst.frc3739.ArchBot.Robot;
import org.usfirst.frc3739.ArchBot.utilities.SmartJoystick;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Allows for the control of the loader joint with a joystick.
 * 
 * @author Alex
 */
public class OperateLoader extends Command {
	private SmartJoystick joystickC = Robot.oi.getJoystick('c');

	public OperateLoader() {
		requires(Robot.loader);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.loader.setJointSpeed(joystickC.getSmartY());
		SmartDashboard.putNumber("JoystickC Y", joystickC.getSmartY());
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
