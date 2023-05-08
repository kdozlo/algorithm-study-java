package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 - 영어 끝말잇기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12981
 */
public class 영어끝말잇기 {

    public static void main(String[] args) {
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int n = 3;
        int[] answer = new int[2];

        Map<String, Integer> wordsMap = new HashMap<>();

        wordsMap.put(words[0], 1);
        for(int i = 1; i < words.length; i++) {
            if(!words[i - 1].substring(words[i-1].length()-1, words[i-1].length()).equals(words[i].substring(0,1)) || wordsMap.containsKey(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            } else {
                wordsMap.put(words[i], i / n + 1);
            }
        }

        //result : 3,3
        System.out.println(Arrays.toString(answer));
    }
}
