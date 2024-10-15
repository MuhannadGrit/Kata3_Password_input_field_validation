import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {
    public ValidationResult validate(String password) {
        List<String> errors = new ArrayList<>();
        boolean isLengthValid = password.length() >= 8;
        boolean isNumberCountValid = password.chars().filter(Character::isDigit).count() >= 2;
        boolean hasUppercase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");

        if (!isLengthValid) {
            errors.add("Password must be at least 8 characters");
        }
        if (!isNumberCountValid) {
            errors.add("The password must contain at least 2 numbers");
        }
        if (!hasUppercase) {
            errors.add("password must contain at least one capital letter");
        }
        if (!hasSpecialChar) {
            errors.add("password must contain at least one special character");
        }

        boolean isValid = isLengthValid && isNumberCountValid && hasUppercase && hasSpecialChar;

        return new ValidationResult(isValid, errors, isLengthValid, isNumberCountValid, hasUppercase, hasSpecialChar);
    }
}
