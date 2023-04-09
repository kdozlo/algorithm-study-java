import java.util.Arrays;

public class Practice {

    public static void main(String[] args) {

        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};

        String[] answer = new String[plans.length];

        int cur = 0;
        while (true) {
            //시작 시간순 정렬
            Arrays.sort(plans, (a1, a2) ->{
                if (Integer.parseInt(a1[1].substring(0, 2)) == Integer.parseInt(a2[1].substring(0, 2))) {
                    return (Integer.parseInt(a1[1].substring(3, 5)) - Integer.parseInt(a2[1].substring(3, 5)));
                }
                return Integer.parseInt(a1[1].substring(0, 2)) - Integer.parseInt(a2[1].substring(0, 2));
            });

            System.out.println(Arrays.deepToString(plans));

            // 시간 업데이트
            for(int i = 0; i < plans.length - 1; i++) {
                String[] nextPlan = new String[3];

                //시작 시간 차이
                int difMin = 0;

                //비교 다음 플랜 정하기
                for(int j = i + 1; j < plans.length; j++) {
                    if (plans[j][2] == "0") continue;

                    nextPlan[0] = plans[j][0];
                    nextPlan[1] = plans[j][1];
                    nextPlan[2] = plans[j][2];

                    difMin = (Integer.parseInt(nextPlan[1].substring(0, 2)) - Integer.parseInt(plans[i][1].substring(0, 2))) * 60
                            + Integer.parseInt(nextPlan[1].substring(3, 5)) - Integer.parseInt(plans[i][1].substring(3, 5));

                    if (difMin == 0 && j != plans.length - 1) {
                        continue;
                    } else if (difMin == 0 && (j == plans.length - 1)) {
                        if (plans[i][2] != "0") {
                            plans[i][2] = "0";
                            answer[cur] = plans[i][0];
                            cur++;
                        }
                    }

                    break;
                }

                System.out.println("i : " + i + " difMin : " + difMin);

               if (Integer.parseInt(plans[i][2]) > difMin) {
                    int tempH = Integer.parseInt(plans[i][1].substring(0, 2)) + (int) (difMin / 60);
                    int tempM = Integer.parseInt(plans[i][1].substring(3,5)) + (difMin % 60);

                    if(tempM >= 60) {
                        tempH += (int) (tempM / 60);
                        tempM = tempM  % 60;
                    }

                    String completeH = "" + tempH;
                    String completeM = "" + tempM;
                    if(tempM < 10) {
                        completeM = "0" + tempM;
                    }

                    plans[i][1] = completeH + ":" + completeM;
                    plans[i][2] = "" + (Integer.parseInt(plans[i][2]) - difMin);
                } else {
                    if (plans[i][2] != "0") {
                        plans[i][2] = "0";
                        answer[cur] = plans[i][0];
                        cur++;
                    }
                }
            }

            System.out.println(Arrays.deepToString(plans));
            System.out.println(Arrays.toString(answer));

            //종료 조건 확인
            if (cur == plans.length - 1) {
                answer[cur] = plans[cur][0];
                break;
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}