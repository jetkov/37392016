package org.usfirst.frc.team3739.utils;
import edu.wpi.first.wpilibj.Joystick;

public class Attack3Joystick extends Joystick{

	public Attack3Joystick(int port) {
		super(port);
		// TODO Auto-generated constructor stub
	}
	//Fine tune the values for a lower or higher sensitivity from values of -1 to 1.
	public double getdeadX(){	
		double power = getX();
		
		//accounting for slight degree of tilt when joystick left alone
		if(power>=-0.1&&power<=0.1){ 
			power=0;			
		}
		else{
			power=power*0.7;
		}
		return power;
			
	}	
	public double getdeadY(){		
		double power = getY();
		
		if(power>=-0.1&&power<=0.1){ 
			power=0;			
		}
		else{
			power=power*0.7;
		}	
		
		return power;
		
		
		
		
		
		
	}	
}


/*
if(left>0.5&&left<=0.6){
	left=left-0.1;
}

if(left>0.6&&left<=0.7){
	left=left-0.2;
}

if(left>0.7&&left<=0.8){
	left=left-0.3;
}

if(left>0.8&&left<=0.9){
	left=left-0.4;
}

if(left>0.9&&left<=1){
	left=left-0.5;
}


//right value when postitive(going backwards because it is inversed 
if(left<-0.5&&left>=-0.6){
	left=left+0.1;
}
if(left<-0.6&&left>=-0.7){
	left=left+0.1;
}
if(left<-0.7&&left>=-0.8){
	left=left+0.1;
}
if(left<-0.8&&left>=-0.9){
	left=left+0.1;
}
if(left<-0.9&&left>=-1){
	left=left+0.1;
}*/



