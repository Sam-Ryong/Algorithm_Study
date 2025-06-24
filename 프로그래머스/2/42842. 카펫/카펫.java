class Solution {
    public int[] solution(int brown, int yellow) {
        
        int height = 0;
        int width = 0;
        
        // (width - 2) * (height - 2) = yellow
        // 2 * (width + height) - 4 = brown
        // 2 * width - 4 = brown - 2 * height
        // (brown - 2 * height)(height - 2) = 2 * yellow
        // brown * height - 2 * brown - 2 * height * height + 4 * height = 2 * yellow
        
        while (true){
            height++;
            if (brown * height - 2 * brown - 2 * height * height + 4 * height == 2 * yellow){
                break;
            }
        }
        width = (brown - 2 * height + 4) / 2;
        int[] answer = {width, height};
        
        return answer;
    }
}