package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 - [1차] 뉴스 클러스터링
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/17677
 */
public class 뉴스클러스터링 {

    public static void main(String[] args) {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";

        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> one = substringTwo(str1);
        Map<String, Integer> two = substringTwo(str2);

        int comm = 0;
        int sum = 0;

        for(String k : one.keySet()) {
            if(two.containsKey(k)) {
                comm += Math.min(one.get(k), two.get(k));
                sum += Math.max(one.get(k), two.get(k));
            } else {
                sum += one.get(k);
            }
        }

        for(String k : two.keySet()) {
            if(!one.containsKey(k))
                sum += two.get(k);
        }

        double d = (double)comm / (double)sum;

        answer = (int) (d * 65536);

        if(one.size() == 0 && two.size() == 0)
            answer = 65536;

        System.out.println(answer);
    }

    public static Map<String, Integer> substringTwo(String str) {
        Map<String, Integer> m = new HashMap<>();
        String match = "[^a-zA-Z]";


        for(int i = 0; i < str.length() - 1; i++) {
            String k = str.substring(i, i+2);
            k = k.replaceAll(match, "");

            if(k.length() < 2) {
                continue;
            }

            if(m.containsKey(k)) {
                m.put(k, m.get(k) + 1);
            } else {
                m.put(k, 1);
            }
        }

        return m;
    }
}
