import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static ArrayList<Integer> DFSvisited = new ArrayList<Integer>();
    static ArrayList<Integer> BFSvisited = new ArrayList<Integer>();
    public static class Node{

        public int num;
        public ArrayList<Node> edges;

        public boolean visited = false;

        public Node(int i){
            this.num = i;
            this.edges = new ArrayList<Node>();
        }

        public void append(Node node){
            int where = edges.size();

            for (int i = 0; i < edges.size(); i++){
                if (edges.get(i).num > node.num){
                    where = i;
                    break;
                }
            }
            edges.add(where,node);
        }

    }

    public static void dfs(Node node){

        if (node.visited){
            return;
        }
        else {
            node.visited = true;
            DFSvisited.add(node.num);
            for (Node edge : node.edges) {
                dfs(edge);
            }
        }

    }

    public static void bfs(ArrayList<Node> nodes){

        if (nodes.isEmpty()){
            return;
        }
        ArrayList<Node> temp = new ArrayList<Node>();
        for (Node node : nodes){
            if (!(node.visited)){
                node.visited = true;
                BFSvisited.add(node.num);
                temp.addAll(node.edges);
            }
        }
        bfs(temp);




    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        ArrayList<Node> nodes = new ArrayList<Node>();
        for (int i = 0; i < N + 1; i++){
            nodes.add(new Node(i));
        }

        for (int i = 0; i < M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            nodes.get(start).append(nodes.get(end));
            nodes.get(end).append(nodes.get(start));
        }

        dfs(nodes.get(V));
        for (Node node : nodes){
            node.visited = false;
        }
        nodes.get(V).visited = true;
        BFSvisited.add(nodes.get(V).num);
        bfs(nodes.get(V).edges);
        for (int i = 0; i < DFSvisited.size(); i++){
            System.out.print(DFSvisited.get(i));
            if (i != DFSvisited.size() - 1)
                System.out.print(" ");
            else
                System.out.println();
        }
        for (int i = 0; i < BFSvisited.size(); i++){
            System.out.print(BFSvisited.get(i));
            if (i != BFSvisited.size() - 1)
                System.out.print(" ");
            else {
                System.out.println();
            }
        }

    }
}