package programmers;

import java.util.Arrays;

/**
 * 프로그래머스 - 이모티콘 할인행사
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/150368
 */
public class 이모티콘할인행사 {

    public static void main(String[] args) {
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};

        int[] answer = {0, 0};

        int[] sales = {1, 2, 3, 4};
        int[] salesCase = new int[emoticons.length];

        //할인 중복 순열 구하기
        permutation(0, sales, salesCase, emoticons, users, answer);

        //result 1, 5400
        System.out.println(Arrays.toString(answer));
    }

    private static void permutation(int cnt, int[] sales, int[] salesCase, int[] emoticons, int[][] users, int[] answer) {
        if (cnt == salesCase.length) {

            int[] tempAnswer = {0, 0};

            for (int i = 0; i < users.length; i++) {
                int tempPrice = 0;

                for (int j = 0; j < emoticons.length; j++) {
                    if ( salesCase[j] * 10 >= users[i][0] ) {
                        tempPrice += emoticons[j] - emoticons[j] * salesCase[j] / 10;
                    }
                }

                if (tempPrice >= users[i][1]) {
                    tempAnswer[0]++;
                } else {
                    tempAnswer[1] += tempPrice;
                }
            }

            if (tempAnswer[0] > answer[0]) {
                answer[0] = tempAnswer[0];
                answer[1] = tempAnswer[1];
            } else if (tempAnswer[0]  == answer[0]) {
                answer[1] = Math.max(tempAnswer[1], answer[1]);
            }

            return;
        }

        for(int i : sales) {
            salesCase[cnt] = i;
            permutation(cnt+1, sales, salesCase, emoticons, users, answer);
        }
    }
}
