package boj.legacy;

import java.io.*;
import java.util.*;

/**
 * 백준 1939
 * 중량제한
 * 골드3
 * https://www.acmicpc.net/problem/1939
 */
public class Boj1939 {

    private static class Bridge {
        int d;
        int w;

        Bridge(int d, int w) {
            this.d = d;
            this.w = w;
        }
    }

    private static int N; // 섬 개수
    private static int M; // 다리 개수
    private static List<Bridge>[] bridges; // 다리의 최대 중량
    private static int f1; // 공장1
    private static int f2; // 공장2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bridges = new List[N + 1];
        for(int i = 1; i <= N; i++)
            bridges[i] = new ArrayList<>();
        int max = 1;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            bridges[A].add(new Bridge(B, C));
            bridges[B].add(new Bridge(A, C));

            max = Math.max(max, C);
        }

        st = new StringTokenizer(br.readLine());
        f1 = Integer.parseInt(st.nextToken());
        f2 = Integer.parseInt(st.nextToken());

        int start = 1;
        int end = max;
        int result = 1;
        while(start <= end) {
            int mid = (start + end) >>> 1;

            if(bfs(mid)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }

    public static boolean bfs(int target) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        queue.add(f1);
        visited[f1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == f2) {
                return true; // f1에서 f2로 이동 가능
            }

            for (Bridge bridge : bridges[current]) {
                if (!visited[bridge.d] && bridge.w >= target) {
                    visited[bridge.d] = true;
                    queue.add(bridge.d);
                }
            }
        }

        return false; // target로는 이동 불가
    }
}
