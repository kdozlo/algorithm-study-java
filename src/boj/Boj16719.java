package boj;

import java.io.*;

/**
 * 백준 16719
 * ZOAC
 * 골드5
 * https://www.acmicpc.net/problem/16719
 */
public class Boj16719 {

    private static StringBuilder sb = new StringBuilder();
    private static char[] str;
    private static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine().toCharArray();
        checked = new boolean[str.length];
        getChar(0, str.length - 1);

        System.out.print(sb);
    }

    private static void getChar(int start, int end) {

        if(start > end)
            return;

        // 현재 구간에서 가작 작은 알파벳 구하기
        int min = start;
        for(int i = start + 1; i <= end; i++) {
            if(checked[i])
                continue;
            if(str[min] > str[i])
                min = i;
        }

        checked[min] = true;
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < str.length; i++)
            if(checked[i])
                temp.append(str[i]);

        sb.append(temp).append("\n");

        getChar(min + 1, end);
        getChar(start, min - 1);
    }
}
