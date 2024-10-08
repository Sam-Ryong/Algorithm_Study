import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();

    static class Heap{

        int[] array;
        int count = 0;
        StringBuilder output = new StringBuilder();

        public Heap(int N){
            this.array = new int[N];
        }

        public void push(int num){

            if(count == 0){
                array[0] = num;
                count = count + 1;
            }
            else{
                int now = count;
                int parent = (count - 1) / 2;
                array[now] = num;
                while (true){
                    if (array[now] < array[parent]){
                        array[now] = array[parent];
                        array[parent] = num;
                        now = parent;
                        parent = (now - 1) / 2;
                    }
                    else{
                        break;
                    }
                }

                count = count + 1;
            }
        }

        public int pop(){
            int result = array[0];
            if (count == 0){
                return 0;
            }
            count = count - 1;
            array[0] = array[count];
            int moving = array[0];
            int start = 0;
            while (true){
                int left = start * 2 + 1;
                int right = start * 2 + 2;
                if (left >= count){
                    break;
                }

                else if (left + 1 == count){
                    int next = left;
                    if (array[next] < array[start]){
                        array[start] = array[next];
                        array[next] = moving;
                        start = next;
                    }
                    else{
                        break;
                    }

                }
                else {
                    int next;
                    if (array[left] > array[right]){
                        next = right;
                    }
                    else{
                        next = left;
                    }
                    if (array[start] > array[next]) {
                        array[start] = array[next];
                        array[next] = moving;
                        start = next;
                    }
                    else{
                        break;
                    }
                }
            }
            array[count] = 0;
            return result;
        }
    }


    public static void main(String[] args) {

        StringBuilder output = new StringBuilder();
        Heap heap = new Heap(100000);
        for (int i = 0; i < N; i++){
            int input = sc.nextInt();
            if (input > 0){
                heap.push(input);
            }
            else{
                output.append(heap.pop() + "\n");
            }
        }


        System.out.println(output);

    }

}