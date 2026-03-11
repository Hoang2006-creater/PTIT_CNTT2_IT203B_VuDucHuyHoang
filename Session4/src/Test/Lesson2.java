package Test;

import BaiTap.CheckAge;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class Lesson2 {
    @Test
    void testAge18(){
        int age = 18;
        boolean result = CheckAge.checkRegistrationAge(age);
        assertEquals(true,result);
    }
    @Test
    void testAgeUnder18(){
        int age = 0;
        boolean result = CheckAge.checkRegistrationAge(age);
        assertEquals(false,result);
    }
    @Test
    void testNegativeAge(){
        CheckAge check = new CheckAge();
        int age = -1;
        assertThrows(IllegalArgumentException.class,()->{
            CheckAge.checkRegistrationAge(age);
        });
    }
}
