package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 백준 11659
 * 구간 합 구하기 4
 * 실버3
 * https://www.acmicpc.net/problem/11659
 */
public class Boj11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] ary = new int[n];
        st = new StringTokenizer(br.readLine());
        ary[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i < n; i++) {
            ary[i] = ary[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            if(s == 0)
                System.out.println(ary[e]);
            else
                System.out.println(ary[e] - ary[s-1]);
        }

    }
}
