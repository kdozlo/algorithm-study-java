package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.ArrayList;

/**
 * 프로그래머스 - 과제 진행하기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/176962
 * 풀이봄 - 다시하기
 */
public class 과제진행하기 {

    public static void main(String[] args) {

        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};

        LinkedList<Homework> list = new LinkedList<>();

        for (String[] plan : plans) {
            list.add(new Homework(plan[0], convert(plan[1]), Integer.parseInt(plan[2])));
        }

        list.sort((h1, h2) -> h1.start - h2.start);

        Stack<Homework> stack = new Stack<>();
        ArrayList<String> end = new ArrayList<>();

        while(!list.isEmpty()) {
            Homework h = list.poll();

            if(!list.isEmpty() && h.start + h.playtime > list.get(0).start) {
                h.playtime -= list.get(0).start - h.start;
                stack.push(h);
            } else {
                end.add(h.name);

                if(!list.isEmpty()) {
                    int time = list.get(0).start - h.start - h.playtime;

                    while (time > 0 && !stack.isEmpty()) {
                        Homework homework = stack.pop();

                        if(homework.playtime > time) {
                            homework.playtime -= time;
                            time = 0;
                            stack.push(homework);
                        } else {
                            time -= homework.playtime;
                            end.add(homework.name);
                        }
                    }
                }
            }
        }

        while(!stack.isEmpty()) {
            end.add(stack.pop().name);
        }

        String[] answer = new String[plans.length];

        for (int i = 0; i < end.size(); i++) {
            answer[i] = end.get(i);
        }

        System.out.println(Arrays.toString(answer));


    }

    private static int convert(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    static class Homework {
        String name;
        int start;
        int playtime;

        Homework(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
}
