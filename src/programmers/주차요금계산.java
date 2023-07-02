package programmers;

import java.util.*;

/**
 * 프로그래머스 - 주차 요금 계산
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 */
public class 주차요금계산 {

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();

        for(String r : records) {
            String[] temp = r.split(" ");

            if(inTime.containsKey(temp[1])) {

            }

            if(temp[2].equals("IN")) {
                inTime.put(temp[1], hourToMin(temp[0]));
            } else if(temp[2].equals("OUT")) {

                if(totalTime.containsKey(temp[1])) {
                    totalTime.put(temp[1],
                            totalTime.get(temp[1]) +
                                    hourToMin(temp[0]) - inTime.get(temp[1]));
                } else {
                    totalTime.put(temp[1], hourToMin(temp[0]) - inTime.get(temp[1]));
                }

                inTime.remove(temp[1]);
            }
        }

        for(String s: inTime.keySet()) {
            if(totalTime.containsKey(s)) {
                totalTime.put(s,
                        totalTime.get(s) +
                                hourToMin("23:59") - inTime.get(s));
            } else {
                totalTime.put(s, hourToMin("23:59") - inTime.get(s));
            }
        }

        List<String> keyList = new ArrayList<>();

        for(String s : totalTime.keySet())
            keyList.add(s);

        Collections.sort(keyList);

        for(String s : keyList)
            answer.add(totalFees(fees, totalTime.get(s)));

        System.out.println(answer);

    }

    public static int hourToMin(String t) {
        String[] time = t.split(":");

        int h = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);

        return (h * 60 + min);
    }

    public static int totalFees(int[] fees, int totalTime) {
        if(totalTime <= fees[0])
            return fees[1];

        return fees[1] + (int) Math.ceil((double) (totalTime - fees[0]) / fees[2]) * fees[3];
    }
}
