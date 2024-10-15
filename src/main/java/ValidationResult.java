import java.util.List;

public class ValidationResult {
    public boolean isValid;
    public List<String> errors;
    public boolean isLengthValid;
    public boolean isNumberCountValid;
    public boolean hasUppercase;
    public boolean hasSpecialChar;

    public ValidationResult(boolean isValid, List<String> errors, boolean isLengthValid, boolean isNumberCountValid, boolean hasUppercase, boolean hasSpecialChar) {
        this.isValid = isValid;
        this.errors = errors;
        this.isLengthValid = isLengthValid;
        this.isNumberCountValid = isNumberCountValid;
        this.hasUppercase = hasUppercase;
        this.hasSpecialChar = hasSpecialChar;
    }
}
