package ca.dal.password_validator;

import org.junit.Before;
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

    @Before
    public void setup()
    {
        validator = new Validator();
    }

    @Test
    public void WeakPassword1IsWeak()
    {
        //return false because it is "password"
        assertFalse(validator.validate(WeakPassword1));
        assertEquals("\nMust no be \"password\"  (case insensitive)\nMust have at least one uppercase character\nMust have at least one digit\nMust have at least one special character", validator.printMessage());
    }

    @Test
    public void WeakPassword2IsWeak()
    {
        //return false because it is "password" in uppercase
        assertFalse(validator.validate(WeakPassword2));
        assertEquals("\nMust no be \"password\"  (case insensitive)\nMust have at least one lowercase character\nMust have at least one digit\nMust have at least one special character", validator.printMessage());

    }

    @Test
    public void WeakPassword3IsWeak()
    {
        //return false because it is too short, minimum 8 characters
        assertFalse(validator.validate(WeakPassword3));
        assertEquals("\nMust have at least 8 characters", validator.printMessage());
    }

    @Test
    public void WeakPassword4IsWeak()
    {
        //return false because uppercase characters is required
        assertFalse(validator.validate(WeakPassword4));
        assertEquals("\nMust have at least one uppercase character", validator.printMessage());

    }

    @Test
    public void WeakPassword5IsWeak()
    {
        //return false because lowercase characters is required
        assertFalse(validator.validate(WeakPassword5));
        assertEquals("\nMust have at least one lowercase character", validator.printMessage());
    }

    @Test
    public void WeakPassword6IsWeak()
    {
        //return false because at least one digit is required
        assertFalse(validator.validate(WeakPassword6));
        assertEquals("\nMust have at least one digit", validator.printMessage());
    }

    @Test
    public void WeakPassword7IsWeak()
    {
        //return false because at least one special character is required
        assertFalse(validator.validate(WeakPassword7));
        assertEquals("\nMust have at least one special character", validator.printMessage());
    }

    @Test
    public void StrongPasswordIsStrong()
    {
        //return true because it meet the requirement
        assertTrue(validator.validate(StrongPassword));
        assertEquals("", validator.printMessage());

    }
}
