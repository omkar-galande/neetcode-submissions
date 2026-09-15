class Solution {
    public int searchInsert(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            // Avoid overflow
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            else if (arr[mid] < target) {
                // Search right half
                start = mid + 1;
            }

            else {
                // Search left half
                end = mid - 1;
            }
        }

        return start;
    }
}