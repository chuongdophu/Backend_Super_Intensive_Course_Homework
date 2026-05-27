public class theFirstCoveringPrefix {
    public static void main(String[] args) {
        int[] A = { 2, 2, 1, 0, 1 };
        System.out.println("The first covering prefix is: " + solution(A));

    }

    public static int solution(int[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }
        int N = A.length;
        boolean[] visited = new boolean[N];
        int lastNewValueIndex = 0;

        for (int i = 0; i < N; i++) {
            int currentValue = A[i];

            if (!visited[currentValue]) {
                visited[currentValue] = true;
                lastNewValueIndex = i;
            }
        }
        return lastNewValueIndex;
    }
}