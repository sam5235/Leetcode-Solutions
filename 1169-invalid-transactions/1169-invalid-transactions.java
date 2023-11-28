class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> invalids = new ArrayList<>();
        int n = transactions.length;
        HashMap<Integer, HashMap<String, HashSet<String>>> timeNnameNcity = new HashMap<>();
        // HashMap<String, HashSet<String>> nameNcity = new HashMap<>();
        for(int i=0; i<n; i++){
            String[] content = transactions[i].split(",");
            String name = content[0];
            int time = Integer.parseInt(content[1]);
            int amount = Integer.parseInt(content[2]);
            String city = content[3];
            
            HashMap<String, HashSet<String>> nameNcity = timeNnameNcity.getOrDefault(time, new HashMap<>());
            HashSet<String> cit = nameNcity.getOrDefault(name, new HashSet<>());
            cit.add(city);
            nameNcity.put(name, cit);
            timeNnameNcity.put(time, nameNcity);
            
        }
        // System.out.println(timeNnameNcity);
  
        for(int i=0; i<n; i++){
            String[] content = transactions[i].split(",");
            String name = content[0];
            int time = Integer.parseInt(content[1]);
            int amount = Integer.parseInt(content[2]);
            String city = content[3];
            
            for(int t=time-60; t<=time+60; t++){
                if(amount>1000){
                    invalids.add(transactions[i]);
                    break;
                }
                
                if(timeNnameNcity.containsKey(t)){
                    HashMap<String, HashSet<String>> curr = timeNnameNcity.get(t);
                    if(curr.containsKey(name)&&(curr.get(name).size()>1|| !curr.get(name).iterator().next().equals(city))){
                        invalids.add(transactions[i]);
                        break;
                    }
                }
            }
        }
        return invalids;
    }
}
