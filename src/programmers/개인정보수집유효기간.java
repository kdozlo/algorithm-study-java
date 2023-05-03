package programmers;


import java.util.*;

/**
 * 프로그래머스 - 개인정보 수집 유효기간
 * Lv 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/150370
 */
public class 개인정보수집유효기간 {

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        StringTokenizer st = new StringTokenizer(today, ".");

        int todaySum = 0;

        todaySum += Integer.parseInt(st.nextToken()) * 12 * 28 +
                Integer.parseInt(st.nextToken()) * 28 +
                Integer.parseInt(st.nextToken());

        Map<String, Integer> termsMap = new HashMap<>();

        for(int i = 0; i < terms.length; i++) {
            st = new StringTokenizer(terms[i], " ");
            termsMap.put(st.nextToken(), Integer.parseInt(st.nextToken()) * 28);
        }

        List<Integer> answerList = new ArrayList<>();

        for(int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i], ".| ");
            int curSum = 0;
            curSum += Integer.parseInt(st.nextToken()) * 12 * 28 +
                    Integer.parseInt(st.nextToken()) * 28 +
                    Integer.parseInt(st.nextToken()) +
                    termsMap.get(st.nextToken());

            if (todaySum >= curSum) {
                answerList.add(i + 1);
            }
        }

        int[] answer = answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        //result : 1, 3
        System.out.println(Arrays.toString(answer));
    }
}
