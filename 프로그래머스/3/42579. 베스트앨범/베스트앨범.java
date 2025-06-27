import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String,PriorityQueue<Music>> map = new HashMap<>();
        Map<String,Integer> mapCount = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++){
            
            if (map.get(genres[i]) == null){
                PriorityQueue<Music> pq = new PriorityQueue<Music>((o1,o2) -> {
                    if (o1.play == o2.play)
                        return Integer.compare(o1.id, o2.id);
                    
                    return -Integer.compare(o1.play, o2.play);
                });
                pq.offer(new Music(i,plays[i]));
                map.put(genres[i], pq);
                mapCount.put(genres[i], plays[i]);
            }
            else{
                PriorityQueue<Music> pq = map.get(genres[i]);
                pq.offer(new Music(i,plays[i]));
                mapCount.put(genres[i], mapCount.get(genres[i]) + plays[i]);
            }
            
        }
        
        Collection<PriorityQueue<Music>> values = map.values();
        
        PriorityQueue<String> sequence = new PriorityQueue<String>((o1,o2) -> {
     
                    return -Integer.compare(mapCount.get(o1), mapCount.get(o2));

                });
        
        for (String s : mapCount.keySet()){
            sequence.offer(s);
        }
        
        
        List<Integer> temp = new ArrayList<>();
        while (!sequence.isEmpty()){
            PriorityQueue<Music> pq = map.get(sequence.poll());
            int count = 0;
            while (!pq.isEmpty() && count < 2){
                temp.add(pq.poll().id);
                count++;
            }
        }
        
        int[] answer = new int[temp.size()];
        
        for (int i = 0; i < temp.size(); i++){
            answer[i] = temp.get(i);
        }
        
        return answer;
    }
    
    class Music{
        int id;
        int play;
        
        Music(int id, int play){
            this.id = id;
            this.play = play;
        }
    }
}