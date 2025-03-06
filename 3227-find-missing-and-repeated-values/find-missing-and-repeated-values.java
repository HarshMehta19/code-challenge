class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] freq = new int[2501];

        for(int[] row: grid) {
            for(int ele: row) {
                freq[ele]++;
            }
        }
        int duplicate = 0, missing = 0; 
        for(int i=1;i<2501;i++) {
            if(duplicate == 0 && freq[i] > 1){
                duplicate = i;
            } else if(missing ==0 && freq[i] == 0)
                missing = i;
                
        }

        return new int[]{duplicate, missing};
    }
}