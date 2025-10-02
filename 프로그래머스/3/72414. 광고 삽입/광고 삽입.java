import java.util.*;

class Solution {

    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "00:00:00";
        int playTime = parseTime(play_time);
        int advTime = parseTime(adv_time);
        /*
            timeTable[i] = i-1초 ~ i초 까지 구간의 시청자 수
        */
        int[] timeTable = new int[parseTime(play_time) + 2];
        
        for (String log : logs){
            
            String[] times = log.split("-");
            int startTime = parseTime(times[0]);
            int endTime = parseTime(times[1]);
            
            timeTable[startTime + 1]++;
            timeTable[endTime + 1]--;
            
        }
        
        for (int i = 1; i <= playTime; i++){
            timeTable[i] = timeTable[i-1] + timeTable[i];
        }
        
        /*
            acc[i] = 0초 ~ i초까지 누적 시청량
        */
        long[] acc = new long[playTime + 1];
        for (int i = 1; i <= playTime; i++){
            acc[i] = acc[i-1] + timeTable[i];
        }
        long max = 0;
        for (int i = 0; i + advTime <= playTime; i++){
            if (max < acc[i+advTime] - acc[i]){
                max = acc[i+advTime] - acc[i];
                answer = timeToString(i);
            }
        }
        
        return answer;
    }
    
    int parseTime(String s){
        
        String[] time = s.split(":");
        
        return Integer.parseInt(time[0]) * 60 * 60 + Integer.parseInt(time[1]) * 60 + Integer.parseInt(time[2]);
        
    }
    
    String timeToString(int time){
        int hh = time / (60 * 60);
        int mm = (time - hh * 60 * 60) / 60;
        int ss = time % 60;
        String HH = "0" +hh;
        String MM = "0" +mm;
        String SS = "0" + ss;
        if (HH.length() == 3)
            HH = HH.substring(1,3);
        if (MM.length() == 3)
            MM = MM.substring(1,3);
        if (SS.length() == 3)
            SS = SS.substring(1,3);
        return HH + ":" + MM + ":" + SS;
    }
}