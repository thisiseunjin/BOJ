class Solution {
    int empty = 0;
    int coke = 0;
    
    public int solution(int a, int b, int n) {
        empty = n;
        
        trade(a,b);
        
        return coke;
    }
    
    public void trade(int a, int b){
        //a: 마트에 주어야 하는 병 수 
        //b: 마트가 주는 콜라 수 
        
        if(empty<a){
            return; //내가 더이상 콜라병을 줄 수 없다
        }
        
        //마트에 내가 줄 수 있는 콜라의 최대를 주고 내가 받는 콜라의 수?
        int giveCokeCnt = (empty/a)*a;
        //System.out.printf("마트에 %d개의 콜라병을 주었다.\n", giveCokeCnt);
        int getCokeCnt = (giveCokeCnt/a)*b;
        //System.out.printf("마트에서 %d개의 콜라를 받았다.\n", getCokeCnt);
        
        coke+=getCokeCnt;
        empty = empty - giveCokeCnt + getCokeCnt;
        
        trade(a, b);
    }
    
    
}