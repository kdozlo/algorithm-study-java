package boj;

import java.io.*;

/**
* 백준 2661
* 좋은수열
* 골드4
* https://www.acmicpc.net/problem/2661
*/
public class Boj2661 {

    private static StringBuilder sb;
    private static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        sb = new StringBuilder("1");

        findArray(N, 1);
    }

    public static void findArray(int n, int cnt) {
        if(check)
            return;

        if (cnt == n) {
            check = true;
            System.out.println(sb.toString());

            return;
        }

        for (int i = 1; i < 4; i++) {
            sb.append(i);
            if (isPossible(sb.toString())) {
                findArray(n, cnt + 1);
            }

            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static boolean isPossible(String s) {
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            String sub1 = s.substring(len - i, len);
            String sub2 = s.substring(len - 2 * i, len - i);
            if (sub1.equals(sub2)) {
                return false;
            }
        }
        return true;
    }
}
