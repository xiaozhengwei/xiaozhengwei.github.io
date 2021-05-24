import java.util.ArrayList;
import java.util.List;

public class Example {

    public static void main(String[] args) {

        List<String> list=new ArrayList<>();

        for(int i=0;i<10000000;i++){
            list.add("反手为云扶手位于反手为云扶手位于反手为云扶手位于反手为云扶手位于i等于"+i);
            System.out.println(i);
        }

        long start=System.currentTimeMillis();
        System.out.println("开始时间:"+start);

        list.contains("反手为云扶手位于");
        long end=System.currentTimeMillis();
        System.out.println("结束时间:"+end);
        System.out.println("相差:"+(end-start)+"ms");


    }
}

class Solution {

}