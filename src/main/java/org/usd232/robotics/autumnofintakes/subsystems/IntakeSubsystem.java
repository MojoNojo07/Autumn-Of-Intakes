package org.usd232.robotics.autumnofintakes.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.usd232.robotics.autumnofintakes.log.Logger;

import org.usd232.robotics.autumnofintakes.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
    /**
     * The logger.
     *
     * @since 2022
     */
    // @SuppressWarnings("unused")
    private static final Logger LOG = new Logger();

    private final Spark intakeMotor;

    public IntakeSubsystem() {
        intakeMotor = LOG.catchAll(() -> new Spark(IntakeConstants.INTAKE_MOTOR));
    }

    /**Runs the intake at a used-defined speed. Use negative numbers to reverse.*/
    public void intake (double speed) {
        intakeMotor.set(speed);
    }
}
