class myPowow {
    public static double myPow(double x, int n) {
        if (x == 1)
            return 1.0;

        double res = 1.0;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        while (n > 0) {
            if (n % 2 == 1) {
                res *= x;
            }
            x *= x;
            n /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0, 3));
    }
}
