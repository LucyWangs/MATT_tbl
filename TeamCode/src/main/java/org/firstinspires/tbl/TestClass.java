package org.firstinspires.tbl;

/**
 * Created by Lucy Wang on 11/9/2016.
 */

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="TBL: TestClass", group="Test")
public class TestClass extends OpMode
{
    private DcMotor topFly;
    private DcMotor bottomFly;
    private DcMotor clover;

    public void init()
    {
        topFly = hardwareMap.dcMotor.get("topFly");
        bottomFly = hardwareMap.dcMotor.get("bottomFly");
        clover = hardwareMap.dcMotor.get("clover");
    }

    public void loop()
    {
        //sets [pwer for the flywheel and clover
    }
}
