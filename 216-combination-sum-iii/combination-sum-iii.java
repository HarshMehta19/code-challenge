class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        recursion(k, list, new ArrayList<>(), n, 1);
        return list;
    }

    private void recursion(int k, List<List<Integer>> list, List<Integer> temp, int sum, int start) {
        if(temp.size() == k && sum == 0) {
            List<Integer> li = new ArrayList<>(temp);
            list.add(li);
            return;
        }

        for(int i=start;i<=9;i++) {
            temp.add(i);
            recursion(k, list, temp,sum-i,i+1);
            temp.remove(temp.size() - 1);
        }

    }
}