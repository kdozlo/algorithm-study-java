package boj.legacy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 백준 1806
 * 부분합
 * 골드4
 * https://www.acmicpc.net/problem/1806
 */
public class Boj1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] ary = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int length = 100000001;

        while (start < n) {
            if (sum > s || end == n) {
                sum -= ary[start];
                start++;
            } else {
                sum += ary[end];
                end++;
            }

            if(sum >= s)
                length = Math.min(length, end - start);
        }

        if (length == 100000001)
            System.out.println(0);
        else
            System.out.println(length);
    }
}
