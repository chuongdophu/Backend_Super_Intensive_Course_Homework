
public class removeDuplicateFromSortedArray {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        int arrayResults = removeDuplicates(nums);
        System.out.print("Array after removing duplicates: [");
        for (int i = 0; i < arrayResults; i++) {
            System.out.print(nums[i]);
            if (i < arrayResults - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int removeDuplicates(int[] nums) {
        int holderIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[holderIndex] = nums[i];
                holderIndex++;
            }
        }
        return holderIndex;

    }

}
