package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 10819
* 차이를 최대로
* 실버2
* https://www.acmicpc.net/problem/10819
*/
public class Boj10819 {

    private static int N;
    private static int[] A;

    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        answer = -200 * 8;
        factorial(new int[N], new boolean[N], 0);

        System.out.println(answer);
    }

    public static void factorial(int[] result, boolean[] checked, int cnt) {
        if(cnt == N) {
            answer = Math.max(answer, calculating(result));
            return;
        }

        for(int i = 0; i < N; i++) {
            if(checked[i])
                continue;
            checked[i] = true;
            result[cnt] = A[i];
            factorial(result, checked, cnt + 1);
            checked[i] = false;
        }

    }

    public static int calculating(int[] A) {
        int sum = 0;

        for(int i = 1; i < N; i++)
            sum += Math.abs(A[i - 1] - A[i]);

        return sum;
    }
}
