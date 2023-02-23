class Solution {
    Map<String,List<Integer>> mpp = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String expression) {
        int len = expression.length();
        List<Integer> result = new ArrayList<>();

        if(mpp.containsKey(expression)) return mpp.get(expression);
        
        if(expression.length()==1){
            result.add(Integer.parseInt(expression));
            return result;
        }

        for(int i=0;i<len;i++){
            char symbol = expression.charAt(i);
            if(isOperator(symbol)) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                for(int l: left){
                    for(int r: right){
                        result.add(calc(l,symbol,r));
                    }
                }
            }
        }
        
        if(result.isEmpty()){
            result.add(Integer.parseInt(expression));
            mpp.put(expression,result);
            return result;
        }

        mpp.put(expression,result);
        return result;
    }

    public boolean isOperator(char op){
        return switch (op) {
            case '-', '+', '*' -> true;
            default -> false;
        };
    }

    public int calc(int l, char c, int r){
        return switch (c){
            case '+' -> l+r;
            case '-' -> l-r;
            case '*' -> l*r;
            default -> -1;
        };
    }
}