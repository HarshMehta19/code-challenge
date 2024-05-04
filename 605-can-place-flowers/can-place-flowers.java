class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;
        int i =1;
        if(flowerbed.length >= 2) {
            if(flowerbed[0] == flowerbed[1] && flowerbed[0] == 0) {
                flowerbed[0] = 1;
                n--;
            }
        } else if(flowerbed.length == 1 && flowerbed[0] == 0) {
            n--;
        }
        while(i < flowerbed.length && n > 0) {
            if(i == flowerbed.length - 1) {
                if(flowerbed[i] != 1 && flowerbed[i-1] != 1) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else if(flowerbed[i] != 1 && flowerbed[i-1] != 1 && flowerbed[i+1] != 1) {
                flowerbed[i] = 1;
                n--;
            }
            
            i++;
        }

        return n == 0;
    }
}