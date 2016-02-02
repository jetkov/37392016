package org.usfirst.frc.team3739.robot.subsystems;
 
import org.usfirst.frc.team3739.robot.commands.LiftCommand;
 


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
 
 
/**
 */
 
public class LiftTrain extends Subsystem {
	public DigitalInput limitSwitch;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Victor liftMotors;
       
    public LiftTrain(){
    	liftMotors = new Victor(5);
    	liftMotors.enableDeadbandElimination(true);
    	limitSwitch = new DigitalInput(0);//for init the limit switch within the subsystem - don't do this in ROBOT.java
    }
       
    public void initDefaultCommand() {
        setDefaultCommand(new LiftCommand());
       
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
   
    //DriveMethod
    public void lift(double liftpower){                        
        liftMotors.set(liftpower);//full speed ahead!       
    }    
}