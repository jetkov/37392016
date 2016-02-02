package org.usfirst.frc.team3739.robot;
 
import org.usfirst.frc.team3739.robot.commands.CloseCommand;
import org.usfirst.frc.team3739.robot.commands.FastLiftDownCommand;
import org.usfirst.frc.team3739.robot.commands.FastZeroPointCommand;
import org.usfirst.frc.team3739.robot.commands.OpenCommand;
import org.usfirst.frc.team3739.robot.commands.ZeroPointCommand;
import org.usfirst.frc.team3739.utils.Attack3Joystick;


//in case of needing a normal joystick import edu.wpi.first.wpilibj.Joystick;
//in case of needed a normal joystick import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
 
 
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {     
            
         public Attack3Joystick leftJoystick = new Attack3Joystick(0);
         public Attack3Joystick rightJoystick = new Attack3Joystick(1);
         public Attack3Joystick OPJoystick = new Attack3Joystick(2);
         public JoystickButton FastZeroPointButton =  new JoystickButton(leftJoystick, 5);
         public JoystickButton ZeroPointButton =  new JoystickButton(leftJoystick, 2);
         public JoystickButton CloseButton = new JoystickButton(leftJoystick, 1); //OP
         public JoystickButton OpenButton = new JoystickButton(leftJoystick, 3); //OP 2  
         public JoystickButton DownFastButton = new JoystickButton(OPJoystick, 1); //OP   
         //debug//public JoystickButton CloseButton = new JoystickButton(leftJoystick, 1);
         //public JoystickButton OpenButton = new JoystickButton(leftJoystick, 3);
       
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
   
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
   
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
   
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
   
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
   
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
   
    public OI() {
       
        CloseButton.whileHeld(new CloseCommand());//while held on the OP joystick it will close - make sure not to overextend          
        OpenButton.whileHeld(new OpenCommand());//while held on the OP joystick it will open - make sure not to overextend       
        ZeroPointButton.whileHeld(new ZeroPointCommand());//spin! might reduce speed...totes and garbage cans can fall if too fast
        FastZeroPointButton.whileHeld(new FastZeroPointCommand());//spin! might reduce speed...totes and garbage cans can fall if too fast
        DownFastButton.whileHeld(new FastLiftDownCommand());
   }  
   //VERY IMPORTANT:
    //when doing whileHeld(), make sure in the command "end();" is in the protected void interrupted
   
   
}