package boj;

import java.io.*;
import java.util.*;

/**
 * 백준 23350
 * K 물류창고
 * 실버1
 * https://www.acmicpc.net/problem/23350
 */
public class Boj23350 {

    private static class Container {
        int p;
        int w;

        Container(int p, int w) {
            this.p = p;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //컨테이너 개수
        int M = Integer.parseInt(st.nextToken()); //우선순위 종류

        Queue<Container> q = new LinkedList<>();
        int[] pCnt = new int[M + 1];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken()); //우선순위 종류
            int W = Integer.parseInt(st.nextToken()); //무게

            Container c = new Container(P, W);
            q.add(c);
            pCnt[c.p]++;
        }

        int answer = 0;
        Stack<Container> curQ = new Stack<>();
        int pIndex = M;
        while(!q.isEmpty()) {
            Container cur = q.poll();

            //최고 우선순위를 다 적재한 경우
            while(pCnt[pIndex] == 0) {
                pIndex--;
                curQ = new Stack<>();
            }

            //최고 우선순위 다 적재하지 않은 경우 && 현재 컨테이너가 최고 우선순위가 아닌경우
            if(cur.p < pIndex) {

                answer += cur.w;
                q.add(cur);

                continue;
            }

            // 현재 컨테이너가 최고 우선순위인 경우
            if(cur.p == pIndex) {
                Stack<Container> s = new Stack<>();

                while(!curQ.isEmpty() && curQ.peek().w < cur.w) {

                    Container temp = curQ.pop();
                    answer += temp.w;
                    s.add(temp);

                }

                answer += cur.w;
                curQ.add(cur);
                pCnt[pIndex]--;

                while(!s.isEmpty()) {
                    Container temp = s.pop();
                    answer += temp.w;
                    curQ.add(temp);
                }
            }
        }

        System.out.println(answer);
    }
}