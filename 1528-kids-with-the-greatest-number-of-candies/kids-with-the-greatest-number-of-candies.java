class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> list = new ArrayList<Boolean>();
        for(int candy : candies) {
            boolean res = (candy + extraCandies) >= max;
            list.add(res);
        }

        return list;
    }
}