package org.usfirst.frc3739.AuxBot.utilities;

import edu.wpi.first.wpilibj.Joystick;

public class SmartJoystick extends Joystick {
	public SmartJoystick(int port) {
		super(port);
	}

	public double getSmartX() {
		return super.getX() * super.getZ();
	}

	public double getSmartY() {
		return super.getY() * super.getZ();
	}

}
