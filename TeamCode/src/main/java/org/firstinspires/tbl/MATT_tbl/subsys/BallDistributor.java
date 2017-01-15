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
    private Servo ballGate;
    private String gateStatus;

    public BallDistributor(HardwareMap map)
    {
        ballGate = map.servo.get("ballGate");
    }

    public void activateBallGate(boolean lbumper)
    {
        if(lbumper)
        {
            ballGate.setPosition(0.0);
            gateStatus = "Open";
        }
        else
        {
            ballGate.setPosition(1.0);
            gateStatus = "Closed";
        }
    }

    public String getGateStatus()
    {
        return gateStatus;
    }
}
