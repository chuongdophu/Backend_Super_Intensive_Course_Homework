import java.util.Arrays;

public class TicketSolver {
    public static void main(String[] args) {
        int totalDays = 30;

        int[] dates = { 1, 2, 4, 5, 7, 29, 30 }; // result: 11

        // int[] dates = { 10, 5, 8, 1, 7, 9, 6 }; // result: 9

        // int[] dates = { 30, 29, 28, 27, 26, 25, 24 }; // result: 7

        // Test Case: 3 travel days within a 1 year (totalDays = 365)
        // int totalDays = 365;
        // int[] dates = { 10, 150, 360 }; // result: 6

        int result = buyTickets(dates, totalDays);

        System.out.println("Minimum cost: $" + result);

    }

    public static int buyTickets(int[] dates, int totalDays) {
        int[] dayMap = new int[totalDays + 1];
        int[] dp = new int[totalDays + 1];

        for (int date : dates) {
            if (date <= totalDays) {
                dayMap[date] = 1;
            }
        }

        for (int i = 1; i <= totalDays; i++) {
            if (dayMap[i] == 0) {
                dp[i] = dp[i - 1];
                continue;
            }

            int option1 = dp[i - 1] + 2;
            int option2 = dp[Math.max(0, i - 7)] + 7;
            int option3 = dp[Math.max(0, i - 30)] + 25;

            dp[i] = Math.min(option1, Math.min(option2, option3));
        }

        return dp[totalDays];

        // Arrays.sort(dates);
        // int[] dp = new int[totalDays + 1];
        // int idx = 0;

        // for (int i = 1; i <= totalDays; i++) {
        // if (idx < dates.length && i == dates[idx]) {
        // int option1 = dp[i - 1] + 2;
        // int option2 = dp[Math.max(0, i - 7)] + 7;
        // int option3 = dp[Math.max(0, i - 30)] + 25;

        // dp[i] = Math.min(option1, Math.min(option2, option3));
        // idx++;

        // while (idx < dates.length && dates[idx] == i) {
        // idx++;
        // }
        // } else {
        // dp[i] = dp[i - 1];
        // }
        // }

        // return dp[totalDays];
    }
}