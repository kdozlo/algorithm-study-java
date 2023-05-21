package programmers;

import java.util.Arrays;

/**
 * 프로그래머스 - n^2 배열 자르기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/87390
 */
public class n곱하기n배열자르기 {

    public static void main(String[] args) {
        int n = 3;
        long left = 2;
        long right = 5;

        int[] answer = new int[Long.valueOf(right - left + 1).intValue()];

        int cnt = 0;
        for(long i = left; i < right + 1; i++) {
            int row = Long.valueOf(i / n).intValue();
            int col = Long.valueOf(i % n).intValue();

            answer[cnt++] = Math.max(row + 1, col + 1);
        }

        System.out.println(Arrays.toString(answer));
    }
}
