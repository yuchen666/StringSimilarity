package com.yuchen.string;

import java.text.NumberFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        // 用于排序，中间变量
        // double temp = 0.00;
        Like like = new Like();
        Args args1 = new Args();
        double d;
        // 定义一个长度为1000的内容不重复的字符串数组
        String[] randomArray = args1.getRandomArray(1000);
        Map<String, Double> percent = new HashMap<>();
        // 定义一个长度相同的数组，将相似度值放入数组中，根据值去获取下标，根据下标获取具体的 字符串
        // Double[] doubles = new Double[randomArray.length];
        Random random = new Random();
        // 随机从数组中获取一个1000以内的值
        int index = random.nextInt(1000);
        // 从数组中获取到值，然后与数组中每一个数据进行比较，比较后获得相似度值存储到doubles数组中
        String str = randomArray[index];
        for (int i = 0; i < randomArray.length; i++) {
            if (i == index) {
                percent.put(str, 0.00);
                //doubles[i] = 0.00;
            } else {
                percent.put(randomArray[i], like.getSimilarity(str, randomArray[i]));
                //doubles[i] = like.getSimilarity(str, randomArray[i]);
            }
        }

        // 根据HashMap中的 value值进行排序 排序后的结果放入 list集合中
        Set<Map.Entry<String, Double>> entrySet = percent.entrySet();
        List<Map.Entry<String, Double>> list = new ArrayList<>(percent.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        // 输出当前值
        System.out.println("当前值为：" + str);
        // 输出与其相似的五个字符串

        for (int i = 0; i < 5; i++) {
            System.out.println(" 与 " + list.get(i).toString().substring(0, list.get(i).toString().indexOf("=")) +
                    " 较为相似，相似度为：" +
                    list.get(i).toString().substring((list.get(i).toString().indexOf("=") + 1), list.get(i).toString().length()));
        }


     /*   // 遍历doubles并排序，取到其最大值的下标
        for (int i = 0; i < doubles.length - 1; i++) {
            for (int j = i + 1; j < doubles.length; j++) {
                if (doubles[i] < doubles[j]) {
                    temp = doubles[i];
                    doubles[i] = doubles[j];
                    doubles[j] = temp;
                }
            }
        }*/

/*
        for (int i = 0; i < doubles.length; i++) {
            System.out.println("doubles = " + doubles[i]);
        }*/

        // 遍历 percent 取value值最大的前五个值

        /*for (Double aDouble : doubles) {
            String rates = percentInstance.format(aDouble);
            System.out.println("rates = " + rates);
        }*/
    }
}
