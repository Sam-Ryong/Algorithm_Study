import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static int N = sc.nextInt();
    static int M = sc.nextInt();

    static int[] trees = new int[N];

    static long[] sums = new long[N+1];

    public static int binarySearch(int low, int high, int val){

        int result = -1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (trees[mid] >= val){
                high = mid - 1;
                result = mid;
            }
            else{
                low = mid + 1;
            }
        }

        return result;

    }
    public static long search(int low, int high, long val){

        long result = 0;
        while (low <= high){
            int mid = (low + high) / 2;
            int now = binarySearch(0, N - 1, mid); // mid 보다 크거나 같은 첫번째 trees의 인덱스를 찾아야함
            long total = sums[N-1] - sums[now] + trees[now];
            if ((total - (long) mid * (N - now)) >= val){
                low = mid + 1;
                result = mid;
            }
            else{
                high = mid - 1;
            }
        }

        return result;

    }

    public static void main(String[] args) {

        for (int i = 0; i < N; i++){
            trees[i] = sc.nextInt();
        }

        Arrays.sort(trees);
        sums[0] = 0;

        for (int i = 1; i < N; i++){
            sums[i] = sums[i-1] + trees[i];
        }

        long result = search(0,trees[N-1],M);

        System.out.println(result);




    }

}