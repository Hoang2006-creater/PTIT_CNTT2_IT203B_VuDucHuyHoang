package Test;

import BaiTap.PasswordEvaluator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lesson4 {

    private PasswordEvaluator evaluator;

    @BeforeEach
    void setUp() {
        evaluator = new PasswordEvaluator();
    }

    @Test
    void testStrongPassword() {
        String result = evaluator.evaluatePasswordStrength("Abc123!@");
        assertEquals("Mạnh", result);
    }

    @Test
    void testMediumPasswords() {

        assertAll("Medium password tests",

                () -> assertEquals("Trung bình",
                        evaluator.evaluatePasswordStrength("abc123!@")),

                () -> assertEquals("Trung bình",
                        evaluator.evaluatePasswordStrength("ABC123!@")),

                () -> assertEquals("Trung bình",
                        evaluator.evaluatePasswordStrength("Abcdef!@")),

                () -> assertEquals("Trung bình",
                        evaluator.evaluatePasswordStrength("Abc12345"))
        );
    }

    @Test
    void testWeakPasswords() {

        assertAll("Weak password tests",

                () -> assertEquals("Yếu",
                        evaluator.evaluatePasswordStrength("Ab1!")),

                () -> assertEquals("Yếu",
                        evaluator.evaluatePasswordStrength("password")),

                () -> assertEquals("Yếu",
                        evaluator.evaluatePasswordStrength("ABC12345"))
        );
    }
}