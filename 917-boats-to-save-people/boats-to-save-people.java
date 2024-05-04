class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // HashSet<Integer> set = new HashSet<>();
        int[] arr = new int[50001];
        for(int person : people) {
            arr[person]++;
        }
        int res = 0;
        for(int person : people) {
            if(arr[person] > 0) {
                arr[person]--;
                int i = limit - person;
                if(i == 0) {
                    res++;
                    continue;
                }
                boolean isMatchFound = false;
                while( i > 0) {
                    if(arr[i] > 0) {
                        arr[i]--;
                        res++;
                        isMatchFound = true;
                        break;
                    } else
                        i--;
                }
                if(isMatchFound == false)
                    res++;

            }
        }

        return res;

    }
}