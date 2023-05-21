package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 프로그래머스 - 의상
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
public class 의상 {

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        int answer = 1;

        Map<String, Integer> kindNum = new HashMap<>();

        for(int i = 0; i < clothes.length; i++) {
            if(kindNum.containsKey(clothes[i][1])) {
                kindNum.put(clothes[i][1], kindNum.get(clothes[i][1]) + 1);
            } else {
                kindNum.put(clothes[i][1], 1);
            }
        }

        Set<String> keySet = kindNum.keySet();

        for(String k : keySet) {
            answer *= kindNum.get(k) + 1;
        }

        System.out.println(answer - 1);
    }
}
