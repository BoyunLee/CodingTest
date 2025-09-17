import java.util.*;

class Solution {
    static Set<Integer> result;
    static String[] number;
    static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        number = numbers.split("");
        result = new HashSet<Integer>();
        visited = new boolean[number.length];
        
        dfs("");
        
        for(int r:result) {
            if(isPrime(r)) {
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(String current) {
        if(!current.equals("")) {
            result.add(Integer.parseInt(current));
        }
        for(int i=0; i<number.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(current+number[i]);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }
        for(int i=2; i*i<=num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}