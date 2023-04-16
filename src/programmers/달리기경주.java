package programmers;


import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/**
 * 프로그래머스 - 달리기 경주
 * Lv 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 */
public class 달리기경주 {

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        Map<String, Integer> curRank = new HashMap<>();

        for(int i = 0; i < players.length; i++) {
            curRank.put(players[i], i);
        }



        for(String cur : callings) {
            Integer tempRank = curRank.get(cur);

            players[tempRank] = players[tempRank - 1];
            curRank.put(players[tempRank - 1], tempRank);

            players[tempRank - 1] = cur;
            curRank.put(cur, tempRank - 1);
        }

        System.out.println(Arrays.toString(players));

    }

    /*//시간 초과
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        for(String cur : callings) {
            for(int i = 0; i < players.length; i++) {
                if(players[i].equals(cur)) {
                    players[i] = players[i - 1];
                    players[i-1] = cur;
                }
            }
        }

        System.out.println(Arrays.toString(players));
    }*/

}
