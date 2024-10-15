import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
    PasswordValidator passwordValidator = null;

    @BeforeEach
    public void  setup(){
        passwordValidator = new PasswordValidator();
    }

    @Test
    public void testPasswordLength(){
        assertFalse(passwordValidator.validate("1234567").isLengthValid);
        assertTrue(passwordValidator.validate("12345678").isLengthValid);
    }

    @Test
    public void testPasswordContainsTwoNumbers(){
        assertFalse(passwordValidator.validate("password1").isNumberCountValid);
        assertTrue(passwordValidator.validate("password12").isNumberCountValid);
    }

    @Test
    public void testPasswordContainCapitalLetter(){
        assertFalse(passwordValidator.validate("password11").hasUppercase);
        assertTrue(passwordValidator.validate("Password12").hasUppercase);
    }

    @Test
    public void testPasswordContainSpecialCharacter(){
        assertTrue(passwordValidator.validate("pass").errors.contains("Password must be at least 8 characters"));
        assertTrue(passwordValidator.validate("pass").errors.contains("The password must contain at least 2 numbers"));
        assertTrue(passwordValidator.validate("pass").errors.contains("password must contain at least one capital letter"));
        assertTrue(passwordValidator.validate("pass").errors.contains("password must contain at least one special character"));

        assertFalse(passwordValidator.validate("password").errors.contains("Password must be at least 8 characters"));
        assertFalse(passwordValidator.validate("password12").errors.contains("The password must contain at least 2 numbers"));
        assertFalse(passwordValidator.validate("Password123").errors.contains("password must contain at least one capital letter"));
        assertFalse(passwordValidator.validate("Password_123").errors.contains("password must contain at least one special character"));
    }
}