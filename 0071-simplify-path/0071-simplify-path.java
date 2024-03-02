class Solution {
    public String simplifyPath(String path) {
      String[] files = path.split("/");
      Stack<String> direction = new Stack<>();
      for(String s : files){
        if(!s.equals("..") && !s.equals("") && !s.equals(".")){
          direction.push(s);
        }else if(s.equals("..") && !direction.isEmpty()){
          direction.pop();
        }
      }
      List<String> newArr = new ArrayList<>(direction);
      StringBuilder sb = new StringBuilder();
      for(String s: newArr){
        sb.append("/" + s);
      }
      if(sb.length()==0)
        sb.append("/");
      
        return sb.toString();
    }
}

/*


*/