import java.util.*;


class Solution {
    List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        for(int[] d : data){
            if(!isPossible(d, ext, val_ext)) continue;
            list.add(d);
        }
        
        sort(sort_by);
        
        int[][] result = new int[list.size()][4];
        for(int i=0;i<list.size();i++){
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
            result[i][2] = list.get(i)[2];
            result[i][3] = list.get(i)[3];
        }
        
        return result;
    }
    
    public void sort(String ext){
        if(ext.equals("code")) {
            Collections.sort(list, Comparator.comparing(ints-> ints[0]));
            System.out.println("code기준으로 정렬");
            return;
        }
        else if(ext.equals("date")) {
            Collections.sort(list, Comparator.comparing(ints-> ints[1]));
            System.out.println("date기준으로 정렬");
            return;
        }
        else if(ext.equals("maximum")) {
            Collections.sort(list, Comparator.comparing(ints-> ints[2]));
            System.out.println("maximum 기준으로 정렬");
            return;
        }
        else Collections.sort(list, Comparator.comparing(ints-> ints[3]));
    }
    
    public boolean isPossible(int[] data, String ext, int val_ext){
        if(ext.equals("code")){
            //코드가 ext보다 작은 지 확인한다.
            if(data[0]<val_ext) return true;
            return false;
        }
        
        if(ext.equals("date")){
            if(data[1]<val_ext) return true;
            return false;
        }
        
        if(ext.equals("maximum")){
            if(data[2]<val_ext) return true;
            return false;
        }
        
        if(data[3]<val_ext) return true;
        return false;
    }
}