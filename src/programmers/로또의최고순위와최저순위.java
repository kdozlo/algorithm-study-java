package programmers;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 프로그래머스 - 로또의 최고 순위와 최저 순위
 * Lv 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/77484?language=java
 */
public class 로또의최고순위와최저순위 {

    public static void main(String[] args) {
        int[] answer = new int[2];
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        HashMap<Integer, Boolean> checkWin = new HashMap<>();

        for(int cur : win_nums) {
            checkWin.put(cur, false);
        }

        int zeroNum = 0;

        for(int cur : lottos) {
            if (cur == 0) {
                zeroNum += 1;
            } else if (checkWin.containsKey(cur)) {
                checkWin.put(cur, true);
            }
        }

        int falseNum = 0;

        for(int cur : win_nums) {
            if (checkWin.get(cur) == false) {
                falseNum += 1;
            }
        }

        //틀린 숫자 개수
        int best = falseNum - zeroNum;

        //최고
        if (best > 4){
            answer[0] = 6;
        } else {
            answer[0] = best + 1;
        }

        //최저
        if (falseNum > 4) {
            answer[1] = 6;
        }  else {
            answer[1] = falseNum + 1;
        }

        System.out.println(Arrays.toString(answer));
    }
}
