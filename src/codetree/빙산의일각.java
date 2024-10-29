package codetree;

import java.io.*;
import java.util.*;

/**
* 코드트리
* 빙산의 일각
* 실버1
* https://www.codetree.ai/training-field/search/problems/the-tip-of-the-iceberg?&utm_source=clipboard&utm_medium=text
*/
public class 빙산의일각 {
    private static class Node implements Comparable<Node> {
        int index;
        long h;

        Node(int index, long h) {
            this.index = index;
            this.h = h;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(o.h, h);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] heights = new long[N + 2];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            heights[i] = Long.parseLong(br.readLine());
            pq.add(new Node(i, heights[i]));
        }

        boolean[] visited = new boolean[N + 2];
        long answer = 0;
        long cnt = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(!visited[cur.index - 1] && !visited[cur.index + 1]) {
                cnt++;
            } else if(visited[cur.index - 1] && visited[cur.index + 1]) {
                cnt--;
            }

            visited[cur.index] = true;

            if(pq.isEmpty() || pq.peek().h != cur.h){
                answer = Math.max(answer, cnt);
            }
        }

        System.out.println(answer);

    }
}
