package org.usfirst.frc.team3739.robot.commands;

import autoCommands.Close;
import autoCommands.DoNothing;
import autoCommands.DriveForward;
import autoCommands.LiftDown;
import autoCommands.LiftUp;
import autoCommands.Open;
import autoCommands.TurnRight;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto2 extends CommandGroup {
    
    public Auto2(){
    	//Forward, close,lift garbage bin up, turn 180+10 degrees(?), move forward, set down
    	addSequential(new Open(1));
    	addSequential(new DriveForward(1.5));
    	addSequential(new Close(1.5));
    	addSequential(new LiftUp(3));
    	addSequential(new TurnRight(2.3));
    	addSequential(new DoNothing(1));
    	addSequential(new DriveForward(3));
    	addSequential(new LiftDown(2.5));
    	addSequential(new Open(1));
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
