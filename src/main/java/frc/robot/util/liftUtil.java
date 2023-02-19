package frc.robot.util;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
//import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.teleop.Robot;

public class liftUtil {
 

//the purpose of this is to convert our revolutions per minute (RPM) into distance traveled
static final double COUNTS_PER_MOTOR_REV = 6380;  //*2 adjust for mecanum
static final double WHEEL_DIAMETER = 6.5405;     // In centimeters
static final double WHEEL_RADIUS = WHEEL_DIAMETER/2; // in cm
static final double WHEEL_CIRCUMFERENCE = WHEEL_DIAMETER * Math.PI;
static final double GEAR_REDUCTION = 1.0; // output (wheel) speed / input (motor) speed
static final double COUNTS_PER_GEAR_REV = COUNTS_PER_MOTOR_REV * GEAR_REDUCTION;
static final double COUNTS_PER_DEGREE = COUNTS_PER_GEAR_REV/360;

//lower cube grid height
private PWMTalonFX Lift = new PWMTalonFX(4);

public void stopLift(){
    Lift.set(0);
}

public void raiseLiftTo(double distanceInCM, double targetSpeed){
    int targetCount;
    //convert centimeters to number cycles to drive
    //counts_per_rotation/circumference*distane
    targetCount = (int) Math.round(COUNTS_PER_GEAR_REV / WHEEL_CIRCUMFERENCE * distanceInCM);
    stopLift();

    Lift.set(targetCount);
    Lift.set(targetSpeed);

    stopLift();
}

public void lowerLiftTo(double distanceInCM, double targetSpeed){
    int targetCount;
    //convert centimeters to number cycles to drive
    //counts_per_rotation/circumference*distane
    targetCount = (int) Math.round(COUNTS_PER_GEAR_REV / WHEEL_CIRCUMFERENCE * distanceInCM);
    stopLift();

    Lift.set(-targetCount);
    Lift.set(targetSpeed);

    stopLift();
}
}
