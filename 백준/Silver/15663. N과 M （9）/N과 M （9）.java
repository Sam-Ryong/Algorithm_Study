 import java.io.*;
 import java.lang.reflect.Array;
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.Collections;

 public class Main {

     static int N, M;

     static int[] numbers;

     static String prev = "";

     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

     static public void dfs(int index, int visited, int count, String output) throws IOException {
         if ((visited & (int) Math.pow(2,index))==(int) Math.pow(2,index))
             return;

         visited = visited | (int) Math.pow(2,index);
         output = output + numbers[index] + " ";
         if (count == 1){
             if (!prev.equals(output)){
                 prev = output;
                 bw.write(output +"\n");
             }
             return;
         }
         int prevnum = 0;
         for (int i = 0; i < N; i++) {
             if (prevnum != numbers[i] && ((visited & (int) Math.pow(2,i)) != (int) Math.pow(2,i))) {
                 prevnum = numbers[i];
                 dfs(i, visited, count - 1, output);
             }
         }
     }



     public static void main(String[] args) throws IOException {

         String[] s = br.readLine().split(" ");
         N = Integer.parseInt(s[0]);
         M = Integer.parseInt(s[1]);

         numbers = new int[N];


         s = br.readLine().split(" ");

         for (int i = 0; i < N; i++) {
             numbers[i] = Integer.parseInt(s[i]);
         }
         Arrays.sort(numbers);
         int prevnum = 0;
         for (int i = 0; i < N; i++) {
             if (prevnum != numbers[i]) {
                 prevnum = numbers[i];
                 dfs(i, 0, M, "");
             }
         }

         bw.flush();

     }
 }