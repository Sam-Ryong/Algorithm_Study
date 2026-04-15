import java.util.*;

class Solution {
    
    List<Integer> a = new ArrayList<>();
    List<Integer> b = new ArrayList<>();
    List<ArrayList<Integer>> combination = new ArrayList<>();
    List<Integer> prob = new ArrayList<>();
    int[][] dice;
    
    public int[] solution(int[][] dice) {
        int[] answer = new int[dice.length / 2];
        this.dice = dice;
        
        makeCombination(dice.length, 0, new ArrayList<>());
        
        for (ArrayList<Integer> c : combination){
            ArrayList<Integer> bCombination = new ArrayList<>();
            for (int i = 0; i < dice.length; i++){
                if (!c.contains(i))
                    bCombination.add(i);
            }
            calcProbA(c, 0, 0);
            calcProbB(bCombination, 0, 0);
            int win = 0;
            Collections.sort(b);
            for (int i = 0; i < a.size(); i++){
                win += upperBound(b, a.get(i));
            }
            prob.add(win);
            a.clear();
            b.clear();
        }
        int max = Integer.MIN_VALUE;
        int answer_index = -1;
        
        for (int i = 0; i < prob.size(); i++){
            if (prob.get(i) > max){
                max = prob.get(i);
                answer_index = i;
            }
        }
        
        ArrayList<Integer> answer_combination = combination.get(answer_index);
        
        for (int i = 0; i < answer.length; i++){
            answer[i] = answer_combination.get(i) + 1;
        }
        
        return answer;
    }
    
    void makeCombination(int n, int now, ArrayList<Integer> set){
        for (int i = now; i < n; i++){
            ArrayList<Integer> newSet = new ArrayList<>();
            newSet.addAll(set);
            newSet.add(i);
            if (newSet.size() == n / 2){
                combination.add(newSet);
                continue;
            }
            makeCombination(n, i+1, newSet);
        }
    }
    
    void calcProbA(ArrayList<Integer> c, int now, int result){
        if (now == c.size()){
            a.add(result);
            return;
        }
        for (int i = 0; i < 6; i++){
            calcProbA(c, now + 1, result + dice[c.get(now)][i]);
        }
    }
    void calcProbB(ArrayList<Integer> c, int now, int result){
        if (now == c.size()){
            b.add(result);
            return;
        }
        for (int i = 0; i < 6; i++){
            calcProbB(c, now + 1, result + dice[c.get(now)][i]);
        }
    }
    
    int upperBound(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr.get(mid) >= target) { 
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}