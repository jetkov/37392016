package org.usfirst.frc3739.AuxBot.utilities;

import edu.wpi.first.wpilibj.Joystick;

public class LogitechDualAction extends Joystick {

	private double sensitivityX = 1, sensitivityY = 1;
	private static final double minSensitivity = 0.1;

	public LogitechDualAction(int port) {
		super(port);
	}

	public void setSensitivity(double x, double y) {
		sensitivityX = Math.max(minSensitivity, Math.min(1, x));
		sensitivityY = Math.max(minSensitivity, Math.min(1, y));
	}

	public void setSensitivity(double sensitivity) {
		sensitivity = Math.max(minSensitivity, (Math.min(1, sensitivity)));
		sensitivityX = sensitivity;
		sensitivityY = sensitivity;
	}

	public double getLX() {
		return super.getRawAxis(0);
	}

	public double getLY() {
		return -super.getRawAxis(1);
	}

	public double getRX() {
		return super.getRawAxis(2);
	}

	public double getRY() {
		return -super.getRawAxis(3);
	}

	public double getSmartLX() {
		return getLX() * sensitivityX;
	}

	public double getSmartLY() {
		return getLY() * sensitivityY;
	}

	public double getSmartRX() {
		return getLX() * sensitivityX;
	}

	public double getSmartRY() {
		return getLY() * sensitivityY;
	}

}
