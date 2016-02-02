package org.usfirst.frc.team3739.robot.subsystems;

import org.usfirst.frc.team3739.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 */
 
public class DriveTrain extends Subsystem {
    //private Encoder encoderRight;
    //private Encoder encoderLeft;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public RobotDrive driveMotors;
	
	public DriveTrain(){
		driveMotors = new RobotDrive(1, 2, 3, 4);
		//encoderLeft= new Encoder(RobotMap.ENCODER_LEFT[0],RobotMap.ENCODER_LEFT[1],true, EncodingType.k4X);
		//encoderRight= new Encoder(RobotMap.ENCODER_RIGHT[2],RobotMap.ENCODER_RIGHT[3],true, EncodingType.k4X);
		//encoderLeft.setDistancePerPulse(12.566);
		//encoderLeft.setDistancePerPulse(12.566);
			
	}
		
    //public Encoder getEncoderRight() {
		//return encoderRight;
	//}

	//public Encoder getEncoderLeft() {
	//return encoderLeft;
	//}



	public void initDefaultCommand() {
    	setDefaultCommand(new DriveCommand());
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //DriveMethod
    public void drive(double left, double right){     	 	
    	driveMotors.tankDrive((-left),(-right));    	
    }
    
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */