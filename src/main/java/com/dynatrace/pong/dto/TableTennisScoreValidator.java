package com.dynatrace.pong.dto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// Copilot used to create validation

public class TableTennisScoreValidator implements ConstraintValidator<ValidTableTennisScore, ScoreRequest> {

    @Override
    public void initialize(ValidTableTennisScore annotation) {
        ConstraintValidator.super.initialize(annotation);
    }

    @Override
    public boolean isValid(ScoreRequest request, ConstraintValidatorContext context) {
        if (request == null) {
            return true;
        }

        Integer p1Points = request.getPlayer1Points();
        Integer p2Points = request.getPlayer2Points();
        Integer p1Games = request.getPlayer1Games();
        Integer p2Games = request.getPlayer2Games();

        if (p1Points == null || p2Points == null || p1Games == null || p2Games == null) {
            return true;
        }

        if (p1Games > 5 || p2Games > 5) {
            addConstraintViolation(context, "Games must not exceed 5");
            return false;
        }

        if (!isValidTableTennisPoints(p1Points, p2Points)) {
            addConstraintViolation(context, "Table tennis score invalid: up to 11 points with win by at least 2");
            return false;
        }

        return true;
    }

    private boolean isValidTableTennisPoints(Integer p1, Integer p2) {
        if (p1 == 11 && p2 <= 10) {
            return true;
        }
        if (p2 == 11 && p1 <= 10) {
            return true;
        }

        if (p1 >= 10 && p2 >= 10) {
            return Math.abs(p1 - p2) == 2;
        }

        if (p1 < 10 && p2 < 10) {
            return true;
        }

        return false;
    }

    private void addConstraintViolation(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
    }
}
