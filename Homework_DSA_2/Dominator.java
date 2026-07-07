public class Dominator {

    public static void main(String[] args) {
        int[] array = { 7, 7, 1, 7, 7, 5, 7, 2, 7, 3 };
        int result = Dominator.solution(array);

        System.out.println("Dominator index result is: " + result);
    }

    public static int solution(int[] A) {
        int n = A.length;

        if (n == 0) {
            return -1;
        }

        int candidate = 0;
        int count = 0;

        for (int num : A) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        if (count == 0) {
            return -1;
        }

        int actualCount = 0;
        int dominatorIndex = -1;

        for (int i = 0; i < n; i++) {
            if (A[i] == candidate) {
                actualCount++;
                dominatorIndex = i;
            }
        }

        if (actualCount > n / 2) {
            return dominatorIndex;
        }

        return -1;
    }
}