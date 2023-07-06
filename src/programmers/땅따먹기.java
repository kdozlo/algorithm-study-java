package programmers;

/**
 * 프로그래머스 - 땅따먹기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12913
 */
public class 땅따먹기 {

    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};

        int answer = 0;

        int[][] dp = new int[land.length][4];

        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < 4; j++) {
                if(i == 0) {
                    dp[i][j] = land[i][j];
                    continue;
                }

                for(int k = 0; k < 4; k++) {
                    if(k == j)
                        continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
                }

            }
        }

        for(int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[land.length - 1][i]);

        }

        System.out.println(answer);
    }
}
