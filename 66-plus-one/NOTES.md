int n= digits.length;
if(digits[n - 1] < 9){
digits[n - 1]++;
return digits;
}
int[] ans = new int[n+1];
for(int i = 1; i < ans.length; i++){
ans[i] = digits[i - 1];
}
int i = ans.length - 1;
while(i >= 0){
if(i > 0 && digits[i -  1] == 9){
ans[i] = 0;
}else {
ans[i]++;
break;
}
i--;
}
if(ans[0] == 0){
for(int j = 0; j < n; j++) digits[j] = ans[j + 1];
return digits;
}
return ans;``