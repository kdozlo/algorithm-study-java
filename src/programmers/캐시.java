package programmers;

import java.util.Queue;
import java.util.LinkedList;

/**
 * 프로그래머스 - 캐시
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/17680
 */
public class 캐시 {

    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int answer = 0;

        Queue<String> queue = new LinkedList<>();

        for(String s : cities) {
            s = s.toLowerCase();

            if(queue.contains(s)) {
                queue.remove(s);
                queue.add(s);
                answer += 1;
            } else {
                if(cacheSize != 0) {
                    queue.poll();
                    queue.add(s);
                } else if (queue.size() < cacheSize) {
                    queue.add(s);
                }
                answer += 5;
            }
        }
        // result : 50
        System.out.println(answer);
    }
}
