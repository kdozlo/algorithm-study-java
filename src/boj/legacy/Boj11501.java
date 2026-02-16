package boj.legacy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11501
 * 주식
 * 실버2
 * https://www.acmicpc.net/problem/11501
 */
public class Boj11501 {

    public static void main(String[] argc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long ary[] = new long[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ary[j] = Integer.parseInt(st.nextToken());
            }

            long max = 0;
            long sum = 0;
            for (int j = n - 1; j > -1; j--) {
                if (ary[j] > max) {
                    max = ary[j];
                } else {
                    sum += (max - ary[j]);
                }
            }
            sb.append(sum+"\n");
        }

        System.out.println(sb);
        br.close();
    }
}
