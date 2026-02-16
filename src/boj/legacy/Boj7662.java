package boj.legacy;

import java.util.*;
import java.io.*;

/**
 * 백준 7662
 * 이중 우선순위 큐
 * 골드4
 * https://www.acmicpc.net/problem/7662
 */
public class Boj7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minPQ= new PriorityQueue<>();
            Map<Integer, Integer> cnt = new HashMap<>();

            while(k --> 0) {
                st = new StringTokenizer(br.readLine());

                String s = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if(s.equals("I")) {

                    maxPQ.add(n);
                    minPQ.add(n);
                    cnt.put(n, cnt.getOrDefault(n, 0) + 1);
                } else {
                    if(cnt.isEmpty())
                        continue;

                    if(n == 1) {
                        remove(maxPQ, cnt);
                    } else {
                        remove(minPQ, cnt);
                    }
                }
            }

            if(cnt.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                int answer = remove(maxPQ, cnt);
                sb.append(answer).append(" ");

                if(!cnt.isEmpty())
                    answer = remove(minPQ, cnt);
                sb.append(answer).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static int remove(PriorityQueue<Integer> pq, Map<Integer, Integer> map) {
        int cur;
        while(true) {
            cur = pq.poll();
            int count = map.getOrDefault(cur, 0);
            if(count == 0) continue;
            if(count == 1) map.remove(cur);
            else map.put(cur, count - 1);
            break;
        }
        return cur;
    }
}
