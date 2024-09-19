class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return backtrack(0, expression.length() - 1, expression);
    }

    private List<Integer> backtrack(int start, int end, String expression) {
        List<Integer> res = new ArrayList<>();
        for(int i=start;i<=end;i++){
            char op = expression.charAt(i);
            if(op == '+' || op == '-' || op == '*') {
                List<Integer> num1 = backtrack(start, i-1, expression);
                List<Integer> num2 = backtrack(i+1, end, expression);

                for(int n1: num1){
                    for(int n2: num2) {
                        res.add(performOperation(n1, n2, op));
                    }
                }
            }

        }

        if(res.size() == 0) 
        {
            res.add(Integer.parseInt(expression.substring(start, end+1)));
        }
        return res;
    }

    private int performOperation(int num1, int num2, char operator) {
        int result = 0;
        switch(operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
        }
        return result;
    }
}