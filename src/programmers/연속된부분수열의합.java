package programmers;

import java.util.Arrays;

/**
 * 프로그래머스 - 연속된 부분 수열의 합
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/178870
 */
public class 연속된부분수열의합 {

    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;

        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = sequence.length - 1;

        int start = 0;
        int end = 0;
        int sum = 0;

        while(start < sequence.length) {
            if(sum > k || end == sequence.length) {
                sum -= sequence[start];
                start++;
            } else {
                sum += sequence[end];
                end++;
            }

            if (sum == k) {
                //인덱스 범위 체크
                if(answer[1] - answer[0] > end - start - 1) {
                    answer[0] = start;
                    answer[1] = end - 1;
                }
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}
