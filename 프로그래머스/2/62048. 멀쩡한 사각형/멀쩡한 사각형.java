class Solution {
    public long solution(int w, int h) {
        long W = w;
        long H = h;
        return W * H - (W + H - gcd(W, H));
    }

    long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
