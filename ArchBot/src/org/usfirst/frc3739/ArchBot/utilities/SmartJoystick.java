package org.usfirst.frc3739.ArchBot.utilities;

import edu.wpi.first.wpilibj.Joystick;

public class SmartJoystick extends Joystick {
	public SmartJoystick(int port) {
		super(port);
	}

	public double getSmartX() {
		return super.getX() * Math.abs((2-super.getZ())/2 + 0.1);
	}

	public double getSmartY() {
		return super.getY() * Math.abs((2-super.getZ())/2 + 0.1);
	}

}
