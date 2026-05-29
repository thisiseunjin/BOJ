class Solution {
    public int solution(int[][] sizes) {
        
        int maxX = 0;
        int maxY = 0;
        
        for(int[] size : sizes){
            int x = Math.max(size[0], size[1]);
            int y = Math.min(size[0], size[1]);
            
            maxX = Math.max(x, maxX);
            maxY = Math.max(y, maxY);
        }
        return maxX*maxY;
    }
}