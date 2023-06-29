package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 프로그래머스 - 더 맵게
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class 더맵게 {

    public static void main(String[] args) {

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        int answer = 0;

        Queue<Integer> minHeap = new PriorityQueue<>();

        for(int s : scoville) {
            minHeap.add(s);
        }

        while(true) {
            //스코빌 지수 체크
            if(minHeap.peek() >= K)
                break;

            if(minHeap.size() == 1 && minHeap.peek() < K) {
                answer = -1;
                break;
            }


            //스코빌 섞기
            int s1 = minHeap.poll();
            int s2 = minHeap.poll();

            minHeap.add(s1 + s2 * 2);

            answer++;
        }

        System.out.println(answer);
    }
}
