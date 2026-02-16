package boj.legacy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 백준 2961
 * 도영이가 만든 맛있는 음식
 * 실버 2
 * https://www.acmicpc.net/problem/2961
 */
public class Boj2961 {

    static int minTaste;
    static boolean[] selected;
    static int n;
    static Ingredient[] ingredients;

    static class Ingredient {
        int s;
        int b;

        Ingredient(int s, int b) {
            this.s = s;
            this.b = b;
        }

        public int getS() {
            return this.s;
        }

        public int getB() {
            return this.b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        selected = new boolean[n];
        minTaste = Integer.MAX_VALUE;
        ingredients = new Ingredient[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ingredients[i] = new Ingredient(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        subSet(0);

        System.out.println(minTaste);
    }

    public static void subSet(int cnt) {
        int mulS = 1;
        int sumB = 0;

        if(cnt == n) {
            for(int i = 0; i < n; i++) {
                if(selected[i]) {
                    mulS *= ingredients[i].getS();
                    sumB += ingredients[i].getB();
                }
            }

            if(mulS != 1 && sumB != 0)
                minTaste = Math.min(minTaste, Math.abs(mulS - sumB));
            return;
        }

        selected[cnt] = true;
        subSet(cnt+1);
        selected[cnt] = false;
        subSet(cnt+1);
    }
}
