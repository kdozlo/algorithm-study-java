package boj.legacy;

import java.io.*;

/**
* 백준 2529
* 부등호
* 실버1
* https://www.acmicpc.net/problem/2529
*/
public class Boj2529 {

    private static int k;
    private static String[] symbols;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        symbols = br.readLine().split(" ");

        System.out.println(getMax());
        System.out.println(getMin());
    }

    private static String getMax() {
        StringBuilder sb = new StringBuilder();
        int num = 9;
        int cnt = 0;
        for(String s : symbols) {
            if(s.equals(">")) {
                for(int i = num - cnt; i <= num; i++) {
                    sb.append(i);
                }
                num = num - cnt - 1;
                cnt = 0;
            } else {
                cnt++;
            }
        }

        for(int i = num - cnt; i <= num; i++) {
            sb.append(i);
        }

        return sb.toString();
    }

    private static String getMin() {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        int cnt = 0;
        for(String s : symbols) {
            if(s.equals("<")) {
                for(int i = num + cnt; i >= num; i--) {
                    sb.append(i);
                }
                num = num + cnt + 1;
                cnt = 0;
            } else {
                cnt++;
            }
        }

        for(int i = num + cnt; i >= num; i--) {
            sb.append(i);
        }

        return sb.toString();
    }
}
