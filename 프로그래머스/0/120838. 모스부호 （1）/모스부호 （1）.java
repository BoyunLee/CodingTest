import java.util.*;

class Solution {
    public String solution(String letter) {
        Map<String, Character> morseToChar = new HashMap<>();
        morseToChar.put(".-", 'a');
        morseToChar.put("-...", 'b');
        morseToChar.put("-.-.", 'c');
        morseToChar.put("-..", 'd');
        morseToChar.put(".", 'e');
        morseToChar.put("..-.", 'f');
        morseToChar.put("--.", 'g');
        morseToChar.put("....", 'h');
        morseToChar.put("..", 'i');
        morseToChar.put(".---", 'j');
        morseToChar.put("-.-", 'k');
        morseToChar.put(".-..", 'l');
        morseToChar.put("--", 'm');
        morseToChar.put("-.", 'n');
        morseToChar.put("---", 'o');
        morseToChar.put(".--.", 'p');
        morseToChar.put("--.-", 'q');
        morseToChar.put(".-.", 'r');
        morseToChar.put("...", 's');
        morseToChar.put("-", 't');
        morseToChar.put("..-", 'u');
        morseToChar.put("...-", 'v');
        morseToChar.put(".--", 'w');
        morseToChar.put("-..-", 'x');
        morseToChar.put("-.--", 'y');
        morseToChar.put("--..", 'z');

        // 입력된 모스 부호 문자열을 단어별로 나누기
        String[] morseLetters = letter.split(" ");
        
        StringBuilder answer = new StringBuilder();
        
        // 각 모스 부호를 문자로 변환하고 결과에 추가
        for (String morseLetter : morseLetters) {
            if (morseToChar.containsKey(morseLetter)) {
                answer.append(morseToChar.get(morseLetter));
            }
        }

        return answer.toString();
    }
}