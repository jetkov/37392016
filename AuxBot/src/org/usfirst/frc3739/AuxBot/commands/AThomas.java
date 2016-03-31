package org.usfirst.frc3739.AuxBot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Nothing here yet
 */
public class AThomas extends CommandGroup {

	public AThomas() {
		addSequential(new AutoDrive(0.5, 0, 10));
	}
}
