public class Palindrome {
    public static void main(String[] args) {
        int[] array = { 1, 2, 2, 1 };
        System.out.println("Palindrome results: " + isPalindrome(array));
    }

    // Support Method
    public static boolean isPalindrome(int[] number) {

        // Check array null -> False OR length <= 1 -> True
        if (number == null || number.length <= 1) {
            return number != null;
        }

        // Instead
        // if (number == null) {
        // return false;
        // }
        // if (number.length <= 1) {
        // return true;
        // }

        // Set pointers both side
        int left = 0;
        int right = number.length - 1;

        // Run left pointer and right pointer until they meet
        while (left < right) {
            if (number[left] != number[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}