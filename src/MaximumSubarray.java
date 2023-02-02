public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
//        // O(N) Kadane's Algorithm
//        int curSum = nums[0], maxSum = nums[0];
//        for (int i = 1; i < nums.length; ++i) {
//            curSum = Math.max(nums[i], curSum + nums[i]);
//            maxSum = Math.max(curSum, maxSum);
//        }
//        return maxSum;

        // O(NLogN) Divide & Conquer
        return findBestSubArray(nums, 0, nums.length - 1);
    }

    private static int findBestSubArray(int[] nums, int left, int right) {
        if (left > right) {
            return Integer.MIN_VALUE;
        }

        int mid = Math.floorDiv(left + right, 2);
        int curSum = 0;
        int bestLeftSum = 0, bestRightSum = 0;
        for (int i = mid - 1; i >= 0; --i) {
            curSum += nums[i];
            bestLeftSum = Math.max(curSum, bestLeftSum);
        }

        curSum = 0;
        for (int i = mid + 1; i <= right; ++i) {
            curSum += nums[i];
            bestRightSum = Math.max(curSum, bestRightSum);
        }

        int bestCombinedSum = bestLeftSum + nums[mid] + bestRightSum;

        int leftHalf = findBestSubArray(nums, left, mid - 1);
        int rightHalf = findBestSubArray(nums, mid + 1, right);

        return Math.max(bestCombinedSum, Math.max(leftHalf, rightHalf));
    }
    public static void main(String[] args) {
        int[] nums = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(nums));
    }
}