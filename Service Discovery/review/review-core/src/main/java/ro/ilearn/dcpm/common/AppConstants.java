package ro.ilearn.dcpm.common;

public final class AppConstants {
    public static final String MUST_NOT_BE_NULL = "The given %s must not be null";
    public static final String NOT_SUCH_ELEMENT = "%s not found by given identifier %d";

    private AppConstants() {
        throw new IllegalStateException("Utility class");
    }
}
