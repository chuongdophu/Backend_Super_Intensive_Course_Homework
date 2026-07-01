import java.util.*;

public class fibonacciFrog {
    public static void main(String[] args) {
        int[] A = { 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        System.out.println("The minimum number of jumps: " + solution(A));
    }

    public static int solution(int[] A) {
        int N = A.length;

        ArrayList<Integer> fibonacci = new ArrayList<>();
        int f1 = 1, f2 = 2;
        fibonacci.add(f1);
        fibonacci.add(f2);
        while (true) {
            int nextFibonacci = f1 + f2;
            if (nextFibonacci > N + 1)
                break;
            fibonacci.add(nextFibonacci);
            f1 = f2;
            f2 = nextFibonacci;
        }

        Queue<int[]> queue = new LinkedList<>();

        boolean[] visited = new boolean[N + 1];

        queue.add(new int[] { -1, 0 });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentPosition = current[0];
            int currentJumps = current[1];

            for (int fib : fibonacci) {
                int nextPosition = currentPosition + fib;

                if (nextPosition == N) {
                    return currentJumps + 1;
                }

                if (nextPosition >= 0 && nextPosition < N && A[nextPosition] == 1 && !visited[nextPosition]) {
                    visited[nextPosition] = true;
                    queue.add(new int[] { nextPosition, currentJumps + 1 });
                }
            }
        }

        return -1;
    }

}