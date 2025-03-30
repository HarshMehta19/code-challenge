class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastPos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastPos.put(s.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>();

        int size = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            size++;

            end = Math.max(end, lastPos.get(s.charAt(i)));
            if (end == i) {
                result.add(size);
                size = 0;
            }
        }

        return result;
    }
}