public class BinaryGapSolution {

    public static void main(String[] args) {
        int N = 9;
        System.out.println("The binary representation of " + N + " is: " + Integer.toBinaryString(N));
        System.out.println("The binary gap for " + N + " is: " + solution(N));
    }

    public static int solution(int N) {

        // Step 1: Transfer to binary string
        String binaryString = Integer.toBinaryString(N);

        int maxGap = 0;
        int currentGap = 0;

        // Step 2: Loop through the binary string
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);

            if (c == '0') {
                currentGap++;
            } else if (c == '1') {
                if (currentGap > maxGap) {
                    maxGap = currentGap;
                }
                currentGap = 0;
            }
        }
        return maxGap;
    }
}