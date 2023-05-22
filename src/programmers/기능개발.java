package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스 - 기능개발
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */
public class 기능개발 {

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        List<Integer> answer = new ArrayList<>();

        int[] dDay = new int[progresses.length];

        for(int i = 0; i < dDay.length; i++) {
            int job = 100 - progresses[i];

            if(job % speeds[i] != 0) {
                dDay[i] = job / speeds[i] + 1;
            } else {
                dDay[i] = job / speeds[i];
            }
        }

        int predDay = dDay[0];
        int cnt = 1;
        for(int i = 1; i < dDay.length; i++) {
            if (predDay >= dDay[i]) {
                cnt++;
            } else {
                answer.add(cnt);
                cnt = 1;
                predDay = dDay[i];
            }
        }

        answer.add(cnt);

        System.out.println(answer);
    }
}
