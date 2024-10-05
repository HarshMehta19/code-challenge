class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int cnt = n1, left = 0;
        int[] arr = new int[26];
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        
        for(char c : s1Arr) {
            ++arr[c - 'a'];
        }
        for(int right = 0; right < n2; ++right) {
            if(arr[s2Arr[right] - 'a']-- >0) {
                cnt--;
            }
            while(cnt == 0) {
                if(right - left + 1 == n1)
                    return true;
                if(++arr[s2Arr[left++] - 'a'] > 0) {
                    cnt++;
                }
            }
        }
        return false;
    }
}