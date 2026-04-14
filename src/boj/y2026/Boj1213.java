package boj.y2026;

import java.util.*;
import java.io.*;

/*
 * 백준 1213
 * 팰린드롬 만들기
 * 실버3
 * https://www.acmicpc.net/problem/1213
 */
public class Boj1213 {

    private static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = new int[26];

        for(char c : br.readLine().toCharArray()) {
            count[c - 'A']++;
        }

        int result = getOdd();
        if(result == -2) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }

        String front = sb.toString();
        String back = sb.reverse().toString();
        String center = result == -1 ? "" : String.valueOf((char) (result + 'A'));
        System.out.println(front + center + back);
    }

    private static int getOdd() {
        int valve = -1;
        int cnt = 0;

        for(int i = 0; i < 26; i++) {
            if(count[i] % 2 == 1) {
                valve = i;
                cnt++;
            }
            if(cnt > 1)
                return -2;
        }

        return valve;
    }
}
