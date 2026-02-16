package boj.legacy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 20055
 * 컨베이어 벨트 위의 로봇
 * 골드 5
 * https://www.acmicpc.net/problem/20055
 */
public class Boj20055 {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n * 2];
        Boolean[] location = new Boolean[n];
        Arrays.fill(location, false);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n * 2; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        while(true) {
            answer++;

            int temp = a[2 * n - 1];
            //벨트 이동
            for(int i = 2 * n - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = temp;

            //벨트 이동에 따른 로봇 위치 이동
            for(int i = n - 1; i > 0; i--) {
                location[i] = location[i - 1];
            }
            location[0] = false;

            //내리는 곳에서 로봇 내리기
            location[n - 1] = false;

            //로봇 이동
            for (int i = n -1; i > 0; i--) {
                if(location[i - 1] && !location[i]) {
                    if(a[i] > 0) {
                        a[i]--;
                        location[i] = true;
                        location[i - 1] = false;
                    }
                }
            }

            //로봇 올리기
            if(!location[0] && a[0] > 0) {
                location[0] = true;
                a[0]--;
            }

            //로봇 내리기
            if (location[n -1]) {
                location[n - 1] = false;
            }

            int cnt = 0;
            for(int i = 0; i < 2 * n; i++) {
                if(a[i] == 0)
                    cnt++;
            }

            //종료 조건 확인
            if(cnt >= k)
                break;
        }

        System.out.println(answer);
    }
}
