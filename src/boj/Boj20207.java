package boj;

import java.util.*;
import java.io.*;

/**
* 백준 20207
* 달력
* 골드5
* https://www.acmicpc.net/problem/20207
*/
public class Boj20207 {

    private static final int END = 365;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] sum = new int[END];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()) - 1;
            int E = Integer.parseInt(st.nextToken()) - 1;

            for(int j = S; j <= E; j++)
                sum[j]++;
        }

        int width = 0;
        int r = 0;
        int c = 0;
        for(int i = 0; i < END; i++) {
            if(sum[i] == 0) {
                width += r * c;
                r = 0;
                c = 0;
            } else {
                r++;
                c = Math.max(c, sum[i]);
            }
        }

        width += r * c;

        System.out.println(width);
    }
}
