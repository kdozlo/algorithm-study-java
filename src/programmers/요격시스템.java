package programmers;

import java.util.Arrays;

/**
 * 프로그래머스 - 요격 시스템
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/181188
 */
public class 요격시스템 {

    public static void main(String[] args) {
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};

        int answer = 0;
        Arrays.sort(targets, (x, y) -> {
            return (x[1] - y[1]);
        });

        int attack = -1;
        for(int[] target : targets) {
            if(attack == -1) {
                answer += 1;
                attack = target[1] - 1;
            }

            if (attack >= target[0] && attack <= target[1]) continue;
            answer += 1;
            attack = target[1] - 1;
        }

        System.out.println(answer);
    }
}
