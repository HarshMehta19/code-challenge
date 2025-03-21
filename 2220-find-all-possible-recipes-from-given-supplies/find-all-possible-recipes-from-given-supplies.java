class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<supplies.length; i++) 
            set.add(supplies[i]);

        boolean ans = true, shouldContinue = true;
        List<String> list = new ArrayList<>();
        while(shouldContinue) {
            shouldContinue = false;
            for(int i=0;i<recipes.length;i++) {
                if(set.contains(recipes[i])) continue;
                ans = true;
                for(String ingredient : ingredients.get(i)) {
                    if(!set.contains(ingredient)){
                        ans = false;
                        break;
                    }
                }
                if(ans == true) {
                    shouldContinue = true;
                    set.add(recipes[i]);
                    list.add(recipes[i]);
                }
            }
        }
        return list;
    }
}