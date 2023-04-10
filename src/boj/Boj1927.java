package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * 백준 1927
 * 최소 힙
 * 실버 2
 * https://www.acmicpc.net/problem/1927
 */
public class Boj1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0 && pq.isEmpty()) {
                sb.append(0);
                sb.append("\n");
            } else if(x == 0 && !pq.isEmpty()){
                sb.append(pq.poll());
                sb.append("\n");
            } else {
                pq.add(x);
            }
        }

        System.out.println(sb);
    }
}
