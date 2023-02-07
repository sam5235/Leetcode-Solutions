class Solution {
    public boolean isRobotBounded(String instructions) {
        if (instructions.length() == 0)
            return false;
        int x = 0;
        int y = 0; 
        String drn = "N"; 
        
        for (int i=0;i<instructions.length();i++) 
        {
            if (instructions.charAt(i) == 'G') {
                if (drn.equals("N"))
                    y += 1;
                else if (drn.equals("S"))
                    y -= 1;
                else if(drn.equals("E"))
                    x += 1;
                else
                    x -= 1;
            }
            else if (instructions.charAt(i) == 'L') {
                if (drn.equals("N"))
                    drn = "W";
                else if (drn.equals("W"))
                    drn = "S";
                else if (drn.equals("S"))
                    drn = "E";
                else drn = "N";
            }
            else if (instructions.charAt(i) == 'R') {
                if (drn.equals("N"))
                    drn = "E";
                else if (drn.equals("E"))
                    drn = "S";
                else if (drn.equals("S"))
                    drn = "W";
                else drn = "N";
            }
        }
        if (x == 0 && y == 0)
            return true;
        if (drn.equals("N"))
            return false;
        return true;
    }
}