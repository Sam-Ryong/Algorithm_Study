import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Heap {
        int[] array;
        int counter = 0;

        public Heap(int num) {
            this.array = new int[num];
        }


        void push(int x){
            array[counter] = x;
            int now = counter;
            int parent = (counter - 1) / 2;
            while (now != 0){
                if (array[now] > array[parent]){
                    int temp = array[now];
                    array[now] = array[parent];
                    array[parent] = temp;
                    now = parent;
                    parent = (parent - 1) / 2;
                }

                else{
                    break;
                }
            }
            counter = counter + 1;
        }

        int pop(){
            if (counter == 0){
                return 0;
            }
            counter = counter - 1;
            int value = array[0];
            array[0] = array[counter];
            array[counter] = 0;
            int now = 0;
            int left = now * 2 + 1;
            int right = now * 2 + 2;
            while (now < counter){
                int next = -1;
                if (right < counter && array[now] < Math.max(array[left],array[right])){
                    if (array[left] > array[right]){
                        next = left;
                    }
                    else {
                        next = right;
                    }
                    int temp = array[now];
                    array[now] = array[next];
                    array[next] = temp;
                }
                else if (left < counter && right >= counter && array[now] < array[left]){
                    next = left;
                    int temp = array[now];
                    array[now] = array[next];
                    array[next] = temp;
                }
                if (next == -1)
                    break;
                now = next;
                left = now * 2 + 1;
                right = now * 2 + 2;
            }
            return value;

        }
    }



    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));



    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(bf.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Heap heap = new Heap(N);

        for (int i = 0; i < N; i++){
            int input = Integer.parseInt(bf.readLine());
            if (input == 0){
                int max = heap.pop();
                bw.write(max+"\n");
            }
            else{
                heap.push(input);
            }
            for (int j = 0; j < N; j++){
                if (heap.array[j] == 0)
                    break;
            }
        }
        bw.flush();

    }
}