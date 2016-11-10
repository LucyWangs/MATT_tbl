package org.firstinspires.ftc.MATT_tbl;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Lucy Wang on 11/9/2016.
 */

public class TennisBallLauncher
{
    private DcMotor topFly;
    private DcMotor bottomFly;
    private DcMotor clover;

    private Toggler topSpinToggle = new Toggler(2);

    public TennisBallLauncher(HardwareMap map)
    {
        topFly = map.dcMotor.get("topFly");
        bottomFly = map.dcMotor.get("bottomFly");
        clover = map.dcMotor.get("clover");
    }

    public void runFlywheel(double topPower, double bottomPower)
    {

    }

    public void runTopSpin(boolean trigger)
    {
        topSpinToggle.changeState(trigger);
        switch(topSpinToggle.currentState())
        {
            case 0:

                break;
            case 1:

                break;

        }
    }
}
