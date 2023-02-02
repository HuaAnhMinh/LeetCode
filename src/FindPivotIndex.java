public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int[] left = new int[nums.length + 2];
        int[] right = new int[nums.length + 2];

        left[0] = 0;
        left[nums.length + 1] = 0;
        left[1] = nums[0];

        right[0] = 0;
        right[nums.length] = nums[nums.length - 1];
        right[nums.length + 1] = 0;

        for (int i = 2, j = right.length - 3; i < left.length - 1 && j >= 1; ++i, --j) {
            left[i] = left[i - 1] + nums[i - 1];
            right[j] = right[j + 1] + nums[j - 1];
        }

        for (int i = 1; i <= nums.length; ++i) {
            if (left[i - 1] == right[i + 1]) {
                return i - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, -1 };
        System.out.println(pivotIndex(nums));
    }
}
