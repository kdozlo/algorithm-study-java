package boj;

import java.io.*;
import java.util.*;

/**
 * 백준 20920
 * 영단어 암기는 괴로워
 *  실버 3
 * https://www.acmicpc.net/problem/20920
 */
public class b20920 {

    private static class Word implements Comparable<Word> {
        String s;
        int cnt;

        Word(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word w) {
            if(cnt == w.cnt && s.length() == w.s.length())
                return s.compareTo(w.s);

            if(cnt == w.cnt)
                return Integer.compare(w.s.length(), s.length());

            return Integer.compare(w.cnt, cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> m = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            if(s.length() < M)
                continue;

            if(m.containsKey(s))
                m.put(s, m.get(s) + 1);
            else
                m.put(s, 1);
        }

        PriorityQueue<Word> pq = new PriorityQueue<>();
        for(String key : m.keySet()) {
            pq.add(new Word(key, m.get(key)));
        }

        while(!pq.isEmpty()) {
            sb.append(pq.poll().s).append("\n");
        }

        System.out.print(sb);
    }
}
