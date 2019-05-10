import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        list();
    }

    public static void list(){
        List list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
    }


    public static void math(){
        int a = 3;
        int b = 5;
        System.out.println(a=(a++));
        b+=(a++ + ++a);
        System.out.println(a);
        System.out.println(b);
    }
}
