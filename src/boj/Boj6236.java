package boj;

import java.io.*;
import java.util.*;

/**
* 백준 6236
* 용돈 관리
* 실버1
* https://www.acmicpc.net/problem/6236
*/
public class Boj6236 {

    private static int[] money;
    private static int N; //일 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); //돈을 꺼낸 횟수

        money = new int[N];
        int left = 1;
        int right = 0;
        for(int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, money[i]);
            right += money[i];
        }

        while(left <= right) {
            int mid = (left + right) >>> 1;

            if(counting(mid) <= M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    public static int counting(int mid) {
        int cnt = 1;

        int rest = mid;
        for(int i : money) {

            if(rest - i < 0) {
                cnt++;
                rest = mid - i;
                continue;
            }

            rest -= i;
        }

        return cnt;
    }
}
