/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
	private CANSparkMax FrontRight = new CANSparkMax(Constants.CAN_RIGHT_FRONT_WHEEL, MotorType.kBrushless);
	private CANSparkMax FrontLeft = new CANSparkMax(Constants.CAN_LEFT_FRONT_WHEEL, MotorType.kBrushless);
	private CANSparkMax RearRight = new CANSparkMax(Constants.CAN_RIGHT_BACK_WHEEL, MotorType.kBrushless);
	private CANSparkMax RearLeft = new CANSparkMax(Constants.CAN_LEFT_BACK_WHEEL, MotorType.kBrushless);

	public DifferentialDrive differentialDrive;

	public Drivetrain() {
		FrontRight.restoreFactoryDefaults();
		RearRight.restoreFactoryDefaults();
		FrontLeft.restoreFactoryDefaults();
		RearLeft.restoreFactoryDefaults();
		
		// Set the rear drives to follow the left and right front drives
		RearLeft.follow(FrontLeft);
		RearRight.follow(FrontRight);

        differentialDrive = new DifferentialDrive(FrontLeft, FrontRight);

		//Sets the motors to brake mode
		FrontRight.setIdleMode(IdleMode.kBrake);
		RearRight.setIdleMode(IdleMode.kBrake);
		FrontLeft.setIdleMode(IdleMode.kBrake);
		RearLeft.setIdleMode(IdleMode.kBrake);
		FrontLeft.setOpenLoopRampRate(0.1);
		FrontRight.setOpenLoopRampRate(0.1);

	}
	
	public void arcadeDrive(double forward, double rotation) {
		differentialDrive.arcadeDrive(-forward , rotation);
	}

	public void getJoystickValues(Joystick joystick) {
		System.out.println("Y VALUE: " + joystick.getY() + " X VALUE: " + joystick.getX());
	}
	
	public void tankDrive(double leftSpeed, double rightSpeed) {
		differentialDrive.tankDrive(-leftSpeed, -rightSpeed);
	}
	

    /**
     * This function is called periodically by Scheduler.run
     */
	@Override
	public void periodic() {
	}

}
