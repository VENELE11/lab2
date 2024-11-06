import java.util.Arrays;

/**
 * @description:
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。
 *
 * 由于答案可能很大，请将结果对 109 + 7 取余后返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,5,6,7], target = 9
 * 输出：4
 * 解释：有 4 个子序列满足该条件。
 * [3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
 * [3,5] -> (3 + 5 <= 9)
 * [3,5,6] -> (3 + 6 <= 9)
 * [3,6] -> (3 + 6 <= 9)
 * 示例 2：
 *
 * 输入：nums = [3,3,6,8], target = 10
 * 输出：6
 * 解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
 * [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
 * 示例 3：
 *
 * 输入：nums = [2,3,3,4,6,7], target = 12
 * 输出：61
 * 解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
 * 有效序列总数为（63 - 2 = 61）
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 1 <= target <= 106
 *
 */
import java.util.Arrays;
// 这是PR的测试
class Solution5 {
    static final int P = 1000000007; // 模数
    static final int MAX_N = 100005;

    int[] f = new int[MAX_N]; // 存储 2 的幂次结果

    public int numSubseq(int[] nums, int target) {
        // 预处理 2 的幂次
        pretreatment();

        // 将数组排序
        Arrays.sort(nums);

        int ans = 0;
        int left = 0, right = nums.length - 1;

        // 双指针遍历
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // 从 left 到 right 的子序列数为 f[right - left]
                ans = (ans + f[right - left]) % P;
                left++; // 移动左指针，扩大子序列范围
            } else {
                right--; // 移动右指针，缩小最大值
            }
        }

        return ans;
    }

    // 计算 2 的幂次
    public void pretreatment() {
        f[0] = 1;
        for (int i = 1; i < MAX_N; ++i) {
            f[i] = (f[i - 1] * 2) % P;
        }
    }
}