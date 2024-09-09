class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int a = 0;
        for(int i=0; i<array.length; i++) {
            while(array[i] != 0) {
                a = array[i] % 10;
                if(a == 7) {
                    answer++;
                }
                array[i] = array[i] / 10;
            }
        }
        return answer;
    }
}