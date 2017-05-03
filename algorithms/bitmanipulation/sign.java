class sign {
    public static void main(String args[]) {
        int v = -2147483648; // if you remove the '-', the compiler will complain: number too large
        int result = v >> 31; // shifting 31 times reduces even the largest integer
        System.out.println(result);
    }
}