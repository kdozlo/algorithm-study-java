package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 1520
* 내리막 길
* 골드3
* https://www.acmicpc.net/problem/1520
*/
public class Boj1520 {

    private static class Node implements Comparable<Node> {
        int x, y, h;

        Node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(n.h, h);
        }
    }


    private static int M;
    private static int N;
    private static int[][] map;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        int[][] dp = new int[M][N];
        dp[0][0] = 1;

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, map[0][0]));

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.x == M - 1 && cur.y == N - 1)
                continue;

            if(map[cur.x][cur.y] <= map[M -1][N - 1])
                continue;

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N)
                    continue;

                if(map[cur.x][cur.y] <= map[nx][ny])
                    continue;

                if(dp[nx][ny] == 0)
                    q.add(new Node(nx, ny, map[nx][ny]));
                dp[nx][ny] += dp[cur.x][cur.y];
            }
        }

        return dp[M - 1][N - 1];
    }
}
