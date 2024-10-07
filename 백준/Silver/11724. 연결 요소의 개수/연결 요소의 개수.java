import java.lang.reflect.Array;
import java.util.*;

class Node{

    public int num;
    public ArrayList<Node> con = new ArrayList<Node>();

    public Node(int num){
        this.num = num;
    }

    public void append(Node node){
        con.add(node);
    }

}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();
    static int M = sc.nextInt();

    static ArrayList<Node> nodes = new ArrayList<Node>();

    static int[] visit = new int[N+1];

    static int count = N;

    static void dfs(Node node){

        if (visit[node.num] == 1){
            return;
        }


        visit[node.num] = 1;
        count = count - 1;
        if (node.con.isEmpty()){
            return;
        }
        for (Node dest : node.con){
            dfs(dest);
        }
    }

    public static void main(String[] args) {
        visit[0] = 1;
        for (int i = 0; i < N+1; i++){
            nodes.add(new Node(i));
        }

        for (int i = 0; i < M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            nodes.get(start).append(nodes.get(end));
            nodes.get(end).append(nodes.get(start));
        }
        int result = -1;
        boolean trigger = false;
        while (!trigger){
            int start = -1;
            for (int i = 0; i < visit.length; i++){
                if (visit[i] == 0){
                    start = i;
                    break;
                }
            }


            if (start == -1){
                trigger = true;
            }
            else{
                dfs(nodes.get(start));
            }
            result = result + 1;
        }

        System.out.println(result);



    }
}