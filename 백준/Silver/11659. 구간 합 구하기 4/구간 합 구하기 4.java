import java.io.IOException; // 입출력 작업 중 예외가 발생할 수 있음을 나타냄.
import java.io.BufferedReader; // 문자 입력 스트림에서 텍스트를 읽을 때 버퍼링을 제공. 효율적으로 읽기 위해 사용.
import java.io.InputStreamReader; // 바이트 스트림을 문자 스트림으로 변환.
import java.util.StringTokenizer; // 문자열을 구분자(delimiter)를 기준으로 분리.

// public : 접근 제어자 - public 키워드는 이 메서드가 어디서든 접근 가능하다는 것을 의미
public class Main {
    // void : 이 메서드가 값을 반환하지 않는다는 것을 의미
    // String[] args : 매개변수 - args는 명령 줄 인수를 저장하는 String 배열
    // throws IOException : 입출력 예외를 처리하지 않고 호출한 곳으로 전달.
    public static void main(String[] args) throws IOException {
        
    // 입력 준비 및 초기화
    BufferedReader bufferedReader =
        // System.in: 표준 입력 스트림(콘솔 입력).
        // BufferedReader: 효율적으로 문자, 배열, 행 등을 읽기 위해 사용.
        new BufferedReader (new InputStreamReader (System. in));
    StringTokenizer stringTokenizer =
        new StringTokenizer(bufferedReader.readLine());
    int suNo = Integer.parseInt(stringTokenizer. nextToken());
    int quizNo = Integer.parseInt(stringTokenizer.nextToken());
    
    // prefix sum 배열. S[i]는 첫 번째 요소부터 i번째 요소까지의 합을 저장. S 다른 이름 지정 가능.
    long[] S = new long[suNo + 1];
    stringTokenizer = new StringTokenizer(bufferedReader. readLine());
    for (int i = 1; i <= suNo; i++) {
        // 이전 합에 현재 요소를 더하여 현재까지의 합을 계산.
        S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
    }
    for (int q = 0; q < quizNo; q++) {
        stringTokenizer = new StringTokenizer (bufferedReader.readLine());
        int i = Integer.parseInt(stringTokenizer.nextToken());
        int j = Integer.parseInt(stringTokenizer.nextToken());
        System. out.println(S[j] - S[i - 1]);
    }
}
}
