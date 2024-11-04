import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N, M, T;

    static boolean[] human;
    static ArrayList<ArrayList<Integer>> party;

    static int result = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean tellingTheTruth(){
        boolean isChanged = false;
        int count = M;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < party.get(i).size(); j++) {
                if (human[party.get(i).get(j)]) {
                    for (int k = 0; k < party.get(i).size(); k++) {
                        if (!human[party.get(i).get(k)]) {
                            human[party.get(i).get(k)] = true;
                            isChanged = true;
                        }
                    }
                    count--;
                    break;
                }
            }
        }
        result = count;

        return isChanged;
    }

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        T = Integer.parseInt(s[0]);
        human = new boolean[N+1];
        party = new ArrayList<>();
        for (int i = 1; i < T+1; i++) {
            human[Integer.parseInt(s[i])] = true;
        }
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            party.add(new ArrayList<>());
            for (int j = 1; j < Integer.parseInt(s[0]) + 1; j++) {
                party.get(i).add(Integer.parseInt(s[j]));
            }
        }
        boolean isChanged = true;
        while (isChanged){
            isChanged = tellingTheTruth();
        }

        System.out.println(result);



    }
}