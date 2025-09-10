import java.util.*;

class Solution {
    List<Integer> answer1 = new ArrayList<>();
    List<Integer> answer2 = new ArrayList<>();
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {new int[nodeinfo.length], new int[nodeinfo.length]};
        
        
        Map<Integer, List<Node>> nodes = new HashMap<>();
        Node root = null;
        for (int i = 0; i < nodeinfo.length; i++){
            
            if (nodes.get(nodeinfo[i][1]) == null)
                nodes.put(nodeinfo[i][1], new ArrayList<Node>());
            Node node = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
            nodes.get(nodeinfo[i][1]).add(node);
            if (root == null || root.y < nodeinfo[i][1]){
                root = node;
            }
            
        }
        
        int level = root.y - 1;

        while (level >= 0){
            
            if (nodes.get(level) == null){
                level--;
                continue;
            }
            for (Node node : nodes.get(level)){
                
                Node now = root;
                while (true){
                    if (now.x < node.x){
                        if (now.right == null){
                            now.right = node;
                            break;
                        }
                        now = now.right;
                    }
                    else{
                        if (now.left == null){
                            now.left = node;
                            break;
                        }
                        now = now.left;
                    }
                }
                
            }
    

            level--;
        }
        
        dfs(root);
        dls(root);
        System.out.println(answer2);
        for (int i = 0; i < nodeinfo.length; i++){
            answer[0][i] = answer1.get(i);
            answer[1][i] = answer2.get(i);
        }
        
        return answer;
    
    }
    
    public void dfs(Node node){
        if (node == null)
            return;
        
        answer1.add(node.num);
        
        dfs(node.left);
        dfs(node.right);
    }
    
    public void dls(Node node){


        if (node.left != null)
            dls(node.left);
        if (node.right != null)
            dls(node.right);
        answer2.add(node.num);
        if (node.right == null && node.left == null){
            
            return;
        }
        
        
    }
    
    public class Node{
        
        int x;
        int y;
        int num;
        Node left;
        Node right;
        
        public Node(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
        
    }
}