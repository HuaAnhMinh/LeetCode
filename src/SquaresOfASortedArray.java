public class SquaresOfASortedArray {
    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        int left = 0, right = nums.length - 1;
        int absolute;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                absolute = nums[right];
                --right;
            }
            else {
                absolute = nums[left];
                ++left;
            }
            res[i] = absolute * absolute;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,2};
        int[] res = sortedSquares(nums);
        for (int i: res) {
            System.out.print(i + " ");
        }
    }
}
