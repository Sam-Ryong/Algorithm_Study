import java.util.*;

class Solution {
    
    int[] answer;
    Map<String, Worker> workers = new HashMap<>();
    Map<String, Integer> where = new HashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        
        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            workers.put(name, new Worker(name));
            where.put(name, i);
        }
        
        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            String rname = referral[i];
            if (!rname.equals("-"))
                workers.get(name).setRef(workers.get(rname));
        }
        
        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int price = amount[i] * 100;
            propagation(workers.get(name), price);
            
        }
        
        
        return answer;
    }
    
    void propagation(Worker worker, int benefit){
        
        if (worker == null)
            return;
        
        if (benefit == 0)
            return;
        
        int fee = (int) (benefit * 0.1);
        
        answer[where.get(worker.name)] += benefit - fee;
        
        propagation(worker.referral, fee);
        
        
    }
    
    class Worker{
        
        Worker referral;
        String name;
        
        public Worker(String name){
            this.name = name;
        }
        
        public void setRef(Worker worker){
            this.referral = worker;
        }
        
    }
}