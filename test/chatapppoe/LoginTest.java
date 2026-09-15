package chatapppoe;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void testCheckUserName() {
        Login instance = new Login();
        assertTrue(instance.checkUserName("kyl_1"));
        assertFalse(instance.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexity() {
        Login instance = new Login();
        assertTrue(instance.checkPasswordComplexity("Ch&&sec@ke99!"));
        assertFalse(instance.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumber() {
        Login instance = new Login();
        assertTrue(instance.checkCellPhoneNumber("+27838968976"));
        assertFalse(instance.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testRegisterUser() {
        Login instance = new Login();
        String result = instance.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals("Username successfully captured. Password successfully captured. Cell number successfully captured.", result);
    }

    @Test
    public void testLoginUser() {
        Login instance = new Login();
        instance.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(instance.loginUser("kyl_1", "Ch&&sec@ke99!"));
        assertFalse(instance.loginUser("kyl_1", "wrongpassword"));
    }

    @Test
    public void testReturnLoginStatus() {
        Login instance = new Login();
        instance.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals("Welcome Kyle, Smith it is great to see you again.", instance.returnLoginStatus(true));
        assertEquals("Username or password incorrect, please try again.", instance.returnLoginStatus(false));
    }
}