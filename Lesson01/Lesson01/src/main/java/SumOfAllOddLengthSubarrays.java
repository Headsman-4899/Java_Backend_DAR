public class SumOfAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int result = 0;
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            result += ((i + 1) * (n - i) + 1) / 2 * arr[i];
        }
        return result;
    }
}
