package org.usfirst.frc3739.AuxBot.commands;

import org.usfirst.frc3739.AuxBot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Robot drives arcade style with a single joystick.
 * 
 * @author Alex
 * @version 1.0.0b
 */
public class JoyRide extends Command {

	public JoyRide() {
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveTrain.drive(Robot.oi.getJoystick());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
