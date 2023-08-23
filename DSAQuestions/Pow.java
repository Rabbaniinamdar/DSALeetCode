class myPowow {
    public static double myPow(double x, int n) {
        if (x == 1)
            return 1.0;

        double res = 1.0;
        long N = n;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        while (N > 0) {
            if (N % 2 == 1) {
                res *= x;
            }
            x *= x;
            N /= 2;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0, 3));
    }
}
