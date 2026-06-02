class chocolateFeast {

    public static void main(String[] args) {
        // t = 3 is mean we have 3 test cases
        int t = 3;

        int[][] testCases = {
                { 10, 2, 5 }, // Case 1: n = 10, c = 2, m = 5
                { 12, 3, 3 }, // Case 2: n = 12, c = 3, m = 3
                { 6, 2, 2 } // Case 3: n = 6, c = 2, m = 2
        };

        for (int i = 0; i < t; i++) {
            int n = testCases[i][0];
            int c = testCases[i][1];
            int m = testCases[i][2];

            int result = chocolateFeast(n, c, m);

            System.out.println("Result of this array is: " + result);
        }
    }

    public static int chocolateFeast(int n, int c, int m) {
        int initialBars = n / c;
        int totalEaten = initialBars;
        int wrappers = initialBars;

        while (wrappers >= m) {
            int newBars = wrappers / m;
            totalEaten += newBars;
            wrappers = newBars + (wrappers % m);
        }

        return totalEaten;
    }
}