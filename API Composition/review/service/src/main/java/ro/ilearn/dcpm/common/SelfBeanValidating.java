package ro.ilearn.dcpm.common;

import javax.validation.*;
import java.util.Set;

public interface SelfBeanValidating<T> {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    /**
     * Evaluates all Bean Validations on the attributes of this instance.
     */
    @SuppressWarnings("unchecked")
    default void validateSelfBean() {
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
