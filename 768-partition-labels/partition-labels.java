class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastPos = new int[26];
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            lastPos[arr[i] - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();

        int size = 0, end = 0;
        for (int i = 0; i < arr.length; i++) {
            size++;

            end = Math.max(end, lastPos[arr[i] - 'a']);
            if (end == i) {
                result.add(size);
                size = 0;
            }
        }

        return result;
    }
}