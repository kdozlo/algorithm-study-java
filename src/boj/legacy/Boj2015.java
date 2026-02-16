package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 2015
* 수들의 합 4
* 골드4
* https://www.acmicpc.net/problem/2015
*/
public class Boj2015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] sum = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());

        Map<Long, Long> m = new HashMap<>();
        long count = 0;

        m.put(0L, 1L);
        for(int i = 1; i <= N; i++) {
            count += m.getOrDefault(sum[i] - K, 0L);

            m.put(sum[i], m.getOrDefault(sum[i], 0L) + 1);
        }

        System.out.println(count);

    }
}
