package programmers;

import java.util.*;

/**
 * 프로그래머스 - 신고 결과 받기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 */
public class 신고결과받기 {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] answer = new int[id_list.length];

        Arrays.fill(answer, 0);

        //report 중복 제거
        Set<String> tempReport = new HashSet<>();
        for(int i = 0; i < report.length; i++) {
            tempReport.add(report[i]);
        }

        Iterator<String> iter = tempReport.iterator();

        //총 신고된 횟수
        Map<String, Integer> stopCount = new HashMap<>();
        while(iter.hasNext()) {
            String[] temp = iter.next().split(" ");

            if(stopCount.containsKey(temp[1]))
                stopCount.put(temp[1], stopCount.get(temp[1]) + 1);
            else
                stopCount.put(temp[1], 1);
        }

        //정지된 id
        List<String> stopId = new ArrayList<>();
        for(String s : id_list) {
            if(stopCount.containsKey(s) && stopCount.get(s) >= k) {
                stopId.add(s);
            }
        }

        //유저id, 유저가 신고한 id
        Map<String, List<String>> stopIdList = new HashMap<>();
        for(String s : id_list) {
            List<String> temp = new ArrayList<>();
            stopIdList.put(s, temp);
        }

        iter = tempReport.iterator();
        while(iter.hasNext()) {
            String[] temp = iter.next().split(" ");
            stopIdList.get(temp[0]).add(temp[1]);
        }

        //처리 결과 메일 받은 횟수
        for(int i = 0; i < id_list.length; i++) {
            for(String s : stopIdList.get(id_list[i])) {
                if (stopId.contains(s))
                    answer[i] += 1;
            }
        }

        //result : [2, 1, 1, 0]
        System.out.println(Arrays.toString(answer));
    }
}
