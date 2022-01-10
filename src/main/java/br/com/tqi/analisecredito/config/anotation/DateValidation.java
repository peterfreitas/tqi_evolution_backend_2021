package br.com.tqi.analisecredito.config.anotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateValidation implements ConstraintValidator<DateMax, LocalDate> {

    @Override
    public void initialize(DateMax constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        LocalDate maxDate = LocalDate.now().plusMonths(3).plusDays(1);
        return value.isBefore(maxDate);
    }
}