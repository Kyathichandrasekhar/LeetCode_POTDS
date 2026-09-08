class Solution {
    public int[] closestDivisors(int num) {
        int Fnum = num + 1;
        int Snum = num + 2;

        int divisor1 = 0;
        int divisor2 = 0;

        for (int i = (int)Math.sqrt(Fnum); i >= 1; i--) {
            if (Fnum % i == 0) {
                divisor1 = i;
                divisor2 = Fnum / i;
                break;
            }
        }

        int divisor3 = 0;
        int divisor4 = 0;

        for (int i = (int)Math.sqrt(Snum); i >= 1; i--) {
            if (Snum % i == 0) {
                divisor3 = i;
                divisor4 = Snum / i;
                break;
            }
        }

        if (Math.abs(divisor1 - divisor2) < Math.abs(divisor3 - divisor4)) {
            return new int[]{divisor1, divisor2};
        } else {
            return new int[]{divisor3, divisor4};
        }
    }
}