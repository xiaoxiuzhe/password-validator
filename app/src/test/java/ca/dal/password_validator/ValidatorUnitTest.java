package ca.dal.password_validator;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidatorUnitTest {
    static String WeakPassword1 = "password";
    static String WeakPassword2 = "PASSWORD";
    static String WeakPassword3 = "1234aA!";
    static String WeakPassword4 = "12345678a!";
    static String WeakPassword5 = "12345678A!";
    static String WeakPassword6 = "abcdefghA!";
    static String WeakPassword7 = "12345678aA";
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
        //return false because it is "password" in uppercase
        assertFalse(validator.validate(WeakPassword2));
    }

    @Test
    public void WeakPassword3IsWeak()
    {
        //return false because it is too short, minimum 8 characters
        assertFalse(validator.validate(WeakPassword3));
    }

    @Test
    public void WeakPassword4IsWeak()
    {
        //return false because uppercase characters is required
        assertFalse(validator.validate(WeakPassword4));
    }

    @Test
    public void WeakPassword5IsWeak()
    {
        //return false because lowercase characters is required
        assertFalse(validator.validate(WeakPassword5));
    }

    @Test
    public void WeakPassword6IsWeak()
    {
        //return false because at least one digit is required
        assertFalse(validator.validate(WeakPassword6));
    }

    @Test
    public void WeakPassword7IsWeak()
    {
        //return false because at least one special character is required
        assertFalse(validator.validate(WeakPassword7));
    }

    @Test
    public void StrongPasswordIsStrong()
    {
        //return true because it meet the requirement
        assertTrue(validator.validate(StrongPassword));
    }
}
