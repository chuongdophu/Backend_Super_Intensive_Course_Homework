public class countingPair {
    public static void main(String[] args) {
        int[] A = { 2, 1, 5, -6, 9 };
        System.out.println("The result: " + solution(A));
    }

    public static int solution(int[] A) {
        if (A == null || A.length < 2) {
            return 0;
        }

        long evenNumTotal = 0;
        long oddNumTotal = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                evenNumTotal++;
            } else {
                oddNumTotal++;
            }
        }

        long evenPairs = (evenNumTotal * (evenNumTotal - 1)) / 2;
        long oddPairs = (oddNumTotal * (oddNumTotal - 1)) / 2;

        long totalPairs = evenPairs + oddPairs;

        if (totalPairs > 1000000000) {
            return -1;
        }

        return (int) totalPairs;
    }
}