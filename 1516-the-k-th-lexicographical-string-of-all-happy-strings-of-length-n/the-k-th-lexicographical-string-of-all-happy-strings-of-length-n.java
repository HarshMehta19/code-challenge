class Solution {
    String result = "";
    int count = 0;

    public String getHappyString(int n, int k) {
        constructHappyStrings(n, k, new StringBuilder());
        if(count < k)
            return "";
        return result.toString();
    }

    public void constructHappyStrings(int n, int k, StringBuilder sb) {
        if(sb.length() == n)
        {
            count++;
            if(count == k)
            {
                result = sb.toString();
                return;
            }
        }

        int len = sb.length();
        if(len < n && count < k ){
            for(char c = 'a'; c<='c';c++){
                if(len == 0 || sb.charAt(len-1) != c){
                    sb.append(c);
                    constructHappyStrings(n, k, sb);
                    sb.deleteCharAt(len);
                }
            }
        }
    }
}