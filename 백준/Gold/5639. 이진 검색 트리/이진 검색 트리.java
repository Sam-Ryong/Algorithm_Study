import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N, M;

    static boolean[] human;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Node{
        int val;
        Node parent;
        Node left;
        Node right;
    }

    public static void search(Node node) throws IOException {
        if (node.left == null && node.right == null) {
            bw.write(node.val + "\n");
            return;
        }
        if (node.left != null)
            search(node.left);
        if (node.right != null)
            search(node.right);
        bw.write(node.val + "\n");
    }


    public static void main(String[] args) throws IOException {
        String s;
        ArrayList<Node> nodes = new ArrayList<>();
        s = br.readLine();
        Node inputNode = new Node();
        inputNode.val = Integer.parseInt(s);
        nodes.add(inputNode);
        while (true){
            s = br.readLine();
            if (s == null || s.equals(""))
                break;
            inputNode = new Node();
            inputNode.val = Integer.parseInt(s);
            nodes.add(inputNode);
            Node compareNode = nodes.get(0);
            while (true){
                if (compareNode.val > inputNode.val){
                    if (compareNode.left != null){
                        compareNode = compareNode.left;
                    }
                    else{
                        compareNode.left = inputNode;
                        break;
                    }
                }
                else{
                    if (compareNode.right != null){
                        compareNode = compareNode.right;
                    }
                    else{
                        compareNode.right = inputNode;
                        break;
                    }
                }
            }

        }
        search(nodes.get(0));

        bw.flush();

    }
}