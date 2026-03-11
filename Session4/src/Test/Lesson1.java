package Test;

import BaiTap.UserValidator;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Lesson1 {
    @Test
    void testValidUsername(){
        String username = "user123";
        boolean result = UserValidator.isValidUsername(username);
        assertTrue(result);
    }
    @Test
    void testValidUsername2(){
        String username = "abc";
        boolean result = UserValidator.isValidUsername(username);
        assertFalse (result);
    }
    @Test
    void testValidUsername3(){
        String username = "user name";
        boolean result = UserValidator.isValidUsername(username);
        assertFalse (result);
    }
}
