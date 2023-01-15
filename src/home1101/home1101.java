package home1101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class home1101 {
    public static void main(String[] args) {
        String text = """
                Не говори мне о толпе безумной 
                Она иной раз вдохновение спугнёт 
                Избавь меня от этой давки шумной
                лекущей мощно в свой водоворот 
                Нет тишины ищу я многодумный
                Лишь там поэту радость расцветёт
                Там только там божественною властью
                Любовь и дружба нас приводит к счастью""";
        String[] arr = text.split("[\s\n\t\r]+");
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            int rand = (int) (Math.random() * arr.length);
            list.add(arr[rand].toLowerCase());
        }
        System.out.println(list.size());
        System.out.println(list.toString());
        Map<String, Integer> map = new LinkedHashMap<>();
        mapMerge(list, map);

        System.out.println(" 1  с подсчетом повторений" + map);

        int sum = 0;
        for (Integer s : map.values())
            sum += s;

        System.out.println(" 2 проверили колличество слов " + sum);

        ArrayList<Map.Entry<String, Integer>> list1 = new ArrayList<>(map.entrySet());

// Home option
        list1.sort(((o1, o2) -> {

            if (o1.getValue() == o2.getValue())o1.getKey().compareTo(o2.getKey());
            return o2.getValue() - o1.getValue();
        }
        ));

        System.out.println(list1);
        System.out.println(list1.get(0));


        BiFunction<Integer, Integer, Integer> mergeSum = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer n1, Integer n2) {
                return n1 + n2;
            }
        };

        // Home option
        BiFunction<Integer, Integer, Integer> mergeSum1 = ((x,y)->x+y); // можно  и без нее сразу метод mapMerge
        mapMerge(list, map);

    /*    for (String s : list) {
           // map.merge((s), 1, mergeSum);
            map.merge((s), 1, mergeSum1);
        }*/
     }
    public static Map<String, Integer> mapMerge(ArrayList<String> list, Map<String, Integer> map) {
        for (String s : list) {
            map.merge((s), 1, (Integer::sum));
        }
        return map;
    }
}
