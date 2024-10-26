 import java.io.*;
 import java.util.ArrayList;

 public class Main {

     static int N, max;

     static Node[] nodes;

     static int[] visited;

     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

     static class Node{
         int num;
         ArrayList<Node> child = new ArrayList<>();

         public Node(int n){
             this.num = n;
         }
     }


     public static void main(String[] args) throws IOException {

         String[] s = br.readLine().split(" ");
         N = Integer.parseInt(s[0]);
         nodes = new Node[N+1];
         visited = new int[N+1];

         for (int i = 0; i < N+1; i++) {
            nodes[i] = new Node(i);
         }
         for (int i = 0; i < N-1; i++) {
             s = br.readLine().split(" ");
             int a = Integer.parseInt(s[0]);
             int b = Integer.parseInt(s[1]);
             nodes[a].child.add(nodes[b]);
             nodes[b].child.add(nodes[a]);
         }

         ArrayList<Node> next = new ArrayList<>();
         ArrayList<Node> temp = new ArrayList<>();
         visited[1] = 1;
         next.add(nodes[1]);
         while (next.size() > 0){
             for (Node node : next) {
                 for (Node child : node.child) {
                     if (visited[child.num] == 0){
                         visited[child.num] = node.num;
                         temp.add(child);
                     }
                 }
             }
             next.clear();
             next.addAll(temp);
             temp.clear();
         }

         for (int i = 2; i < N+1; i++) {
            bw.write(String.valueOf(visited[i])+"\n");
         }
         bw.flush();

     }
 }