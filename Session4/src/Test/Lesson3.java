package Test;

import BaiTap.UserProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class Lesson3 {
    private UserProcessor processor;

    @BeforeEach
    void setUp(){
        processor = new UserProcessor();
    }
    @Test
    void testValidEmail(){
        String result = processor.processEmail("user@gmail.com");
        assertEquals("user@gmail.com",result);
    }
    @Test
    void testEmailMissingDomain(){
        assertThrows(IllegalArgumentException.class,()->{
            processor.processEmail("user@");
        });
    }
    @Test
    void testEmailNormalizationToLowercase() {
        String result = processor.processEmail("Example@Gmail.com");
        assertEquals("example@gmail.com", result);
    }
}
