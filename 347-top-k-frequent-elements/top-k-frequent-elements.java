class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer>[] arrList = new ArrayList[nums.length + 1];

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int i : map.keySet()) {
            int num = map.get(i);

            if(arrList[num] == null)
                arrList[num] = new ArrayList<>();
            
            arrList[num].add(i);
        }

        int[] result = new int[k];
        int count = 0;

        for(int i = nums.length;i>= 0;i--) {
            if(arrList[i] != null) {
                for(int num : arrList[i]){
                    result[count++] = num;
                    if(count == k) return result;
                }
            }
        }
        return result;

        
    }
}