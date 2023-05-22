package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 프로그래머스 - 튜플
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/64065
 */
public class 튜플 {

    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        s = s.substring(2, s.length() - 2);
        s = s.replace("},{", "-");

        String[] d = s.split("-");

        Arrays.sort(d, (d1, d2) -> d1.length() - d2.length());

        List<Integer> answer = new ArrayList<>();
        for(String t : d) {
            String[] col = t.split(",");

            for(int i = 0; i < col.length; i++) {
                int colInt = Integer.parseInt(col[i]);

                if(!answer.contains(colInt)) {
                    answer.add(colInt);
                }
            }
        }


        System.out.println(answer);
    }
}
