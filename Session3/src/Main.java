import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list  = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (Integer value:list){
            if (value == 2){
                list.remove(value);
            }
        }
        System.out.println(list);
        // tao stream
        int[] arr ={1,2,3,4,5};
        IntStream streamInt =Arrays.stream(arr);
        Stream<Integer> stream2 = list.stream();
        IntStream stream3=streamInt.filter(value -> value%2==0);
        //Thao tac dau cuoi:sum,forEach,reduce,count,findFirst,anyMatch,findAny,allMatch,
        OptionalDouble avg = stream3.average();
        System.out.println("Avg"+avg.getAsDouble());
    }
}
//Vi du 1: Tao 2 list 1000 so nguyen ngau nhien tu -200 den 200
//1. Loc va in ra cac so nguyen duong ra man hinh
//2. Loai bo cac so trung lap
//3. Sap xep cac so theo thu tu tu lon den be
// 4. Tinh min,max
//5. Tinh tong cua tat ca cac phan tu
//6.Kiem tra gia tri n nhap vao co ton tai trong danh sach khong
//7.Chuyen cac so am thanh so doi cua no
