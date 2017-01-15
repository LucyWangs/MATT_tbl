package org.firstinspires.tbl.MATT_tbl.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.tbl.lib.Toggler;

/**
 * Created by Lucy Wang on 11/9/2016.
 */

public class TennisBallLauncher
{
    public Flywheel flywheel;
    public BallDistributor ballDistributor;

    private Toggler topSpinToggle = new Toggler(2);

    public TennisBallLauncher(HardwareMap map)
    {
        flywheel = new Flywheel(map);
        ballDistributor = new BallDistributor(map);
    }
}
