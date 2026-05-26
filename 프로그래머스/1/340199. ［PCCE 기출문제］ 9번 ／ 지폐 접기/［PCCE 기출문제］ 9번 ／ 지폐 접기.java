class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int maxWallet = Math.max(wallet[0], wallet[1]);
        int minWallet = Math.min(wallet[0], wallet[1]);

        int maxBill = Math.max(bill[0], bill[1]);
        int minBill = Math.min(bill[0], bill[1]);
        
        while(true) {
            
            if(maxBill<=maxWallet && minBill<=minWallet) {
                break;
            }
            
            int folded = maxBill/2;
            maxBill = Math.max(folded, minBill);
            minBill = Math.min(folded, minBill);
            
            answer++;
        }
        return answer;
    }
}