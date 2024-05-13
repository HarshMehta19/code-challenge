class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] keys = new int[rooms.size()];
        Arrays.fill(keys, -1);
        keys[0]++;

        for(int key: rooms.get(0)){
            goToKeyRoom(key, rooms, keys);
        }
        // for(int j=0;j<rooms.get(0).size();j++) {
        //     goToKeyRoom(rooms.get(0).get(j), rooms, keys);
        // }

        for(int i=1;i<rooms.size();i++) {
            if(keys[i] == -1) return false;
        }
        return true;
    }

    private void goToKeyRoom(int room, List<List<Integer>> rooms, int[] keys) {
        if(keys[room] > 0) return;
        keys[room]++;
        for(int key : rooms.get(room)) {
                goToKeyRoom(key, rooms, keys);
        }
    }
}