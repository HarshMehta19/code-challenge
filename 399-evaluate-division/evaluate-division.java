class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        // String u, v;

        for(int i=0;i<equations.size();i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1/values[i]);
        }
        double[] result = new double[queries.size()];

        for(int i=0;i<queries.size();i++) {
            result[i] = getResult(queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>(), graph);

        }
        return result;
        

        
    }

    double getResult(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {
        if(!graph.containsKey(start)) return -1.0;
        if(!graph.containsKey(end)) return -1.0;

        if(graph.get(start).containsKey(end))
            return graph.get(start).get(end);

        visited.add(start);
        for(Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
            if(!visited.contains(neighbour.getKey())) {
                double productWeight = getResult(neighbour.getKey(), end, visited, graph);
                if(productWeight != -1.0)
                    return neighbour.getValue() * productWeight;
            }
        }
        return -1.0;
    }
}