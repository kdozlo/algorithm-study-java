package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * sw 5656
 * 벽돌 깨기
 */
public class sw5656 {

    static int n; //구슬 수
    static int w; //열
    static int h; //행

    static int min;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;

            int[][] plate = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    plate[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            play(0, plate);

            if(min == Integer.MAX_VALUE)
                min = 0;

            sb.append("#").append(tc).append(" ").append(min).append("\n");

        }

        System.out.println(sb);

    }

    //깰 벽돌 정하기 - 구슬 수 만큼
    public static void play(int cnt, int[][] plate) {
        if(cnt == n) {

            int b = 0;
            //남은 벽돌 세기
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(plate[i][j] != 0)
                        b += 1;
                }
            }

            min = Math.min(min, b);
            return;
        }

        for(int c = 0; c < w; c++) {
            int[][] temp = new int[h][w];

            copyPlate(temp, plate);

            for(int r = 0; r < h; r++) {
                if(temp[r][c] != 0) {
                    destroy(temp, r, c);
                    down(temp);
                    play(cnt + 1, temp);
                    break;
                }
            }

        }
    }

    // 벽돌 깨기
    public static void destroy(int[][] temp, int r, int c) {

        int size = temp[r][c];

        temp[r][c] = 0;

        for(int i = 0; i < 4; i++) {
            for(int j = 1; j < size; j++) {
                int nx = r + dx[i] * j;
                int ny  = c + dy[i] * j;

                if(nx >= h || nx < 0 || ny >= w || ny < 0 ||
                temp[nx][ny] == 0)
                    continue;

                destroy(temp, nx, ny);
            }
        }
    }

    //벽돌 내리기
    public static void down(int[][] temp) {

        for(int c = 0; c < w; c++) {
            int[] row = new int[h];
            int index = h - 1;

            for(int r = h - 1; r >= 0; r--) {
                if(temp[r][c] != 0)
                    row[index--] = temp[r][c];
            }

            for(int r = 0; r < h; r++) {
                temp[r][c] = row[r];
            }
        }
    }

    public static void copyPlate(int[][] temp, int[][] plate) {
        for(int r = 0; r < h; r++) {
            temp[r] = plate[r].clone();
        }
    }


}
