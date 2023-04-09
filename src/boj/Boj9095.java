package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 백준 9095
 * 1, 2, 3 더하기
 * 실버3
 * https://www.acmicpc.net/problem/9095
 */
public class Boj9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(countNum(n));
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static int countNum(int n) {
        if (n == 0)
            return 1;

        if (n < 0)
            return 0;

        return countNum(n -1) + countNum(n - 2) + countNum(n - 3);
    }
}
