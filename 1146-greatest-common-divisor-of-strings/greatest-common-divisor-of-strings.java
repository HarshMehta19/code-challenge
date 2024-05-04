class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2 + str1))
            return "";
        // int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0,gcd(str1.length(), str2.length()));
        // int n = Math.min(str1.length(), str2.length());

        // StringBuilder sb = new StringBuilder();
        // int i =0;
        // while(i<n) {
        //     if(str1.charAt(i) != str2.charAt(i) || sb.indexOf(new Character(str1.charAt(i)).toString()) != -1)
        //         break;
        //     sb.append(str1.charAt(i));
        //     i++;
        // }
        // return sb.toString();
    }

    private int gcd(int l1, int l2) {
        if (l2 == 0){
            return l1;
        }else{ 
            return gcd(l2,l1%l2);
        }
    }
}