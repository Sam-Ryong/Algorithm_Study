class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int startTime = h1 * 60 * 60 + m1 * 60 + s1;
        int endTime = h2 * 60 * 60 + m2 * 60 + s2;
        
        int beforeH = startTime % (12 * 60 * 60);
        int beforeM = startTime % (60 * 60) * 12;
        int beforeS = (startTime % 60) * 60 * 12;
        
        if (beforeS == beforeM || beforeS == beforeH)
            answer++;
 
        for (int time = startTime+1; time <= endTime; time++){
            int angleH = time % (12 * 60 * 60); // 1만큼 증가
            int angleM = time % (60 * 60) * 12; // 12 만큼 증가
            int angleS = (time % 60) * 60 * 12; // 1초에 60 * 12 만큼 증가 
            
            if (angleH == 0)
                angleH = 12 * 60 * 60;
            if (angleM == 0)
                angleM = 12 * 60 * 60;
            if (angleS == 0)
                angleS = 12 * 60 * 60;
            
            if (time == 0 || time == 12 * 60 * 60){
                answer++;
                beforeS = 0;
                beforeM = 0;
                beforeH = 0;
                continue;
            }
            
            if (angleS >= angleM && beforeM > beforeS){
                answer++;
            }
            if (angleS >= angleH && beforeH > beforeS){
                answer++;
            }
            beforeS = (angleS == 12 * 60 * 60) ? 0 : angleS;
            beforeM = (angleM == 12 * 60 * 60) ? 0 : angleM;
            beforeH = (angleH == 12 * 60 * 60) ? 0 : angleH;
        }
        
        return answer;
    }
}