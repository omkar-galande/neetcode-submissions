class Solution {
    public void twoHelper(int f, int[] nums, List<List<Integer>> res) {

        int i = f + 1;
        int j = nums.length - 1;

        while (i < j) {

            int sum = nums[f] + nums[i] + nums[j];

            if (sum > 0) {
                j--;
            } 
            else if (sum < 0) {
                i++;
            } 
            else {
                res.add(Arrays.asList(nums[f], nums[i], nums[j]));

                // Skip duplicate left values
                while (i < j && nums[i] == nums[i + 1]) {
                    i++;
                }

                // Skip duplicate right values
                while (i < j && nums[j] == nums[j - 1]) {
                    j--;
                }

                i++;
                j--;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int f = 0; f < nums.length; f++) {

            if (nums[f] > 0) {
                break;
            }

            // Skip duplicate first values
            if (f > 0 && nums[f] == nums[f - 1]) {
                continue;
            }

            twoHelper(f, nums, res);
        }

        return res;
    }
}