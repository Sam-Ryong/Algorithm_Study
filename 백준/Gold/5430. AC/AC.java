import java.io.*;
import java.util.*;

//허프만 코딩이랑 아리스메틱 코딩 중 하나는 무조건냄
//그림그려서 설명하게냄

public class Main {

    static int T;

    static char[] p;

    static int n;

    static ArrayList<Integer> array = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            p = br.readLine().toCharArray();
            n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String[] s2 = s.substring(1,s.length()-1).split(",");
            for (int j = 0; j < n; j++) {
                array.add(Integer.parseInt(s2[j]));
            }
            boolean isError = false;
            boolean isReversed = false;
            for (char c : p) {
                if (c == 'R'){
                    isReversed = !isReversed;
                }
                else if (c == 'D'){
                    if (array.size() == 0) {
                        isError = true;
                        break;
                    }
                    else {
                        if (!isReversed)
                            array.remove(0);
                        if (isReversed)
                            array.remove(array.size()-1);
                    }
                }
                else{
                    isError = true;
                    break;
                }
            }
            if (isReversed)
                Collections.reverse(array);
            if (isError)
                bw.write("error\n");
            else{
                bw.write(array.toString().replaceAll(" ","") +"\n");
            }
            array.clear();
        }



        bw.flush();

    }
}