package org.usd232.robotics.autumnofintakes.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import org.usd232.robotics.autumnofintakes.log.Logger;
import org.usd232.robotics.autumnofintakes.subsystems.IntakeSubsystem;

public class Intake extends CommandBase {
    /**
     * The logger.
     *
     * @since 2018
     */
    @SuppressWarnings("unused")
    private static final Logger LOG = new Logger();
    
    private final IntakeSubsystem intakeSubsystem;

    private double speed;

    public Intake (double speed, IntakeSubsystem intakeSubsystem) {
        this.speed = speed;

        this.intakeSubsystem = intakeSubsystem;

        addRequirements(intakeSubsystem);
    }

    //Calls the intake command based on the speed
    @Override
    public void execute() {
        intakeSubsystem.intake(speed);
    }

    //Sets intake speed to 0 when button is released
    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.intake(0.0);
    }
}
