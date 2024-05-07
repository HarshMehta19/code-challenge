class Solution {
    public int[] asteroidCollision(int[] asteroids) {
    //     Stack<Integer> stack = new Stack<>();
    //     for(int ast : asteroids) {
    //         boolean isPositive = ast > 0;
    //         if(!stack.isEmpty()) {
    //             int topItem = stack.pop();
    //             if((topItem > 0) == isPositive) {
    //                 stack.push(topItem);
    //                 stack.push(ast);
    //             } else {
                    
                    
    //                 if(Math.abs(topItem) > Math.abs(ast)) {
    //                     stack.push(topItem);
    //                 } else if(Math.abs(topItem) < Math.abs(ast)) {
    //                     while(!stack.isEmpty()) {
                            
    //                     }
    //                     stack.push(ast);
    //                 }
    //             }
    //         } else {
    //             stack.push(ast);
    //         }
    //     }

    //     int[] res = new int[stack.size()];
    //     for(int i=stack.size()-1;i>=0;i--) {
    //         res[i] = stack.pop();
    //     }
    //     return res;
        int n = asteroids.length;
        int j = 0;

        for(int i=0;i<n;i++) {
            int asteroid = asteroids[i];
            while(j>0 && asteroids[j-1]>0 && asteroid < 0 && asteroids[j-1] < Math.abs(asteroid)) {
                j--;
            }

            if(j==0 || asteroid > 0 || asteroids[j-1]<0)
                asteroids[j++] = asteroid;
            else if(asteroids[j-1] == Math.abs(asteroid))
                j--;
        }

        int[] result = new int[j];
        System.arraycopy(asteroids, 0, result, 0, j);

        return result;
    }
}