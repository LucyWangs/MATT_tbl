package org.firstinspires.tbl.MATT_tbl.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.tbl.lib.Toggler;

/**
 * Ball Distribution subsystem class
 */

public class BallDistributor
{
    private DcMotor cloverMotor;
    private Servo ballGate;

    private Toggler ballDistributionToggler = new Toggler(2);

    public BallDistributor(HardwareMap map)
    {
        cloverMotor = map.dcMotor.get("cloverMotor");
        ballGate = map.servo.get("ballGate");
    }

}
