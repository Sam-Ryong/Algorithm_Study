import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int V;

    static int result = 0;
    static int point = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void process(ArrayList<String> mem){
        int start = 0;
        int end = mem.size() - 1;
        boolean foundLeft = false;
        boolean foundRight = false;
        for(int i = 0; i < mem.size(); i++){
            if (mem.get(i).equals("(")) {
                start = i;
                foundLeft = true;
            }
            if (mem.get(i).equals(")")){
                end = i;
                foundRight = true;
                break;
            }
        }
        for (int i = start; i < end+1; i++) {
            if (mem.get(i).equals("*") || mem.get(i).equals("/")){
                mem.add(i, mem.get(i-1) + mem.get(i+1) + mem.get(i));
                mem.remove(i+1);
                mem.remove(i+1);
                mem.remove(i-1);
                end = end - 2;
                i = i - 1;
            }
        }
        for (int i = start; i < end+1; i++) {
            if (mem.get(i).equals("+") || mem.get(i).equals("-")){
                mem.add(i, mem.get(i-1) + mem.get(i+1) + mem.get(i));
                mem.remove(i+1);
                mem.remove(i+1);
                mem.remove(i-1);
                end = end - 2;
                i = i - 1;
            }
        }
        if (foundLeft && foundRight) {
            mem.remove(end);
            mem.remove(start);
        }
    }

    public static void main(String[] args) throws IOException {

        String s = br.readLine();
        ArrayList<String> mem = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            mem.add(s.substring(i,i+1));
        }
        while (mem.size() > 1){
            process(mem);
        }
        System.out.println(mem.get(0));

    }
}