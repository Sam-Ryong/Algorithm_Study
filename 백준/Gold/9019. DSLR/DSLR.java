import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

//허프만 코딩이랑 아리스메틱 코딩 중 하나는 무조건냄
//그림그려서 설명하게냄

public class Main {

    static int T;

    static StringBuilder stringBuilder = new StringBuilder();

    public static int Double(int n){
        n = (n * 2) % 10000;
        return n;
    }

    public static int Sub(int n){
        n = n - 1;
        if (n == -1)
            n = 9999;
        return n;
    }

    public static int Left(int n){
        int m = n / 1000;
        n = (n - m * 1000) * 10 + m;
        return n;
    }

    public static int Right(int n){
        int m = n % 10;
        n = n / 10;
        n = n + m * 1000;
        return n;
    }
    static class node{
        int val;
        String s;
        node parent;
        node D;
        node S;
        node L;
        node R;

        public node(int val, String s) {
            this.val = val;
            this.s = s;
        }

        public void setD(node d) {
            D = d;
        }

        public void setS(node s) {
            S = s;
        }

        public void setL(node l) {
            L = l;
        }

        public void setR(node r) {
            R = r;
        }

        public void setParent(node parent) {
            this.parent = parent;
        }
    }

    static void printString(node node){
        String result = "";
        while (node != null) {
            result = node.s + result;
            node = node.parent;
        }
        stringBuilder.append(result + "\n");
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split(" ");
            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);
            ArrayList<node> nodes = new ArrayList<>();
            ArrayList<node> temp = new ArrayList<>();
            boolean[] visited = new boolean[10000];
            nodes.add(new node(A,""));
            boolean isEnd = false;
            while (true){
                for (node node : nodes) {
                    if (node.val == B) {
                        isEnd = true;
                        printString(node);
                        break;
                    }
                    if (node.val >= 0 && node.val < 10000 && !visited[node.val]){
                        node.D = new node(Double(node.val),"D");
                        node.D.setParent(node);
                        node.S = new node(Sub(node.val),"S");
                        node.S.setParent(node);
                        node.L = new node(Left(node.val), "L");
                        node.L.setParent(node);
                        node.R = new node(Right(node.val), "R");
                        node.R.setParent(node);
                        temp.add(node.D);
                        temp.add(node.S);
                        temp.add(node.L);
                        temp.add(node.R);
                        visited[node.val] = true;
                    }
                }

                if (isEnd)
                    break;

                nodes.clear();
                nodes.addAll(temp);
                temp.clear();
            }

        }


        System.out.print(stringBuilder);
    }
}