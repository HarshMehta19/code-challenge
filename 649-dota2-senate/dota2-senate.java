class Solution {
    public String predictPartyVictory(String senate) {
        char[] charArr = senate.toCharArray();
        return solve(charArr, 0);
        // int length = senate.length();
        // char[] charArr = senate.toCharArray();
        // Queue<Integer> D = new LinkedList<>();
        // Queue<Integer> R = new LinkedList<>();
        // int i =0;
        // while(i<length) {
        //     if(charArr[i] == 'R')
        //         R.add(i);
        //     else
        //         D.add(i);
        //     i++;
        // }

        // while(!R.isEmpty() && !D.isEmpty()) {
        //     int iR = R.poll();
        //     int iD = D.poll();

        //     if(iR < iD)
        //         R.add(iR + length);
        //     else
        //         D.add(iD + length);
        // }

        // return R.isEmpty() ? "Dire" : "Radiant";

    }

    private String solve(char[] charArr, int vote) {
        int d = 0, r = 0;
        int index = 0;
        while(index < charArr.length) {
            if(charArr[index] == 'D') {
                if(vote>=0){
                    d++;
                } else {
                    charArr[index] = '0';
                }
                vote++;
            } else if(charArr[index] == 'R') {
                if(vote <= 0) {
                    r++;
                } else {
                    charArr[index] = '0';
                }
                vote--;
            }
            index++;
        }
        if(d!=0 && r==0) return "Dire";
        if(r!=0 && d==0) return "Radiant";

        return solve(charArr, vote);
    }
}