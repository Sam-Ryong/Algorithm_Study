import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] count;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int R = sc.nextInt();
        int Q = sc.nextInt();

        count = new int[N+1];
        Node[] nodes = new Node[N+1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node();
            nodes[i].num = i;
        }

        for (int i = 0; i < N-1; i++) {
            int U = sc.nextInt();
            int V = sc.nextInt();

            nodes[U].child.add(nodes[V]);
            nodes[V].child.add(nodes[U]);
        }

        dfs(nodes[R], null);

        for (int i = 0; i < Q; i++) {
            int U = sc.nextInt();
            System.out.println(count[U]);
        }
    }

    // DFS로 서브트리 크기 계산
    public static void dfs(Node root, Node parent){
        count[root.num] = 1; // 자기 자신
        for (Node child : root.child){
            if (child != parent){
                dfs(child, root);
                count[root.num] += count[child.num]; // 자식 서브트리 합산
            }
        }
    }

}

class Node{
    int num;
    List<Node> child = new ArrayList<>();
}
