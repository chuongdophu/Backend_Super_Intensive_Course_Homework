public class moveZerosToEnds {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 3, 4, 5 };
        moveZeroes(arr);
        System.out.print("The results: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void moveZeroes(int[] nums) {
        int holderIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[holderIndex] = nums[i];
                holderIndex++;
            }
        }
        for (int i = holderIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}