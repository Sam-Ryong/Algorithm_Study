class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
         for (int i = 0; i < skill_trees.length; i++){
            if (isPossible(skill, skill_trees[i]))
                answer++;
        }
        return answer;
    }
    
    boolean isPossible(String skill, String skillTree){
        
        int[] memory = new int[skill.length()];
        boolean result = true;
        for (int i = 0; i < skill.toCharArray().length; i++){
            memory[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < skill.toCharArray().length; i++){
            for (int j = 0; j < skillTree.toCharArray().length; j++){
                if(skill.charAt(i) == skillTree.charAt(j)){
                    memory[i] = j;
                    break;
                }
            }
        }
        for (int i = 1; i < memory.length; i++){
            if (memory[i] < memory[i-1]){
                result = false;
                break;
            }
        }
        
        return result;
       
        
    }
}