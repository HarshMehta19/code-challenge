class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
     int sum1 =0, sum2 = 0;
     for(int i=0;i<gas.length;i++) {
        sum1+= gas[i];
        sum2+= cost[i];
     }   
     if(sum1<sum2) return -1;
     int total = 0, start = 0;
     for(int i=0;i<gas.length;i++) {
        total += gas[i] - cost[i];
        if(total < 0){
            total = 0;
            start = i+1;
        }
     }
     return start;
    }
}