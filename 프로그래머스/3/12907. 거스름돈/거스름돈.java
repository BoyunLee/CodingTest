class Solution {
    static int answer = 0;
    public int solution(int n, int[] money) {
        //calculate(money.length-1,0,n,money);
        int[] dp=new int[n+1];
        
        dp[0]=1;
        for(int j=0;j<money.length;j++){
            for(int i=money[j];i<=n;i++){
                    dp[i]+=dp[i-money[j]];
            }
        }
        return dp[n];
    }
    public void calculate(int index, int sum, int n,int[] money){
        if(sum==n)
        {
            //System.out.println();
            answer++;
            return;
        }
        for(int i=index;i>=0;i--){
            if((sum+money[i])<=n){
                //System.out.println(money[i]);
                calculate(i, sum+money[i],n,money);
                
            }
        }
    }
}