package 알고리즘분류.재귀;

import java.io.*;
import java.util.StringTokenizer;

public class 트리순회 {

    private static final Node headNode = new Node('A', null, null);

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            char rootNode = stringTokenizer.nextToken().charAt(0);
            char leftNode = stringTokenizer.nextToken().charAt(0);
            char rightNode = stringTokenizer.nextToken().charAt(0);

            insertNode(headNode, rootNode, leftNode, rightNode);
        }

        StringBuilder preorderBuilder = new StringBuilder();
        StringBuilder inorderBuilder = new StringBuilder();
        StringBuilder postorderBuilder = new StringBuilder();

        preorderTraversal(headNode, preorderBuilder);
        inorderTraversal(headNode, inorderBuilder);
        postorderTraversal(headNode, postorderBuilder);

        bufferedWriter.write(preorderBuilder + "\n" + inorderBuilder + "\n" + postorderBuilder);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static class Node {
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private static void insertNode(Node node, char rootNode, char leftNode, char rightNode) {
        if (node.value == rootNode) {
            node.left = (leftNode == '.' ? null : new Node(leftNode, null, null));
            node.right = (rightNode == '.' ? null : new Node(rightNode, null, null));
        } else {
            if (node.left != null) insertNode(node.left, rootNode, leftNode, rightNode);
            if (node.right != null) insertNode(node.right, rootNode, leftNode, rightNode);
        }
    }

    private static void preorderTraversal(Node node, StringBuilder preorderBuilder) {
        if (node == null) return;
        preorderBuilder.append(node.value);
        preorderTraversal(node.left, preorderBuilder);
        preorderTraversal(node.right, preorderBuilder);
    }

    private static void inorderTraversal(Node node, StringBuilder inorderBuilder) {
        if (node == null) return;
        inorderTraversal(node.left, inorderBuilder);
        inorderBuilder.append(node.value);
        inorderTraversal(node.right, inorderBuilder);
    }

    private static void postorderTraversal(Node node, StringBuilder postorderBuilder) {
        if (node == null) return;
        postorderTraversal(node.left, postorderBuilder);
        postorderTraversal(node.right, postorderBuilder);
        postorderBuilder.append(node.value);
    }
}
