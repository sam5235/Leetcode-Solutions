class Solution {
	public int maxCoins(int[] nums) {
		int l= nums.length;
		int[] arr = new int[l+2];

		for(int i=0;i<nums.length;i++)arr[i+1]=nums[i];

		arr[0]=arr[l+1]=1;
		int[][] dp = new int[nums.length+2][nums.length+2];

		for(int i=l;i>=1;i--){
			for(int j=1;j<=l;j++){
				if(i>j) continue;
				int max=(int)-1e9;
				for(int k=i;k<=j;k++){
					int cost= (arr[i-1]*arr[k]*arr[j+1])+dp[i][k-1]+dp[k+1][j];
					max=Math.max(max,cost);
				} 
				dp[i][j]=max;
			}
		}
		return dp[1][l];
	}
}
