package ro.ilearn.dcpm.common;

import javax.validation.*;
import java.util.Set;

public interface SelfValidating<T> {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    /**
     * Evaluates all Bean Validations on the attributes of this instance.
     */
    @SuppressWarnings("unchecked")
    default void validateSelf() {
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
