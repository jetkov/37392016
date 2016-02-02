package org.usfirst.frc.team3739.robot.subsystems;
 
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
 
 
/**
 * Open
 */
 
public class OpenCloseTrain extends Subsystem {
   
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Victor opencloseMotors;
    
    public boolean isOpen=true;//only if, well you know    
       
    public OpenCloseTrain(){
    	opencloseMotors = new Victor(7);//port number is iffy jk not anymore
        opencloseMotors.enableDeadbandElimination(true);
    }
       
    public void initDefaultCommand() {
    //if boolean is true then this will happen; add two...
        //setDefaultCommand(new OpenCommand());//not sure what to put here
       
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
   
    //DriveMethod
    public void openclose(double openclosepower){                      
        opencloseMotors.set(openclosepower);//slow speed ahead!       
    }
    
    public void toggle(){//yeah, obsolete now LOL
    	if(isOpen){
    		openclose(-0.3);
    	}
    	else{
    		openclose(0.3);
    	}
    	System.out.println(isOpen);
    }
    
}