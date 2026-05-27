public class MaxAlternatingSumSolution {
    public static void main(String[] args) {
        int[] A = { 4, 1, 2, 3, 9, 17, 7, 1, 1, 3 };

        System.out.println("The maximum alternating sum of A (S) is: " + solution(A));
    }

    public static int solution(int[] A) {
        // Check for null or empty array
        if (A == null || A.length == 0) {
            return 0;
        }

        long S = 0;
        long Modulo = 1000000000;

        boolean peaks = true; // Verify the peaks or troughs

        // Logic to find peaks and troughs
        for (int i = 0; i < A.length; i++) {

            if (peaks) {
                // Find peaks to add
                if (i == A.length - 1 || A[i] > A[i + 1]) {
                    S = (S + A[i]) % Modulo;
                    peaks = false;
                }
            } else {
                // Find troughs to subtract
                if (i < A.length - 1 && A[i] < A[i + 1]) {
                    S = (S - A[i] + Modulo) % Modulo;
                    peaks = true;
                }
            }
        }

        return (int) S;
    }
}