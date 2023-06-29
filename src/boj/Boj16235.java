package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 16235
 * 나무 재테크
 * 골드3
 * https://www.acmicpc.net/problem/16235
 * 이 코드가 다른 코드보다 시간이 오래 걸리는 이유
 * 죽은 나무를 다루는 부분이 따로 없어서 죽은 나무가 자꾸 누적되어서  시간도 더 걸리고 용량도 더 많이 먹게 된다.
 * 이런 면에서 동적 할당이 정말 좋은게 용량을 쓰고 free 하면 되니까 결국 시간도 아끼도 용량도 아끼는 셈이 되네.
 */
public class Boj16235 {

    static class Tree {
        int x;
        int y;
        int age;

        boolean life;

        public Tree(int x, int y, int age, boolean life) {
            this.x = x;
            this.y = y;
            this.age = age;
            this.life = life;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //n 땅 크기, m 나무 개수, k 년
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //현재  양분
        int[][] curA = new int[n][n];

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                curA[i][j] = 5;
        }

        // 추가되는 양분 양
        int[][] a = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 위치 x, 위치 y, age
        List<Tree> trees = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            trees.add(new Tree(Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()), true));
        }

        Collections.sort(trees, (t1, t2) -> t1.age - t2.age);

        for(int year = 0; year < k; year++) {

            //봄
            for(Tree t : trees) {
                //죽은 나무
                if(!t.life)
                    continue;

                if(curA[t.x][t.y] < t.age) {
                    //양분 부족시 나무 죽음
                    t.life = false;
                } else {
                    curA[t.x][t.y] -= t.age;
                    t.age += 1;
                }
            }

            //여름
            for(Tree t : trees) {
                if(!t.life)
                    curA[t.x][t.y] += t.age / 2;
            }

            List<Tree> temp = new ArrayList<>();

            //가을
            for(Tree t : trees) {

                //죽은 나무
                if(!t.life)
                    continue;

                if(t.age % 5 == 0) {
                    if(t.x - 1 >= 0 && t.y - 1 >= 0)
                        temp.add(new Tree(t.x - 1, t.y - 1, 1, true));

                    if(t.x - 1 >= 0)
                        temp.add(new Tree(t.x - 1, t.y, 1, true));

                    if(t.x - 1 >=0 && t.y + 1 < n)
                        temp.add(new Tree(t.x - 1, t.y + 1, 1, true));

                    if(t.y - 1 >= 0)
                        temp.add(new Tree(t.x, t.y - 1, 1, true));

                    if(t.y + 1 < n)
                        temp.add(new Tree(t.x, t.y + 1, 1, true));

                    if(t.x + 1 < n && t.y - 1 >= 0)
                        temp.add(new Tree(t.x + 1, t.y - 1, 1, true));

                    if(t.x + 1< n)
                        temp.add(new Tree(t.x + 1, t.y, 1, true));

                    if(t.x + 1< n && t.y + 1< n)
                        temp.add(new Tree(t.x + 1, t.y + 1, 1, true));
                }
            }

            for(Tree t : trees) {
                if(t.life)
                    temp.add(t);
            }

            trees = temp;

            //겨울
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    curA[i][j] += a[i][j];
                }
            }
        }

        int answer = 0;

        for(Tree t : trees) {
            if(t.life)
                answer++;
        }

        System.out.println(answer);

    }
}
