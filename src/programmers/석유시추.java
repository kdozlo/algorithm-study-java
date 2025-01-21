package programmers;

/**
* 프로그래머스 250136
* 석유 시추
* lv2
* https://school.programmers.co.kr/learn/courses/30/lessons/250136
*/
public class 석유시추 {

    private static int r;
    private static int c;
    private static int[] cols;
    private static boolean[] colVisited;
    private static int cnt;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {

        int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};

        r = land.length;
        c = land[0].length;
        cols = new int[c];

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(land[i][j] == 1) {
                    colVisited = new boolean[c];
                    cnt = 0;

                    colVisited[j] = true;
                    land[i][j] = 2;

                    dfs(i, j, land);

                    for(int k = 0; k < c; k++) {
                        if(colVisited[k]) {
                            cols[k] += cnt;
                        }
                    }

                }
            }
        }

        int answer = cols[0];
        for(int i = 1; i < c; i++) {
            if(answer < cols[i])
                answer = cols[i];
        }

        System.out.println(answer); // 9
    }

    public static void dfs(int x, int y, int[][] land) {
        cnt++;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= r || ny < 0 || ny >= c)
                continue;

            if(land[nx][ny] != 1)
                continue;

            land[nx][ny] = 2;
            colVisited[ny] = true;
            dfs(nx, ny, land);

        }

    }
}
