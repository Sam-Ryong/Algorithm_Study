import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = 0;
        List<String> melody = new ArrayList<>();
        for (int i = 0; i < m.length(); i++){
            if (m.substring(i,i+1).equals("#")){
                melody.remove(melody.size()-1);
                melody.add(m.substring(i-1,i+1));
            }
            else{
                melody.add(m.substring(i,i+1));
            }
        }
        m = "";
        for (int i = 0; i < melody.size(); i++){
            if (melody.get(i).length() == 2){
                m += melody.get(i).substring(0,1).toLowerCase();
            }
            else{
                m += melody.get(i);
            }
        } 
        
        for (String s : musicinfos){
            
            String[] parse = s.split(",");
            int startTime = Integer.parseInt(parse[0].substring(0,2)) * 60 + Integer.parseInt(parse[0].substring(3));
            int endTime = Integer.parseInt(parse[1].substring(0,2)) * 60 + Integer.parseInt(parse[1].substring(3));
            int runTime = endTime - startTime;
            String title = parse[2];
            String real = "";
            List<String> notes = new ArrayList<>();
            for (int i = 0; i < parse[3].length(); i++){
                if (parse[3].substring(i,i+1).equals("#")){
                    notes.remove(notes.size()-1);
                    notes.add(parse[3].substring(i-1,i+1));
                }
                else{
                    notes.add(parse[3].substring(i,i+1));
                }
            }
            
            
            for (int i = 0; i < runTime / notes.size(); i++){
                real += parse[3];
            }
            
            for (int i = 0; i < runTime % notes.size(); i++){
                real += notes.get(i);
            }
            
            real = real.replaceAll("C#","c");
            real = real.replaceAll("D#","d");
            real = real.replaceAll("E#","e");
            real = real.replaceAll("F#","f");
            real = real.replaceAll("G#","g");
            real = real.replaceAll("A#","a");
            real = real.replaceAll("B#","b");
            
            
            if (max < runTime && real.contains(m)){
                max = runTime;
                answer = title;
            }
            
        }
        
        return answer;
    }
}