import java.util.*;

public class SMSmessages {
    public static void main(String[] args) {
        SMSmessages solver = new SMSmessages();
        String S = "A bright message for our future, it is a very good day to be alive and to be happy";
        int K = 14;

        System.out.println(solver.solution(S, K));
    }

    public int solution(String S, int K) {
        String[] words = S.split(" ");

        int smsCount = 1;
        int currentLength = 0;

        for (String word : words) {
            int wordLength = word.length();

            if (wordLength > K) {
                return -1;
            }

            if (currentLength == 0) {
                currentLength = wordLength;
            } else {
                if (currentLength + 1 + wordLength <= K) {
                    currentLength += 1 + wordLength;
                } else {
                    smsCount++;
                    currentLength = wordLength;
                }
            }
        }

        return smsCount;
    }
}