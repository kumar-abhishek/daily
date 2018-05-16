/*
223. Rectangle Area
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
*/

//accepted

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        int r1 = Math.abs((C-A)*(D-B));
        int r2 = Math.abs((G-E)*(H-F));
        
        if(C<E|| G< A || H<B || D<F) return r1 + r2;
        int top = Math.min(H, D);
        int bottom = Math.max(F, B);
        int left = Math.max(E,A);
        int right = Math.min(G,C);
        return r1 + r2 -Math.abs(top-bottom) * Math.abs(right-left);
    }
}
