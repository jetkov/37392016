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

	public double getSmartX() {
		return super.getX() * sensitivityX;
	}

	public double getSmartY() {
		return super.getY() * sensitivityY;
	}

}
