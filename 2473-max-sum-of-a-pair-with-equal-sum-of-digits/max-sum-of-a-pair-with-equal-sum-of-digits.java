class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int num: nums) {
            int copyNum = num;
            int sum = 0;
            while(copyNum != 0) {
                sum += copyNum % 10;
                copyNum = copyNum / 10;
            }

            map.putIfAbsent(sum, new ArrayList<>());

            map.get(sum).add(num);
        }

        int ans = -1;
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> list = entry.getValue();
            if(list.size() >= 2 ) {
                Collections.sort(list);
                ans = Math.max(ans, list.get(list.size() - 1) + list.get(list.size() - 2));
            }
        }

        return ans;
    }
}