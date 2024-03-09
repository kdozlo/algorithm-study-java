package boj;

import java.util.*;
import java.io.*;

/*
 * 백준 1764
 * 듣보잡
 * 실버 4
 * https://www.acmicpc.net/problem/1764
 */
public class b1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<String> s = new HashSet<>();
        PriorityQueue<String> pq = new PriorityQueue<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            s.add(br.readLine());
        }


        for(int i = 0; i < m; i++) {
            String cur = br.readLine();
            if(s.contains(cur))
                pq.add(cur);
        }

        System.out.println(pq.size());
        while(!pq.isEmpty())
            System.out.println(pq.poll());
    }
}
