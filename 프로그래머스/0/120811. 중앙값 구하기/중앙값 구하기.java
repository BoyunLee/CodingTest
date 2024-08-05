import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        int n = array.length / 2;
        answer = array[n];
        return answer;
    }
}