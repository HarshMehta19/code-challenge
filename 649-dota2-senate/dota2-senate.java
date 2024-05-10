class Solution {
    public String predictPartyVictory(String senate) {
        int length = senate.length();
        char[] charArr = senate.toCharArray();
        Queue<Integer> D = new LinkedList<>();
        Queue<Integer> R = new LinkedList<>();
        int i =0;
        while(i<length) {
            if(charArr[i] == 'R')
                R.add(i);
            else
                D.add(i);
            i++;
        }

        while(!R.isEmpty() && !D.isEmpty()) {
            int iR = R.poll();
            int iD = D.poll();

            if(iR < iD)
                R.add(iR + length);
            else
                D.add(iD + length);
        }

        return R.isEmpty() ? "Dire" : "Radiant";

    }
}