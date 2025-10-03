import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> map = new HashMap<>();
        
        initData(map);

        for (String s : info){
            String[] data = s.split(" ");
            String key = data[0] + " and " + data[1] + " and " + data[2] + " and " + data[3];
            map.get(key).add(Integer.parseInt(data[4]));
        }
        
        for (String key : map.keySet()){
            Collections.sort(map.get(key));
        }
        
        for (int i = 0; i < query.length; i++){
            List<String> lang = new ArrayList<>();
            List<String> pos = new ArrayList<>();
            List<String> exp = new ArrayList<>();
            List<String> food = new ArrayList<>();
            String[] ah = query[i].split(" ");
            if (ah[0].equals("-")){
                lang.add("java");
                lang.add("python");
                lang.add("cpp");
            }
            else
                lang.add(ah[0]);
            
            if (ah[2].equals("-")){
                pos.add("backend");
                pos.add("frontend");
            }
            else
                pos.add(ah[2]);
            
            if (ah[4].equals("-")){
                exp.add("junior");
                exp.add("senior");
            }
            else
                exp.add(ah[4]);
            
            if (ah[6].equals("-")){
                food.add("pizza");
                food.add("chicken");
            }
            else
                food.add(ah[6]);
            
            int count = 0;
            for (String l : lang){
                for (String p : pos){
                    for (String e : exp){
                        for (String f : food){
                            
                            List<Integer> tuple = map.get(l + " and " + p  + " and " + e  + " and " + f);
                            
                            if (tuple.size() == 0)
                                continue;
                            
                            int where = Collections.binarySearch(tuple, Integer.parseInt(ah[7]));
                            
                            if (where < 0)
                                where = -where - 1;
                            
                            else{
                                while (where > 0 && tuple.get(where - 1) == Integer.parseInt(ah[7]))
                                    where--;
                            }
                            
                            count += tuple.size() - where;
                            
                        }
                    }
                }
            }
        

            answer[i] = count;
            
        }

        
        return answer;
    }
    
    
    void initData(Map<String, List<Integer>> map){
        String[] langs = new String[]{"java", "python", "cpp"};
        
        for (String lang : langs){
            map.put(lang + " and backend and junior and pizza", new ArrayList<Integer>());
            map.put(lang + " and backend and junior and chicken", new ArrayList<Integer>());
            map.put(lang + " and backend and senior and pizza", new ArrayList<Integer>());
            map.put(lang + " and backend and senior and chicken", new ArrayList<Integer>());
            map.put(lang + " and frontend and junior and pizza", new ArrayList<Integer>());
            map.put(lang + " and frontend and junior and chicken", new ArrayList<Integer>());
            map.put(lang + " and frontend and senior and pizza", new ArrayList<Integer>());
            map.put(lang + " and frontend and senior and chicken", new ArrayList<Integer>());
        }
        
       
        
    }
    

}