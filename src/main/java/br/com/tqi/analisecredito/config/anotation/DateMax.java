package br.com.tqi.analisecredito.config.anotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = {DateValidation.class})
public @interface DateMax {

    String message() default "Maximo 3 meses do dia atual";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}