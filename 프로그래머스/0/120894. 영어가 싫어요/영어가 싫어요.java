class Solution {
    public long solution(String numbers) {
        StringBuilder answer = new StringBuilder();
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder check = new StringBuilder();
        
        for(char c : numbers.toCharArray()) {
            check.append(c);
            for (int i = 0; i < number.length; i++) {
                 if (number[i].equals(check.toString())) {
                    answer.append(i);
                    check.setLength(0);
                     break;
                 }
            }
        }
        return Long.parseLong(answer.toString());
    }
}