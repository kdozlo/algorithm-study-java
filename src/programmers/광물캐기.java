package programmers;

import java.util.*;

/**
 * 프로그래머스 - 광물 캐기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927
 */
public class 광물캐기 {

    public static void main(String[] args) {
        int answer = 0;
        int[] picks = {1, 1, 0};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone","iron", "iron", "diamond","diamond"};
        //답 : 14

        List<HashMap<String, Integer>> group = new ArrayList<>();
        HashMap<String, Integer> temp = new HashMap<>();
        temp.put("diamond", 0);
        temp.put("iron", 0);
        temp.put("stone", 0);

        int picksSum = Arrays.stream(picks).sum() * 5;

        int iterSize = 0;

        if (picksSum > minerals.length)
            iterSize = minerals.length;
        else {
            iterSize = picksSum;
        }

        //mineral 5개씩 묶기
        for(int i = 0; i < iterSize; i++) {
            temp.put(minerals[i], temp.get(minerals[i]) + 1);
            if ((i + 1) % 5 == 0) {
                group.add(temp);
                temp = new HashMap<String, Integer>();
                temp.put("diamond", 0);
                temp.put("iron", 0);
                temp.put("stone", 0);
            }
            if (i == minerals.length - 1) {
                group.add(temp);
            }
        }

        // diamond, iron, stone 갯수 많은 순으로 정렬
        Collections.sort(group, (o1, o2) ->{
            if(o2.get("diamond")!= o1.get("diamond")) {
                return o2.get("diamond") - o1.get("diamond");
            } else {
                if(o2.get("iron") != o1.get("iron")) {
                    return o2.get("iron") - o1.get("iron");
                } else {
                    return o2.get("stone") - o1.get("stone");
                }
            }
        });

        int curIndex = 0;
        for(int i = 0; i < picks.length; i++) {
            while (picks[i] > 0) {
                if (curIndex == group.size())
                    break;

                if (i == 0) {
                    //diamond 곡괭이
                    answer += group.get(curIndex).get("diamond")
                            + group.get(curIndex).get("iron")
                            + group.get(curIndex).get("stone");
                } else if (i == 1) {
                    //iron 곡괭이
                    answer += group.get(curIndex).get("diamond") * 5
                            + group.get(curIndex).get("iron")
                            + group.get(curIndex).get("stone");
                } else {
                    //stone 곡괭이
                    answer += group.get(curIndex).get("diamond") * 25
                            + group.get(curIndex).get("iron") * 5
                            + group.get(curIndex).get("stone");
                }
                picks[i]--;
                curIndex++;
            }
            if (curIndex == group.size())
                break;
        }

        System.out.println(answer);
    }
}
