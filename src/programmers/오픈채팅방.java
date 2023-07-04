package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 프로그래머스 - 오픈채팅방
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/42888
 */
public class 오픈채팅방 {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        List<String> answer = new ArrayList<>();
        Map<String, String> nickname = new HashMap<>();

        for(String s : record) {
            String[] temp = s.split(" ");

            switch(temp[0]) {
                case "Enter" :
                    answer.add(temp[1] + "님이 들어왔습니다.");
                    nickname.put(temp[1], temp[2]);
                    break;
                case "Leave" :
                    answer.add(temp[1] + "님이 나갔습니다.");
                    break;
                case "Change" :
                    nickname.put(temp[1], temp[2]);
                    break;

            }
        }

        /*여기서 문장에 userId를 확인하기 위해 contains를 사용하면 안된다
        이유는 예를 들어서 userId가 u1, u123 이 있는 경우 u123에도 u1이 포함되어 있기 때문에
        문제가 된다.*/
        for(int i = 0; i < answer.size(); i++) {
            int endOfId = answer.get(i).indexOf("님");
            String userId = answer.get(i).substring(0, endOfId);

            answer.set(i, answer.get(i).replace(userId, nickname.get(userId)));
        }

        System.out.println(answer);
    }
}
