public class NumberOfStepsToReduceANumberToZero {
    public int numberOfSteps(int num) {
        int cnt = 0;

        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
                cnt++;
            }
            if (num % 2 == 1) {
                num = num - 1;
                cnt++;
            }
        }

        return cnt;
    }
}
