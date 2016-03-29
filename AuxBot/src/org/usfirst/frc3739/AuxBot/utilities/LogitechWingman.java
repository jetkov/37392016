package org.usfirst.frc3739.AuxBot.utilities;

public class LogitechWingman extends LogitechDualAction {

	public LogitechWingman(int port) {
		super(port);
	}

	public double getSliderValue() {
		return super.getRawAxis(2);
	}

	public double getRX() {
		return super.getRawAxis(3);
	}

	public double getRY() {
		return -super.getRawAxis(4);
	}

}
