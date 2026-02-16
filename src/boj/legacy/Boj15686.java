package boj.legacy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 15686
 * 치킨 배달
 * 골드 5
 * https://www.acmicpc.net/problem/15686
 */
public class Boj15686 {
    static class Node{
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean[] visited;
    static List<Node> home;
    static List<Node> chicken;
    static int minD = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][n + 1];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    Node node = new Node(i, j);
                    home.add(node);
                }

                if(map[i][j] == 2) {
                    Node node = new Node(i, j);
                    chicken.add(node);
                }
            }
        }

        visited = new boolean[chicken.size()];

        chooseChicken(0, m);

        System.out.println(minD);

    }

    public static void chooseChicken(int start, int m) {
        if(m == 0) {
            //집에서 가장 가까운 치킨집 구하기
            int totalMin = 0;

            for(int i = 0; i < home.size(); i++) {
                int min = Integer.MAX_VALUE;
                for(int j = 0; j < chicken.size(); j++) {
                    if(visited[j]) {
                        Node node = chicken.get(j);
                        int temp = Math.abs(home.get(i).x - chicken.get(j).x) +
                                Math.abs(home.get(i).y - chicken.get(j).y);
                        min = Math.min(min, temp);
                    }
                }
                totalMin += min;
            }

            minD = Math.min(minD, totalMin);
        } else {
            for(int i = start; i < chicken.size(); i++) {
                visited[i] = true;
                chooseChicken(i + 1, m - 1);
                visited[i] = false;
            }
        }


    }
}
