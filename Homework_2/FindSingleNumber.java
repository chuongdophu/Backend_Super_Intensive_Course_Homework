public class FindSingleNumber {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 2, 3, 1, 4 };
        System.out.println("The single number is: " + findSingleNumber(nums));
    }

    // Support Method
    public static int findSingleNumber(int[] nums) {
        int singleNumber = 0;
        for (int x : nums) {
            singleNumber = singleNumber ^ x; // XOR operation
        }
        return singleNumber;
    }
}