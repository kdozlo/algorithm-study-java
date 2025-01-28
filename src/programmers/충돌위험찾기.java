package programmers;

import java.util.*;

/**
* 프로그래머스 340211
* [PCCP 기출문제] 3번 / 충돌위험 찾기
* lv2
* https://school.programmers.co.kr/learn/courses/30/lessons/340211
*/
public class 충돌위험찾기 {

    private static class Route {
        int r;
        int c;
        int time;

        Route(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    private static Map<String, Integer> count;
    private static int time;

    public static void main(String[] args) {
        int[][] points = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes = {{4, 2}, {1, 3}, {2, 4}};

        count = new HashMap<>();

        for(int i = 0; i < routes.length; i++) {
            time = 0;
            int first = routes[i][0] - 1;
            StringBuilder sb = new StringBuilder();
            sb.append(points[first][0]).append(",").append(points[first][1]).append(",").append(time++);
            count.put(sb.toString(), count.getOrDefault(sb.toString(), 0) + 1);

            for(int j = 1; j < routes[0].length; j++) {
                int s = routes[i][j - 1] - 1;
                int e = routes[i][j] - 1;
                List<Route> l = findRoute(points[s][0], points[s][1],
                        points[e][0], points[e][1]);

                counting(l);
            }
        }

        int answer = 0;
        for(String s : count.keySet()) {
            if(count.get(s) > 1)
                answer++;
        }

        System.out.println(answer); // 1
    }

    public static List<Route> findRoute(int sr, int sc, int er, int ec) {
        List<Route> routes = new ArrayList<>();

        if(sr < er) {
            while(sr != er) {
                sr++;
                routes.add(new Route(sr, sc, time++));
            }
        } else if(sr > er) {
            while(sr != er) {
                sr--;
                routes.add(new Route(sr, sc, time++));
            }
        }

        if(sc < ec) {
            while(sc != ec) {
                sc++;
                routes.add(new Route(sr, sc, time++));
            }
        } else if(sc > ec) {
            while(sc != ec) {
                sc--;
                routes.add(new Route(sr, sc, time++));
            }
        }


        return routes;
    }

    public static void counting(List<Route> routes) {
        for(Route r : routes) {
            StringBuilder sb = new StringBuilder();
            sb.append(r.r).append(",").append(r.c).append(",").append(r.time);
            count.put(sb.toString(), count.getOrDefault(sb.toString(), 0) + 1);
        }
    }
}
