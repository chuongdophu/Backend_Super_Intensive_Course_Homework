public class PitDepth {

    public static void main(String[] args) {

        int[] array = { 0, 1, 3, -2, 0, 1, 0, -3, 2, 3 };
        int result = PitDepth.solution(array);

        System.out.println("Max depth result is: " + result);
    }

    public static int solution(int[] A) {
        int n = A.length;
        int maxDepth = -1;
        int P = -1;
        int Q = -1;

        for (int i = 0; i < n - 1; i++) {
            if (A[i] > A[i + 1] && P == -1) {
                P = i;
            } else if (A[i] > A[i + 1] && Q != -1) {
                int R = i;
                maxDepth = Math.max(maxDepth, Math.min(A[P] - A[Q], A[R] - A[Q]));
                P = R;
                Q = -1;
            } else if (A[i] < A[i + 1] && P != -1 && Q == -1) {
                Q = i;
            } else if (A[i] == A[i + 1]) {
                if (P != -1 && Q != -1) {
                    int R = i;
                    maxDepth = Math.max(maxDepth, Math.min(A[P] - A[Q], A[R] - A[Q]));
                }
                P = -1;
                Q = -1;
            }
        }

        if (P != -1 && Q != -1) {
            int R = n - 1;
            maxDepth = Math.max(maxDepth, Math.min(A[P] - A[Q], A[R] - A[Q]));
        }

        return maxDepth;
    }

}