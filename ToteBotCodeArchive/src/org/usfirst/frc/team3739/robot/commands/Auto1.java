package org.usfirst.frc.team3739.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto1 extends CommandGroup {
    
    public  Auto1() {
    	//face garbage can, pick it up, turn 90, 
    	
    	
    	
    	/*addSequential(new Open(1));//optional
    	addSequential(new DriveForward(1.5));
    	addSequential(new Close(1));
    	addSequential(new LiftUp(6));
    	addSequential(new DoNothing(1));
    	addSequential(new DriveBackward(1.5));
    	addSequential(new DoNothing(1));
    	addSequential(new TurnLeft(1.75));
    	addSequential(new DoNothing(1));
    	addSequential(new DriveForward(1));
    	addSequential(new DoNothing(1));
    	addSequential(new TurnRight(1.9));
    	addSequential(new LiftDown(2));*/
    	
    	
    	//4.3 is 180 when holding garbage can
    	
    	
    	
    	
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
