package boj.legacy;

import java.io.*;
import java.util.*;

/**
* 백준 1106
* 호텔
* 골드4
* https://www.acmicpc.net/problem/1106
*/
public class Boj1106 {

    private static class City {
        int cost;
        int people;

        public City(int cost, int people) {
            this.cost = cost;
            this.people = people;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken()); // 늘려야 하는 고객 수
        int N = Integer.parseInt(st.nextToken()); // 도시 수

        City[] cities = new City[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int person = Integer.parseInt(st.nextToken());
            cities[i] = new City(cost, person);
        }

        int len = C + 101;
        int[] dp = new int[len];
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for(int i = 0; i < len; i++) {
            for(City c : cities) {
                int next = i + c.people;
                if(next < len) {
                    dp[next] = Math.min(dp[next], dp[i] + c.cost);
                }
            }
        }

        int answer = dp[C];
        for(int i = C + 1; i < len; i++)
            answer = Math.min(answer, dp[i]);

        System.out.println(answer);
    }
}
