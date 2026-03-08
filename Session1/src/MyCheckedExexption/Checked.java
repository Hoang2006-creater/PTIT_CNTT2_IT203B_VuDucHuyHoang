package MyCheckedExexption;

public class Checked extends Exception {
    private int code;

    public Checked (String message){
        super(message);
    }
    public int getCode(){
        return code;
    }
    public void setCode(int code){
        this.code=code;
    }
}
