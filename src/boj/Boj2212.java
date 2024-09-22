package boj;

import java.io.*;
import java.util.*;

/**
 * 백준 2212
 * 센서
 * 골드5
 * https://www.acmicpc.net/problem/2212
 */
public class Boj2212 {

    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if(N <= K)
            System.out.println(0);
        else {
            int[] censor = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
                censor[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(censor);
            int[] dif = new int[N - 1];

            for(int i = 0; i < N - 1; i++)
                dif[i] = censor[i + 1] - censor[i];

            Arrays.sort(dif);

            int answer = 0;
            for (int i = 0; i < N - K; i++) {
                answer += dif[i];
            }

            System.out.println(answer);
        }
    }
}
