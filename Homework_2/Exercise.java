public class Exercise {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 5 };
        checkStatistics(nums);
    }

    // Support Method
    static void checkStatistics(int[] nums) {

        // Check array
        if (nums == null || nums.length == 0) {
            System.out.println("Mảng không hợp lệ!");
            return;
        }

        // Set max, min, sum
        int max = nums[0];
        int min = nums[0];
        int sum = 0;

        // Find max, min, count sum
        for (int x : nums) {
            if (x > max) {
                max = x;
            } else if (x < min) {
                min = x;
            }
            sum = sum + x;
        }

        // Count average
        double average = (double) sum / nums.length;

        // Print result
        System.out.printf("Output: %d, %d, %.2f", max, min, average);
    }
}