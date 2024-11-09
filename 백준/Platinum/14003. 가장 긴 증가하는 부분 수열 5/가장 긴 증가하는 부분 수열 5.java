import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N;
    static int[] numbers;
    static ArrayList<Integer> subSeq = new ArrayList<>();
    static ArrayList<Integer> memo = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringBuilder st = new StringBuilder();

    public static int binarySearch(int val){
        int start = 0;
        int end = subSeq.size();
        while (end > start){
            int mid = (start + end) / 2;
            if (subSeq.get(mid) < val){
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return (start + end) / 2;
    }
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        numbers = new int[N+1];
        numbers[0] = Integer.MIN_VALUE;
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i+1] = Integer.parseInt(s[i]);
        }
        subSeq.add(numbers[1]);
        memo.add(1);
        for (int i = 2; i < N+1; i++) {
            if (subSeq.get(subSeq.size()-1) < numbers[i]){
                subSeq.add(numbers[i]);
                memo.add(subSeq.size());
            }
            else {
                int index = binarySearch(numbers[i]);
                subSeq.set(index,numbers[i]);
                memo.add(index+1);
            }
        }
        int counter = subSeq.size();
        int[] result = new int[counter];
        bw.write(counter + "\n");
        for (int i = N; i > 0; i--) {
            if(memo.get(i-1) == counter){
                counter--;
                result[counter] = numbers[i];
            }
            if (counter == 0)
                break;
        }
        for (int i = 0; i < subSeq.size(); i++) {
            bw.write(String.valueOf(result[i]));
            bw.write(" ");
        }
        bw.flush();

    }

}