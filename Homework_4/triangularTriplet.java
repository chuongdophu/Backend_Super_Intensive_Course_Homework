import java.util.Arrays;

public class triangularTriplet {
    public static void main(String[] args) {
        int[] A = { 10, 2, 5, 1, 8, 20 };
        System.out.println("The result is: " + solution(A));
    }

    public static int solution(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int N = A.length;

        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            if ((long) A[i] + A[i + 1] > A[i + 2]) {
                return 1;
            }
        }
        return 0;
    }
}
