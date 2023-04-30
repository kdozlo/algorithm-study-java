package programmers;

import java.util.Arrays;

/**
 * 프로그래머스 - 최솟값 만들기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12941
 */
public class 최솟값만들기 {
    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};

        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - i - 1];
        }

        System.out.println(answer);
    }
}
