/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="Autonom", group="Linear Opmode")
public class Autonom extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor SF = null;
    private DcMotor SJ = null;
    private DcMotor DF = null;
    private DcMotor DJ = null;

    @Override
    public void runOpMode() {

        SF = hardwareMap.dcMotor.get("Tleft_drive");
        SJ = hardwareMap.dcMotor.get("Bleft_drive");
        DF = hardwareMap.dcMotor.get("Tright_drive");
        DJ = hardwareMap.dcMotor.get("Bright_drive");

        SF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        SJ.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DJ.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        SF.setDirection(DcMotorSimple.Direction.REVERSE);
        SJ.setDirection(DcMotorSimple.Direction.REVERSE);

        SF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        SJ.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        DF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        DJ.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        SF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        SJ.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        DF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        DJ.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        LateralaS(0.5, 2700);
        while(opModeIsActive() && !isStopRequested() && SF.isBusy() && SJ.isBusy() && DF.isBusy() && DJ.isBusy()) {
            telemetry.addData("merge", SF.getTargetPosition());
            telemetry.update();
        }

        Inainte(0.8, 700);

        while(opModeIsActive() && !isStopRequested() && SF.isBusy() && SJ.isBusy() && DF.isBusy() && DJ.isBusy()) {
            telemetry.addData("merge", SF.getTargetPosition());
            telemetry.update();
        }

        LateralaS(0.5, -1600);
        while(opModeIsActive() && !isStopRequested() && SF.isBusy() && SJ.isBusy() && DF.isBusy() && DJ.isBusy()) {
            telemetry.addData("merge", SF.getTargetPosition());
            telemetry.update();
        }

        Inainte(0.8, -3700);
        while(opModeIsActive() && !isStopRequested() && SF.isBusy() && SJ.isBusy() && DF.isBusy() && DJ.isBusy()) {
            telemetry.addData("merge", SF.getTargetPosition());
            telemetry.update();
        }

        Inainte(0.8, 1000);
        while(opModeIsActive() && !isStopRequested() && SF.isBusy() && SJ.isBusy() && DF.isBusy() && DJ.isBusy()) {
            telemetry.addData("merge", SF.getTargetPosition());
            telemetry.update();
        }
    }

public void Inainte(double p, int t) {
  SF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
  SJ.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
  DF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
  DJ.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

  SF.setTargetPosition(-t);
  SJ.setTargetPosition(-t);
  DF.setTargetPosition(-t);
  DJ.setTargetPosition(-t);

  SF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
  SJ.setMode(DcMotor.RunMode.RUN_TO_POSITION);
  DF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
  DJ.setMode(DcMotor.RunMode.RUN_TO_POSITION);

  SF.setPower(p);
  SJ.setPower(p);
  DF.setPower(p);
  DJ.setPower(p);
  }

public void LateralaS(double p, int t) {
        SF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        SJ.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        DF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        DJ.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        SF.setTargetPosition(-t);
        SJ.setTargetPosition(t);
        DF.setTargetPosition(t);
        DJ.setTargetPosition(-t);

        SF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        SJ.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        DF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        DJ.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        SF.setPower(p);
        SJ.setPower(p);
        DF.setPower(p);
        DJ.setPower(p);
    }
}
