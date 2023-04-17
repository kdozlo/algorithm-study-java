package programmers;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 프로그래머스 - 추억 점수
 * Lv 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/176963
 */
public class 추억점수 {

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}};

        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            hm.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];

        Arrays.fill(answer, 0);

        for (int i = 0; i < photo.length; i++) {
            for(String cur : photo[i]) {
                if (hm.containsKey(cur)) {
                    answer[i] += hm.get(cur);
                }
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}
