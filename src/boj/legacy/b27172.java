package boj.legacy;

import java.util.*;
import java.io.*;

/*
 * 백준 27172
 * 수 나누기 게임
 * 골드 5
 * https://www.acmicpc.net/problem/27172
 */
public class b27172 {

    static int n;
    static int[] cards;
    static int[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        cards = new int[1000001];
        int max = 0;
        int min = 1000001;
        for(int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            cards[cur] = i + 1;
        }

        scores = new int[n];
        for(int i = min; i <= max; i++) {
            int index1 = cards[i] - 1;

            if(index1 < 0)
                continue;

            int end = max / i;

            for(int j = 2; j <= end; j++) {
                int index2 = cards[i * j] - 1;
                if(index2 >= 0) {
                    scores[index1] += 1;
                    scores[index2] -= 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++)
            sb.append(scores[i]).append(" ");

        System.out.println(sb.toString());
    }

}
