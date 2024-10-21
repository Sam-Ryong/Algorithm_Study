import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static class Heap{

        int[] array;
        int counter = 0;

        public Heap(int n) {
            this.array = new int[n];
        }

        boolean needSwap(int a, int b){
            if (Math.abs(a) < Math.abs(b))
                return true;
            else if(Math.abs(a) == Math.abs(b)){
                if (a < 0)
                    return true;
                else
                    return false;
            }
            else
                return false;
        }

        void push(int num){
            int now = counter;
            array[now] = num;

            while (now > 0){
                int parent = array[(now-1)/2];
                if (needSwap(array[now],parent)){
                    int temp = array[now];
                    array[now] = array[(now-1)/2];
                    array[(now-1)/2] = temp;
                    now = (now - 1) / 2;
                }
                else
                    break;
            }
            counter++;
        }

        int pop(){
            if (counter == 0)
                return 0;

            int result = array[0];
            counter--;
            array[0] = array[counter];
            int now = 0;

            while (true){
                int left = now * 2 + 1;
                int right = now * 2 + 2;
                if (right < counter){
                    if (needSwap(array[left],array[right])){
                        if (needSwap(array[left],array[now])){
                            int temp = array[now];
                            array[now] = array[left];
                            array[left] = temp;
                            now = left;
                        }
                        else
                            break;
                    }
                    else{
                        if (needSwap(array[right],array[now])){
                            int temp = array[now];
                            array[now] = array[right];
                            array[right] = temp;
                            now = right;
                        }
                        else
                            break;
                    }
                }

                else if(right == counter){
                    if (needSwap(array[left],array[now])){
                        int temp = array[now];
                        array[now] = array[left];
                        array[left] = temp;
                        now = left;
                    }
                    else
                        break;
                }
                else
                    break;
            }

            return result;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        Heap heap = new Heap(N);

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0)
                bw.write(String.valueOf(heap.pop()) + "\n");
            else
                heap.push(input);


        }

        bw.flush();

    }
}