package boj;

import java.util.*;
import java.io.*;

/**
* 백준 2252
* 줄 세우기
* 골드3
* https://www.acmicpc.net/problem/2252
*/
public class Boj2252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); //학생 수
        int M = Integer.parseInt(st.nextToken()); // 비교 회수

        List<Integer>[] l = new List[N + 1];
        for(int i = 1; i <= N; i++)
            l[i] = new ArrayList<>();

        int[] inDegree = new int[N + 1];
        while(M-- >0) {
            st = new StringTokenizer(br.readLine());

            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());

            l[s1].add(s2);
            inDegree[s2]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for(int next : l[cur]) {
                inDegree[next]--;

                if(inDegree[next] == 0)
                    q.add(next);
            }
        }

        System.out.print(sb);
    }
}
