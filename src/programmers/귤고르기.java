package programmers;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 프로그래머스 - 귤 고르기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/138476
 */
public class 귤고르기 {

    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(Integer i : tangerine) {
            if(map.containsKey(i))
                map.put(i,map.get(i) + 1);
            else
                map.put(i, 1);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());

        keySet.sort((k1, k2) -> map.get(k2) - map.get(k1));

        int cnt = 0;
        for (Integer key : keySet) {
            cnt += map.get(key);
            answer++;
            if(cnt >= k)
                break;
        }

        System.out.println(answer);
    }
}
