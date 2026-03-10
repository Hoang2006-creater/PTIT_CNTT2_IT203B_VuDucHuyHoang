import java.time.*;
import java.util.Date;

public class trenLop2 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("milisecond" + date.getTime());
        LocalDate today =LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        LocalDate bornIn = LocalDate.of(2006,11,16);
        Period age = Period.between(bornIn,today);
        System.out.println(age);

    }
}

