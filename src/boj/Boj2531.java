package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2531
 * 회전 초밥
 * 실버1
 * https://www.acmicpc.net/problem/2531
 */
public class Boj2531 {

    public static void main(String[] argc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] dishes = new int[n];

        for (int i = 0; i < n; i++) {
            dishes[i] = Integer.parseInt(br.readLine());
        }

        int[] eat = new int[d + 1];
        int cnt = 0;

        for(int i = 0; i < k; i++) {
            if (eat[dishes[i]] == 0) {
                cnt++;
            }
            eat[dishes[i]]++;
        }

        if (eat[c] == 0) cnt++;
        
        int max = cnt;

        if (eat[c] == 0) cnt--;

        for(int i = 1; i < n; i++) {

            eat[dishes[i - 1]]--;
            if (eat[dishes[i - 1]] == 0) cnt--;

            int end = (i + k -1) % n;

            if (eat[dishes[end]] == 0) cnt++;

            eat[dishes[end]]++;

            if(eat[c] == 0) cnt++;

            max = Math.max(max, cnt);

            if(eat[c] == 0) cnt--;
        }

        System.out.println(max);

    }

}
