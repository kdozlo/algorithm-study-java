package boj;

import java.io.*;
import java.util.*;

/**
 * 백준 1477
 * 휴게소 세우기
 * 골드4
 * https://www.acmicpc.net/problem/1477
 */
public class Boj1477 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 휴게소 개수
        int M = Integer.parseInt(st.nextToken()); // 만들어야 하는 휴게소
        int L = Integer.parseInt(st.nextToken()); // 총 거리

        int[] rest = new int[N + 2];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            rest[i] = Integer.parseInt(st.nextToken());
        }
        rest[N] = 0;
        rest[N + 1] = L;

        Arrays.sort(rest);

        int start = 1;
        int end = L;
        int result = 0;

        while(start <= end) {
            int mid = (start + end) / 2;

            if (isPossible(mid, M, rest)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
    }

    public static boolean isPossible(int target, int M, int[] rest) {
        int cnt = 0;

        for(int i = 1; i < rest.length; i++) {
            int dif = rest[i] - rest[i - 1];
            cnt += (dif - 1) / target;
        }

        return cnt <= M;
    }
}
