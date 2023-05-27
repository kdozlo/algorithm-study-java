package programmers;

/**
 * 프로그래머스 - 피로도
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
public class 피로도 {
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        visited = new boolean[dungeons.length];

        dfs(0, k, dungeons);

        System.out.println(count);
    }

    public static void dfs(int d, int k, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            if (visited[i] || k < dungeons[i][0])
                continue;
            visited[i] = true;
            dfs(d+1, k - dungeons[i][1], dungeons);
            visited[i] = false;
        }

        count = Math.max(count, d);
    }
}
