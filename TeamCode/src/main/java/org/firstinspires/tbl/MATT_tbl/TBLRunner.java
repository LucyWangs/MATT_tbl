package org.firstinspires.tbl.MATT_tbl;

/**
 * Created by Lucy Wang on 11/9/2016.
 */

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.tbl.MATT_tbl.subsys.TennisBallLauncher;

@TeleOp(name="TBL: TBLRunner", group="Test")
public class TBLRunner extends OpMode
{
    TennisBallLauncher tbl;

    public void init()
    {
        tbl = new TennisBallLauncher(hardwareMap);
    }

    public void loop()
    {
        tbl.flywheel.runFlywheel(gamepad1.right_bumper);
        tbl.flywheel.setFlywheelState(gamepad1.a);
        tbl.flywheel.changeRPM(gamepad1.dpad_up, gamepad1.dpad_down);
        tbl.flywheel.chooseMotorToChangeRPM(gamepad1.b);

        tbl.ballDistributor.activateBallGate(gamepad1.left_bumper);

        //Telemetry
        telemetry.addData("Flywheel Mode", tbl.flywheel.getFlywheelMode());
        telemetry.addData("Top Fly Speed", tbl.flywheel.getTopMotorPowerLevel());
        telemetry.addData("Bottom Fly Speed", tbl.flywheel.getBottomMotorPowerLevel());
        telemetry.addData("Gate Status", tbl.ballDistributor.getGateStatus());

        telemetry.update();
    }
}
