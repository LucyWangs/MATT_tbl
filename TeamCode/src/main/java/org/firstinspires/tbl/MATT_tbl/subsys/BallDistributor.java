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

    private Toggler gateToggler = new Toggler(2);

    public BallDistributor(HardwareMap map)
    {
        ballGate = map.servo.get("ballGate");
    }

    public void activateBallGate(boolean lbumper)
    {
        gateToggler.changeState(lbumper);

        switch(gateToggler.currentState())
        {
            case 0:
                ballGate.setPosition(0.85);
                gateStatus = "Closed";
                break;
            case 1:
                ballGate.setPosition(0.3);
                gateStatus = "Open";
        }

        /*if(lbumper)
        {
            ballGate.setPosition(1.0);
            gateStatus = "Open";
        }
        else
        {
            ballGate.setPosition(0.4);
            gateStatus = "Closed";
        }*/
    }

    public void activateBallGate(double ltrigger)
    {
    }

    public String getGateStatus()
    {
        return gateStatus;
    }
}
