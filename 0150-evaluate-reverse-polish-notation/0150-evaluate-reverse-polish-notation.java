class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> rpn = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(!isOperator(tokens[i])){
                rpn.push(tokens[i]);
            }else if(tokens[i].equals("+")){
                int op = Integer.parseInt(rpn.pop()) +Integer.parseInt(rpn.pop());
                rpn.push(Integer.toString(op));
            } else if(tokens[i].equals("-")){
                 int first = Integer.parseInt(rpn.pop());
                int op = Integer.parseInt(rpn.pop()) - first;
                rpn.push(Integer.toString(op));
            }
             else if (tokens[i].equals("*")){
                int op = Integer.parseInt(rpn.pop()) *Integer.parseInt(rpn.pop());
                rpn.push(Integer.toString(op));
             }else if(tokens[i].equals("/")){
                  int first = Integer.parseInt(rpn.pop());
                int op = Integer.parseInt(rpn.pop()) /first;
                rpn.push(Integer.toString(op));
             }
        }
        return Integer.parseInt(rpn.pop());
        }

    public boolean isOperator(String token) {

        return (token.equals("*") || token.equals("/") || token.equals("-") || token.equals("+"));
  
    }
}