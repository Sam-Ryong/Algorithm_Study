import com.sun.security.auth.NTSid;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static int N, M;

    static Student[] students;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static class Student{
        ArrayList<Integer> right = new ArrayList<>();

    }
    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        students = new Student[N+1];
        Queue<Integer> queue= new ArrayDeque<>();
        int[] degree = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            students[i] = new Student();
        }
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);
            students[A].right.add(B);
            degree[B]++;
        }
        int count = 0;
        while (count < N){

            for (int i = 1; i < N+1; i++) {
                if (degree[i] == 0){
                    queue.add(i);
                    degree[i] = -1;
                }
            }
            Integer num = queue.poll();
            bw.write(num + " ");
            count++;
            for (Integer student : students[num].right){
                degree[student]--;
            }


        }

        bw.flush();


    }

}