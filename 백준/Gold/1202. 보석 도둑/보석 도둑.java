import java.io.*;
import java.util.*;

public class Main {

    static int N, K;

    static ArrayList<Jew> jews = new ArrayList<>();
    static PriorityQueue<Integer> bags = new PriorityQueue<>();


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Jew implements Comparable<Jew>{
        int mass;
        long val;

        public Jew(int mass, long val){
            this.mass = mass;
            this.val = val;
        }

        @Override
        public int compareTo(Jew o){
            if (this.mass == o.mass){
                return Long.compare(this.val, o.val) * -1;
            }
            return (Integer.compare(this.mass, o.mass));
        }
    }

    public static int binarySearch(int low, int high, int key){
        int mid = (low + high) / 2;
        while (high > low){
            if (jews.get(mid).mass >= key){
                high = mid;
            }
            else {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }
        return mid;
    }

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);



        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            int M = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            jews.add(new Jew(M,V));
        }

        for (int i = 0; i < K; i++) {
            bags.offer(Integer.parseInt(br.readLine()));
        }
        Collections.sort(jews);
/*        for (Jew jew : jews) {
            System.out.println(jew.mass + " " + jew.val);
        }*/
        long result = 0;
        PriorityQueue<Long> temp = new PriorityQueue<>(Comparator.reverseOrder());
        int low = 0;
        while (true){
            Integer bag = bags.poll();
            if (bag == null)
                break;
            if (low <= N - 1) {
                int index = binarySearch(low, N - 1, bag);
                if (jews.get(index).mass > bag)
                    index--;
                for (int i = low; i <= index; i++) {
                    temp.offer(jews.get(i).val);
                }
                low = index + 1;
            }
            if (temp.size() > 0) {
                result = result + temp.poll();
            }

        }
        System.out.println(result);



    }
}