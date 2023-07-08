package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * 프로그래머스 - 방문 길이
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/49994
 */
public class 방문길이 {

    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        Set<String> set = new HashSet<>();


        int curX = 0;
        int curY = 0;
        for(char c : dirs.toCharArray())
        {
            String path = "";
            int nextX = curX;
            int nextY = curY;

            switch(c) {
                case 'U' :
                    nextY += 1;
                    path += curX;
                    path += curY;
                    path += nextX;
                    path += nextY;
                    break;
                case 'D' :
                    nextY -= 1;
                    path += nextX;
                    path += nextY;
                    path += curX;
                    path += curY;
                    break;
                case 'R' :
                    nextX += 1;
                    path += curX;
                    path += curY;
                    path += nextX;
                    path += nextY;
                    break;
                case 'L':
                    nextX -= 1;
                    path += nextX;
                    path += nextY;
                    path += curX;
                    path += curY;
                    break;
            }

            if(nextX > 5 || nextX < -5 || nextY > 5 || nextY < -5)
                continue;

            set.add(path);
            curX = nextX;
            curY = nextY;
        }
    }
}
