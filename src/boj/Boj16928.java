package boj;

import java.io.*;
import java.util.*;

/**
 * 백준 16928
 * 뱀과 사다리 게임
 * 골드5
 * https://www.acmicpc.net/problem/16928
 */
public class Boj16928 {

    static int N; // 사다리 수
    static int M; // 뱀 수
    static int[] info; // 사다리, 뱀 정보
    static int[] mInfo; // 뱀 정보

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        info = new int[101];

        for(int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            info[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs());
    }

    public static int bfs() {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[101];
        q.add(1); // 현재 위치, 굴린 횟수
        visited[1] = true;
        int answer = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            answer++;

            while(size > 0) {
                int cur = q.poll();
                for(int i = 1; i <= 6; i++) {
                    int next = cur + i;

                    if(next == 100) {
                        return answer;
                    }

                    if(next > 100 || visited[next])
                        continue;

                    visited[next] = true;
                    if(info[next] > 0) {
                        q.add(info[next]);
                    } else {
                        q.add(next);
                    }
                }
                size--;
            }
        }

        return answer;
    }
}
