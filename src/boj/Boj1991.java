package boj;

import java.io.*;
import java.util.*;

/**
* 백준 1991
* 트리 순회
* 실버1
* https://www.acmicpc.net/problem/1991
*/
public class Boj1991 {

    private static class Node {
        char key;
        Node left, right;

        public Node(char key) {
            this.key = key;
            this.left = this.right = null;
        }

        // key에 해당하는 노드를 찾아서 left와 right 자식을 연결
        public void insert(char key, char left, char right) {
            if(this.key == key) {
                if (left != '.') {
                    this.left = new Node(left);
                }
                if (right != '.') {
                    this.right = new Node(right);
                }
            } else {
                if(this.left != null) {
                    this.left.insert(key, left, right);
                }
                if(this.right != null) {
                    this.right.insert(key, left, right);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드의 개수

        // 트리 생성
        Node root = new Node('A'); // 항상 루트는 'A'
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char key = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            root.insert(key, left, right);
        }

        // 전위 순회
        preOrder(root);
        System.out.println();

        // 중위 순회
        inOrder(root);
        System.out.println();

        // 후위 순회
        postOrder(root);
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key);  // 현재 노드 출력
        preOrder(root.left);         // 왼쪽 자식 방문
        preOrder(root.right);        // 오른쪽 자식 방문
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);          // 왼쪽 자식 방문
        System.out.print(root.key);  // 현재 노드 출력
        inOrder(root.right);         // 오른쪽 자식 방문
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);        // 왼쪽 자식 방문
        postOrder(root.right);       // 오른쪽 자식 방문
        System.out.print(root.key);  // 현재 노드 출력
    }
}
