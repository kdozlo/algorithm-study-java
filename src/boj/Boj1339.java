package boj;

import java.io.*;
import java.util.*;

/**
* 백준 1339
* 단어 수학
* 골드4
* https://www.acmicpc.net/problem/1339
*/
public class Boj1339 {

    private static int N; // 단어 수
    private static char[][] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        words = new char[N][8];

        for(int i = 0; i < N; i++) {
            words[i] = br.readLine().toCharArray();
        }

        Map<Character, Integer> cost = new HashMap<>();
        for(int i = 0; i < N; i++) {
            int d = 1;
            for(int j = words[i].length - 1; j >= 0; j--) {
                cost.put(words[i][j], cost.getOrDefault(words[i][j], 0) + d);
                d *= 10;
            }
        }

        List<Map.Entry<Character, Integer>> l = new ArrayList<>(cost.entrySet());
        l.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        Map<Character, Integer> charToInt = new HashMap<>();
        Integer cur = 9;
        for(Map.Entry<Character, Integer> e : l) {
            charToInt.put(e.getKey(), cur--);
        }

        int sum = 0;
        for(Map.Entry<Character, Integer> e : cost.entrySet()) {
            sum += e.getValue() * charToInt.get(e.getKey());
        }

        System.out.println(sum);
    }
}
