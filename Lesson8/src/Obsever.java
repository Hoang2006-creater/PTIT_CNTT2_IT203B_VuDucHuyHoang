import java.util.ArrayList;
import java.util.List;

public class Obsever {
    public static void main(String[] args) {
        ReciverObsever r1 = new ConreteReciver("H");
        ReciverObsever r2 =new ConreteReciver("C");
        SourceName express = new SourceName();
        express.addReciver(r1);
        express.addReciver(r2);
        express.sendNews();
    }
}
// Người nhận
interface ReciverObsever{
    void update(String mess);
}

class SourceName{
    private List<ReciverObsever> obsevers =new ArrayList<>();
    public void addReciver (ReciverObsever reciver){
        obsevers.add(reciver);
    }
    public void sendNews(){
        String content = " Hello";
        obsevers.forEach(ob->{ob.update(content);});
    }
}
class ConreteReciver implements ReciverObsever{
private String name;

    public ConreteReciver(String name) {
        this.name = name;
    }

    @Override
    public void update(String mess) {
        System.out.println(name + " nhan tin: " + mess);
    }
}
