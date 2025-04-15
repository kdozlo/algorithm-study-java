package boj;

import java.util.*;
import java.io.*;

/**
 * 백준 19236
 * 청소년 상어
 * 골드1
 * https://www.acmicpc.net/problem/19236
 */
public class Boj19236 {

    private static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Fish {
        int num;
        int dir;

        public Fish(int num, int dir) {
            this.num = num;
            this.dir = dir;
        }
    }

    private static Fish[][] space = new Fish[4][4];
    private static Map<Integer, Location> m;
    private static int max = 0;

    private static final int[] dx = {-1, -1 ,0, 1, 1, 1, 0, -1};
    private static final int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        m = new HashMap<>();

        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                m.put(a, new Location(i, j));
                space[i][j] = new Fish(a, b - 1);
            }
        }

        dfs(0, 0 , space[0][0].dir, space[0][0].num);

        System.out.println(max);

    }

    private static void dfs(int x, int y, int dir, int sum) {
        max = Math.max(max, sum);

        // 먹힌 물고기 반영
        m.remove(space[x][y].num);
        space[x][y] = null;

        // 물고기 이동
        movingFish(x, y);

        Fish[][] backupSpace = backupSpace(space);
        Map<Integer, Location> backupMap = backupMap(m);

        // 상어 이동 경로 지정
        for(int i = 1; i < 4; i++) {
            int nx = x + i * dx[dir];
            int ny = y + i * dy[dir];

            if(nx >= 4 || nx < 0 || ny >= 4 || ny < 0 || space[nx][ny] == null) {

                continue;
            }

            dfs(nx, ny, space[nx][ny].dir, sum + space[nx][ny].num);

            // 되돌리기
            space = backupSpace(backupSpace);
            m = backupMap(backupMap);
        }
    }

    private static void movingFish(int sx, int sy) {

        for(int i = 1; i < 17; i++) {
            if(m.containsKey(i)) {

                for(int j = 0; j < 8; j++) {
                    int dir = (space[m.get(i).x][m.get(i).y].dir + j) % 8;

                    int nx = m.get(i).x + dx[dir];
                    int ny = m.get(i).y + dy[dir];

                    // 범위 넘거나 상어인 경우 안됨
                    if(nx >= 4 || nx < 0 || ny >= 4 || ny < 0) {
                    } else if(nx == sx && ny == sy) {
                    } else {
                        space[m.get(i).x][m.get(i).y].dir = dir;

                        // 이동할 장소에 물고기가 있는지 판단
                        if(space[nx][ny] == null) {
                            space[nx][ny] = new Fish(space[m.get(i).x][m.get(i).y].num, space[m.get(i).x][m.get(i).y].dir);
                            space[m.get(i).x][m.get(i).y] = null;

                            m.get(i).x = nx;
                            m.get(i).y = ny;
                        } else {
                            Fish temp1 = space[nx][ny];
                            space[nx][ny] = space[m.get(i).x][m.get(i).y];
                            space[m.get(i).x][m.get(i).y] = temp1;

                            m.get(temp1.num).x = m.get(i).x;
                            m.get(temp1.num).y = m.get(i).y;

                            m.get(i).x = nx;
                            m.get(i).y = ny;
                        }

                        break;
                    }
                }
            }
        }
    }


    private static Fish[][] backupSpace(Fish[][] space) {
        Fish[][] backupSpace = new Fish[4][4];
        for (int ii = 0; ii < 4; ii++) {
            for (int jj = 0; jj < 4; jj++) {
                if (space[ii][jj] != null) {
                    backupSpace[ii][jj] = new Fish(space[ii][jj].num, space[ii][jj].dir);
                }
            }
        }

        return backupSpace;
    }

    private static Map<Integer, Location> backupMap(Map<Integer, Location> m) {

        Map<Integer, Location> backupMap = new HashMap<>();
        for (Map.Entry<Integer, Location> entry : m.entrySet()) {
            Location loc = entry.getValue();
            backupMap.put(entry.getKey(), new Location(loc.x, loc.y));
        }

        return backupMap;
    }
}