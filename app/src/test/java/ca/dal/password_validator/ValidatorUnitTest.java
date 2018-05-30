package ca.dal.password_validator;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidatorUnitTest {
    static String WeakPassword1 = "password";
    static String WeakPassword2 = "PASSWORD";
    static String WeakPassword3 = "1234567";
    static String StrongPassword = "12345678aA!";

    static Validator validator;

    @BeforeClass
    public static void setup()
    {
        validator = new Validator();
    }

    @Test
    public void WeakPassword1IsWeak()
    {
        //return false because it is "password"
        assertFalse(validator.validate(WeakPassword1));
    }

    @Test
    public void WeakPassword2IsWeak()
    {
        //return false because it is "password" in upper case
        assertFalse(validator.validate(WeakPassword2));
    }

    @Test
    public void WeakPassword3IsWeak()
    {
        //return false because it does not have 8 characters long
        assertFalse(validator.validate(WeakPassword3));
    }

    @Test
    public void StrongPasswordIsStrong()
    {
        //return true because it meet the requirement for stage1
        assertTrue(validator.validate(StrongPassword));
    }
}
