package org.usfirst.frc3739.AuxBot.commands;

import org.usfirst.frc3739.AuxBot.Config;
import org.usfirst.frc3739.AuxBot.Robot;
import org.usfirst.frc3739.AuxBot.utilities.LogitechDualAction;
import org.usfirst.frc3739.AuxBot.utilities.SmartJoystick;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Robot drives straight forward, joystick controlling the throttle,
 *
 * @author Alex
 */
public class GyroStraightDrive extends Command {

	private LogitechDualAction driveController = Robot.oi.driveController;
	private SmartJoystick joystickA = Robot.oi.joystickA;

	public GyroStraightDrive() {
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double throttle;

		if (Config.usingDriveController) {
			throttle = driveController.getLY();
		} else {
			throttle = joystickA.getSmartY();
		}

		Robot.driveTrain.gyroStraightDrive(throttle);
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
