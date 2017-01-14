package org.firstinspires.tbl.MATT_tbl.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.tbl.lib.Toggler;

/**
 * Flywheel Subsystem class
 */

public class Flywheel
{
    //Private variables
    private DcMotor topFly; //top motor of the flywheel
    private DcMotor bottomFly; //bottom motor of the flywheel

    private double[] topPowers = {0.70, 0.75, 0.80, 0.85}; //power settings for the top flywheel
    private double topFlyPower; //power set for the top flywheel
    private double[] bottomPowers = {0.70, 0.75, 0.80, 0.85}; //power settings for the bottom flywheel
    private double bottomFlyPower; //power set for the bottom flywheel

    //Strings for telemetry messages
    private String flywheelMode; //for telemetry purposes - displays topspin or backspin
    private String chosenMotorToChange; //for telemetry purposes - displays top fly or bottom fly

    //Togglers for control
    private Toggler flywheelPowerToggle = new Toggler(topPowers.length); //toggle through power settings for flywheel
    private Toggler flywheelToggle = new Toggler(2); //toggle between on and off for flywheel
    private Toggler motorToggle = new Toggler(2); //toggle between top and bottom fly for rpm change
    private Toggler rpmToggle = new Toggler(101); //toggle between multiple power levels to change rpm

    public Flywheel(HardwareMap map)
    {
        //Find hardware to initialize all motors
        topFly = map.dcMotor.get("topFly");
        bottomFly = map.dcMotor.get("bottomFly");

        //Set mode for flywheels to run with encoders - includes a PID controller that will ensure motors running at the right speed
        topFly.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bottomFly.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Set maximum speed of each motor based on encoder ticks per second
        topFly.setMaxSpeed(1000);
        bottomFly.setMaxSpeed(1000);

        //Set behavior of motors when zero power is applied
        //float means the motor stops and then floats, no resistance against external force
        topFly.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        bottomFly.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void runFlywheel(boolean rBumper)
    {
        flywheelToggle.changeState(rBumper);
        switch(flywheelToggle.currentState())
        {
            case 0:
                topFly.setPower(0.0);
                bottomFly.setPower(0.0);
                break;
            case 1:
                topFly.setPower(topFlyPower);
                bottomFly.setPower(bottomFlyPower);
        }
    }

    public void setFlywheelState(boolean a)
    {
        flywheelPowerToggle.changeState(a);
        switch(flywheelPowerToggle.currentState())
        {
            case 0:
                topFlyPower = topPowers[0];
                bottomFlyPower = bottomPowers[0];
                flywheelMode = "Top Spin";
                break;
            case 1:
                topFlyPower = topPowers[1];
                bottomFlyPower = bottomPowers[1];
                flywheelMode = "Back Spin";
                break;
        }
    }

    public void chooseMotorToChangeRPM(boolean b)
    {
        motorToggle.changeState(b);
        switch(motorToggle.currentState())
        {
            case 0:
                chosenMotorToChange = "Top Flywheel";
                break;
            case 1:
                chosenMotorToChange = "Bottom Flywheel";
                break;
        }
    }

    public void changeRPM(boolean up, boolean down)
    {
        rpmToggle.changeState(up, down);
        switch(motorToggle.currentState())
        {
            case 0:
                //Change top fly motor power
                double power = topFly.getPower() * 100;
                break;
            case 1:
                //Change bottom fly motor power
                break;
        }
    }
}
