package MyCheckedExexption;

public class Unchecked extends RuntimeException {
    private int code;

    public Unchecked(String message) {
        super(message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}