class Solution {
    public boolean sumGame(String num) {

        int firsthalf = 0;
        int secondhalf = 0;
        int firstQ = 0;
        int secondQ = 0;

        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) == '?') {
                firstQ++;
            } else {
                firsthalf += num.charAt(i) - '0';
            }
        }

        for (int i = num.length() / 2; i < num.length(); i++) {
            if (num.charAt(i) == '?') {
                secondQ++;
            } else {
                secondhalf += num.charAt(i) - '0';
            }
        }

        int diff = firsthalf - secondhalf;
        int q = firstQ - secondQ;

        if (q % 2 != 0) {
            return true;
        }

        return diff != -(q / 2) * 9;
    }
}