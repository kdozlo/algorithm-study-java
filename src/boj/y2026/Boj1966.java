package boj.y2026;

import java.io.*;
import java.util.*;

/*
 * 백준 1966
 * 프린터 큐
 * 실버3
 * https://www.acmicpc.net/problem/1966
 */
public class Boj1966 {

    private static class Node {
        int index;
        int cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {
             StringTokenizer st = new StringTokenizer(br.readLine());
             int n = Integer.parseInt(st.nextToken());
             int m = Integer.parseInt(st.nextToken());

             int[] count = new int[10];
             Queue<Node> q = new LinkedList<>();
             st = new StringTokenizer(br.readLine());
             for(int i = 0; i < n; i++) {
                 int cost = Integer.parseInt(st.nextToken());
                 count[cost]++;
                 q.add(new Node(i, cost));
             }

             int max = 0;
             for(int i = 9; i >= 0; i--)
                 if(count[i] != 0) {
                     max = i;
                     break;
                 }

             int answer = 0;
             while(max != 0) {
                 while(count[max] == 0)
                     max--;

                 Node cur = q.poll();
                 if(cur.cost == max && cur.index == m) {
                     answer++;
                     break;
                 }

                 if(cur.cost == max) {
                     answer++;
                     count[max]--;
                 } else {
                     q.add(cur);
                 }
             }

             sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
