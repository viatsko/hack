class Solution {
    private int computeOverlapArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x = Math.max(A, E);
        int y = Math.max(B, F);
        int width = Math.min(C, G) - x;
        int height = Math.min(D, H) - y;
        return width * height;
    }

    private boolean areOverlap(int A, int B, int C, int D, int E, int F, int G, int H) {
        return C >= E && A <= G && D >= F && B <= H;
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlap = areOverlap(A, B, C, D, E, F, G, H) ? computeOverlapArea(A, B, C, D, E, F, G, H) : 0;

        return (C - A) * (D - B) + (G - E) * (H - F) - overlap;
    }
}
