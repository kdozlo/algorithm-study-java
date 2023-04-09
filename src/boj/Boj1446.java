package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * 백준 1446
 * 지름길
 * 실버1
 * https://www.acmicpc.net/problem/1446
 */
public class Boj1446 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] distance = new int[n][3];
        int[] dp = new int[d + 1];

        for(int i = 0; i < d + 1; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            //start
            distance[i][0] = Integer.parseInt(st.nextToken());
            //end
            distance[i][1] = Integer.parseInt(st.nextToken());
            //shortcut
            distance[i][2] = Integer.parseInt(st.nextToken());

            for(int j = 1; j < d + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1] + 1);
                if (j == distance[i][1]) {
                    dp[j] = Math.min(dp[j], dp[distance[i][0]] + distance[i][2]);
                }
            }
        }

        Arrays.sort(distance, (a1, a2) -> {
            return a1[0] - a2[0];
        });

        for (int i = 0; i < n; i++) {
            for(int j = 1; j < d + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1] + 1);
                if (j == distance[i][1]) {
                    dp[j] = Math.min(dp[j], dp[distance[i][0]] + distance[i][2]);
                }
            }
        }

        System.out.println(dp[d]);
    }


}
