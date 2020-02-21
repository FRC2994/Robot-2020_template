/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

//Subsystems Imports
import frc.subsystems.Drivetrain;

//Commands Imports
import frc.commands.DefaultDrive;

public class RobotContainer {    
    //Joystick and Gamepad
    public final Joystick joystick = new Joystick(0); 
    public final Joystick gamepad = new Joystick(1);
   
    //Subsystems
    private final Drivetrain drivetrain = new Drivetrain();
    
    //Joystick and Gamepad buttons
    //private final JoystickButton jsButnShifter = new JoystickButton(this.joystick, 12);

    //Contains subsystems, OI devices, and commands.
    public RobotContainer(){
        configureButtons();

        this.setAutonomousActive(false);
        //this.shooterwheel.setDefaultCommand(new Shoot(this.shooterwheel, this.gamepad));
    }


    private void configureButtons() {
        //Instant commands
        /*SHOOTER*/
        //this.trigger.whenPressed(new InstantCommand(shooterwheel::toggle, shooterwheel));
    }

    public void setAutonomousActive(boolean active) {
        if (active) {
            // Replace command below with default autonomus command (ShootPowerCells for example)
            this.drivetrain.setDefaultCommand(new DefaultDrive(drivetrain, joystick));
        } else {
            this.drivetrain.setDefaultCommand(new DefaultDrive(drivetrain, joystick));
        }
    }
}
