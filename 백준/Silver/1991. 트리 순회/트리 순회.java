import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int N;
    static String output1 = "";
    static String output2 = "";
    static String output3 = "";


    static Map <String, Node> nodes = new HashMap<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Node{
        String name;
        Node left;
        Node right;

        public Node(String name) {
            this.name = name;
        }
    }

    public static void solution1(Node node){
        output1 = output1 + node.name;
        if (node.left != null)
            solution1(node.left);
        if (node.right != null)
            solution1(node.right);
    }

    public static void solution2(Node node){

        if (node.left == null && node.right == null){
            output2 = output2 + node.name;
            return;
        }
        if (node.left != null)
            solution2(node.left);
        output2 = output2 + node.name;
        if (node.right != null)
            solution2(node.right);

    }

    public static void solution3(Node node){

        if (node.left == null && node.right == null){
            output3 = output3 + node.name;
            return;
        }
        if (node.left != null)
            solution3(node.left);

        if (node.right != null)
            solution3(node.right);

        output3 = output3 + node.name;

    }


    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);

        int seq = 65;
        for (int i = 0; i < N; i++) {
            nodes.put(Character.toString(seq), new Node(Character.toString(seq)));
            seq++;
        }
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            String left = s[1];
            String right = s[2];
            if (left != ".")
                nodes.get(s[0]).left = nodes.get(left);
            if (right != ".")
                nodes.get(s[0]).right = nodes.get(right);
        }

        solution1(nodes.get("A"));
        solution2(nodes.get("A"));
        solution3(nodes.get("A"));

        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);

    }
}