package com.yuchen.string;
import java.util.Random;

/***
 * 定义长度为n的内容不重复的数组，
 */
public class Args {
    /***
     * 定义随机字符串
     * @param length
     * @return
     */
    public static String getRandom(int length) {
        // 定义一个字符串，随机字符串从此字符串中获取
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        int randomNum;
        char randomChar;
        Random random = new Random();
        // 定义一个可变字符串
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <= length; i++) {
            // 可生成[0,n)之
            randomNum = random.nextInt(str.length());
            // 获得随机位置对应的字符
            randomChar = str.charAt(randomNum);
            // 组成一个随机字符串
            stringBuffer.append(randomChar);
        }
        return stringBuffer.toString();
    }

    /***
     * 定义大小为index的数组
     * @param index
     * @return
     */
    public String[] getRandomArray(int index) {
        String[] str = new String[index];
        Random random = new Random();
        for (int i = 0; i < index; i++) {
            str[i]=getRandom(random.nextInt(36))+getRandom(random.nextInt(2));
        }
        return str;
    }
}
