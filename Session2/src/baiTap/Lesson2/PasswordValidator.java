package baiTap.Lesson2;

@FunctionalInterface
interface PasswordValidator {
    boolean isValid(String password);
}
