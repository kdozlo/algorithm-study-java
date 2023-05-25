package programmers;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프로세스 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        int answer = 0;

        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < priorities.length; i++) {
            q.add(priorities[i]);
        }

        int check = 0;
        while(!q.isEmpty()) {
            for(int i = 0; i < priorities.length; i++) {
                if(q.peek() == priorities[i]) {
                    if(location == i) {
                        answer++;
                        check = 1;
                        break;
                    }
                    q.poll();
                    answer++;
                }
            }

            if(check == 1)
                break;
        }

        System.out.println(answer);
    }
}
