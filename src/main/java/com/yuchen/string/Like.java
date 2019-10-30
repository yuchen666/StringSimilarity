package com.yuchen.string;

/***
 * 计算相似度
 */
public class Like {
    public static int compare(String str1, String str2) {
        // 定义一个矩阵，用于存放字符串
        int args[][];
        // 获取字符串的长度，用于存储矩阵中的数据
        int n = str1.length();
        int m = str2.length();
        // i为遍历str1的数据，j为遍历str2的数据
        int i;
        int j;
        // c1为str1中的字符，c2为str2中的字符
        char c1;
        char c2;
        // 记录相同字符,在某个矩阵位置值的增量,不是0就是1
        int temp;
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        // 初始化矩阵
        args = new int[n + 1][m + 1];
        // 初始化行
        for (i = 0; i <= n; i++) {
            args[i][0] = i;
        }
        // 初始化列
        for (j = 0; j <= m; j++) {
            args[0][j] = j;
        }
        for (i = 1; i <= n; i++) {
            // 遍历str1
            c1 = str1.charAt(i - 1);
            // 匹配str2
            for (j = 1; j <= m; j++) {
                c2 = str2.charAt(j - 1);
                // 两个字符相同
                if (c1 == c2) {
                    // 则计算值为0
                    temp = 0;
                } else {
                    // 若不同，则计算值为1
                    temp = 1;
                }
                // 左边+1,上边+1, 左上角+temp取最小
                args[i][j] = min(args[i - 1][j] + 1, args[i][j - 1] + 1, args[i - 1][j - 1] + temp);
            }
        }
        // 返回矩阵
        return args[n][m];
    }

    /**
     * 获取最小的值
     */
    private static int min(int one, int two, int three) {
       int min = one;
       if(two<min){
            min = two;
       }
       if(three < min){
            min = three;
       }
       return min;
    }

    /**
     * 获取两字符串的相似度
     */
    public double getSimilarity(String str1, String str2) {
        int max = Math.max(str1.length(), str2.length());
        if (max == 0) {
            return 0f;
        } else {
            return 1 - (double) compare(str1, str2) / max;
        }
    }
}
