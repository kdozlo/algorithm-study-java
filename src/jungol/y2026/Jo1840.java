package jungol.y2026;

import java.util.*;
import java.io.*;

/*
 * 정올 1840
 * 치즈
 * 골드4
 * https://jungol.co.kr/problem/1840
 */
public class Jo1840 {

    private static final int[] dr = {0, -1, 0, 1};
    private static final int[] dc = {-1, 0, 1, 0};

    private static int c, r;
    private static boolean[][] plate;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        plate = new boolean[r][c];
        count = 0;

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < c; j++) {
                plate[i][j] = st.nextToken().equals("1");
                if(plate[i][j])
                    count++;
            }
        }

        int time = 0;
        int last = 0;

        while(count > 0) {
            last = count;
            melting();
            time++;
        }

        System.out.println(time);
        System.out.println(last);
    }

    private static void melting() {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> cheezes = new ArrayList<>();
        boolean[][] visited = new boolean[r][c];
        q.add(new int[] {0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr < 0 || nr >= r || nc < 0 || nc >= c)
                    continue;

                if(visited[nr][nc])
                    continue;

                visited[nr][nc] = true;

                if(plate[nr][nc]) {
                    cheezes.add(new int[]{nr, nc});
                } else {
                    q.add(new int[]{nr, nc});
                }
            }
        }

        for(int[] i : cheezes) {
            plate[i[0]][i[1]] = false;
            count--;
        }
    }
}
