package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaList {
    /**
     * 集合
     *
     * @param args
     */
    public static void main(String[] args) {
        //遍历集合
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5);

        //lambda表达式 方法引用
        list.forEach(System.out::println);
        list.forEach(element -> {
            if (element % 2 == 0) {
                System.out.println(element);
            }
        });

        //删除集合中的某个元素
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.removeIf(ele -> ele == 1);
        //通过 foreach 遍历，查看是否已经删除
        list1.forEach(System.out::println);

        //集合内元素的排序
        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(4);
        list2.add(2);
        list2.add(1);
        list2.add(3);
//        list2.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
        list2.sort((o1, o2) -> o1 - o2);
        System.out.println(list2);
    }
}
