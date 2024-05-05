class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] numOfOccur = new int[2001];
        for(int num : arr) {
            numOfOccur[1000 + num]++;
        }
        boolean[] countTrack = new boolean[1001];
        for(int num: arr) {
            int count = numOfOccur[1000+num];
            numOfOccur[1000+num] = 0;
            if(count > 0) {
                if(countTrack[count] == true) return false;
                else countTrack[count] = true;
            }
        }
        return true;
        // Map<Integer, Integer> map = new HashMap<>();

        // for(int num : arr) {
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        // Set<Integer> set = new HashSet<>();
        // for(int x : map.values()) {
        //     set.add(x);
        // }

        // return map.size() == set.size();

    }
}