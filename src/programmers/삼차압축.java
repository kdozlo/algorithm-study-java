package programmers;

import java.util.*;

/**
 * 프로그래머스 - 3차 압축
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/17684
 */
public class 삼차압축 {

    public static void main(String[] args) {
        String msg = "Z";

        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dic = new HashMap<>();

        for(int i = (int)'A'; i <= (int)'Z'; i++) {
            char c = (char) i;
            dic.put(Character.toString(c), i - (int)'A' + 1);
        }
        int curIndex = 27;
        for(int i = 0; i < msg.length(); i++) {
            String w = msg.charAt(i) + "";
            for(int j = i + 1; j < msg.length(); j++) {
                String wc = w + msg.charAt(j);
                if(!dic.containsKey(wc)) {
                    dic.put(wc, curIndex++);
                    answer.add(dic.get(w));
                    break;
                } else {
                    w = wc;
                    i = j;
                }
            }

            if(i == msg.length() - 1) {
                answer.add(dic.get(w));
                break;
            }
        }



        int[] a = new int[answer.size()];

        for(int i = 0; i < answer.size(); i++) {
            a[i] = answer.get(i);
        }

        System.out.println(Arrays.toString(a));
    }
}
