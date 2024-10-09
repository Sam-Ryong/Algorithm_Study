import java.beans.Visibility;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static int N = sc.nextInt(); //수빈
    static int K = sc.nextInt(); //동생

    static int result = 0;

    static ArrayList<Integer> poses = new ArrayList<Integer>();

    static boolean[] visited = new boolean[100001];
    static ArrayList<Integer> temp = new ArrayList<Integer>();
    public static void move(int time){

        for (int i = 0; i < poses.size(); i++)
        {
            visited[poses.get(i)] = true;
            if (poses.get(i) == K){
                result = time;
                return;
            }
        }
        for (int i = 0; i < poses.size(); i++)
        {
            int pos = poses.get(i);

            if (pos * 2 <= 100000)
                if (!visited[pos * 2])
                    temp.add(pos * 2);
            if (pos >= 1)
                if (!visited[pos - 1])
                    temp.add(pos - 1);
            if (pos + 1 <= 100000)
                if (!visited[pos + 1])
                    temp.add(pos + 1);
        }

        poses.clear();
        poses.addAll(temp);
        temp.clear();


        move(time + 1);


    }

    public static void main(String[] args) {
        poses.add(N);
        move(0);
        System.out.println(result);
    }

}