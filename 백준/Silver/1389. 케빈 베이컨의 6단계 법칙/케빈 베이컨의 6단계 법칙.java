import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static Map<Integer,User> users = new HashMap<>();

    static class User{

        int num;
        ArrayList<User> friends = new ArrayList<>();

        public User(int num) {
            this.num = num;
        }

        void setFriends(User user){
            friends.add(user);
        }
    }

    static long kevinBacon(int userNum){
        ArrayList<User> friends = new ArrayList<>();
        ArrayList<User> temp = new ArrayList<>();
        long result = 0;
        long bacon = 0;
        boolean[] checked = new boolean[N+1];
        checked[userNum] = true;
        friends.addAll(users.get(userNum).friends);
        int count = 0;
        while (count < N - 1){
            bacon++;
            for (User friend : friends){
                if (!checked[friend.num]){
                result = result + bacon;
                count++;
                checked[friend.num] = true;
                for (User linked : friend.friends){
                    if (!checked[linked.num])
                        temp.add(linked);
                    }
                }
            }
            friends.clear();
            friends.addAll(temp);
            temp.clear();

        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int user1 = Integer.parseInt(s[0]);
            int user2 = Integer.parseInt(s[1]);
            if (users.get(user1) == null)
                users.put(user1,new User(user1));
            if (users.get(user2) == null)
                users.put(user2,new User(user2));
            users.get(user1).setFriends(users.get(user2));
            users.get(user2).setFriends(users.get(user1));
        }
        long min = Long.MAX_VALUE;
        int result = 100;
        for (int i : users.keySet()) {
            long kevin = kevinBacon(i);
            if (kevin < min) {
                result = i;
                min = kevin;
            }
            if (kevin == min && result > i)
                result = i;
        }
        System.out.println(result);

    }
}