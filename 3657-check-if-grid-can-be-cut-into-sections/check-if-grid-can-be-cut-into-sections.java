class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> xCoord = new ArrayList<>();
        List<int[]> yCoord = new ArrayList<>();

        for(int[]rectangle: rectangles) {
            xCoord.add(new int[]{rectangle[0], rectangle[2]});
            yCoord.add(new int[]{rectangle[1], rectangle[3]});
        }

        Collections.sort(xCoord, (a, b) -> Integer.compare(a[0], b[0]));
        Collections.sort(yCoord, (a, b) -> Integer.compare(a[0], b[0]));

        return Math.max(countNonOverlapping(xCoord), countNonOverlapping(yCoord)) >= 3;
    }

    private int countNonOverlapping(List<int[]> intervals) {
        int sections = 1;
        int maxEnd = intervals.get(0)[1];

        for(int i=1;i<intervals.size();i++) {
            if(maxEnd <= intervals.get(i)[0])
                sections++;
            maxEnd = Math.max(maxEnd, intervals.get(i)[1]);
        }

        return sections;
    }
}