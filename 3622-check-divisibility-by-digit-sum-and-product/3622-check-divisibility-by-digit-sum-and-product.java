class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int n2 = n;
        long sum = 0;
        long product = 1;

        while(n>0){
            int dig = n % 10;

            sum +=dig;
            n = n / 10;
        }

        while(n2>0){
            int dig = n2 % 10;

            product*=dig;
            n2 = n2 / 10;
        }

        long total = sum + product;

        if(temp % total == 0 ){
            return true;
        }else{
            return false;
        }
    }
}