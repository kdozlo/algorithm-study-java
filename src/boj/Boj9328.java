package boj;

import java.util.*;
import java.io.*;

/**
* 백준 9328
* 열쇠
* 골드1
* https://www.acmicpc.net/problem/9328
*/
public class Boj9328 {

    private static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int h;
    private static int w;
    private static Set<Character> keys;
    private static char[][] map;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            for(int i = 0; i < h; i++)
                map[i] = br.readLine().toCharArray();

            keys = new HashSet<>();
            for(char c : br.readLine().toCharArray())
                keys.add(Character.toUpperCase(c));

            sb.append(bfs()).append("\n");
        }

        System.out.print(sb);
    }

    public static int bfs() {
        int result = 0;

        Queue<Node> q = new LinkedList<>();
        Queue<Node> later = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];

        for(int i = 0; i < h; i++) {
            if(map[i][0] != '*' && !visited[i][0]) {
                q.add(new Node(i, 0));
                visited[i][0] = true;
            }

            if(map[i][w - 1] != '*' && !visited[i][w - 1]) {
                q.add(new Node(i, w - 1));
                visited[i][w - 1] = true;
            }
        }

        for(int j = 0; j < w; j++) {
            if(map[0][j] != '*' && !visited[0][j]) {
                q.add(new Node(0, j));
                visited[0][j] = true;
            }

            if(map[h - 1][j] != '*'&& !visited[h - 1][j]) {
                q.add(new Node(h - 1, j));
                visited[h - 1][j] = true;
            }
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();
            char c = map[cur.x][cur.y];

            if(Character.isUpperCase(c)) {
                if(!keys.contains(c)) {
                    later.add(new Node(cur.x, cur.y));
                    continue;
                }
            } else if(Character.isLowerCase(c)) {
                keys.add(Character.toUpperCase(c));
                int index = later.size();
                while(index-- > 0) {
                    Node n = later.poll();
                    if(keys.contains(map[n.x][n.y])) {
                        q.add(new Node(n.x, n.y));
                        visited[n.x][n.y] = true;
                    } else {
                        later.add(n);
                    }
                }
            } else if(c == '$') {
                result++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= h || ny < 0 || ny >= w || visited[nx][ny])
                    continue;

                if(map[nx][ny] != '*') {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return result;
    }
}
