package GeneralAlgorithms;

/**
 * A triangle formed by the three point a(x1,y1), b(x2,y2) and c(x3,y3) is a non-degenerated triangle
 * if the following rules are respected (/ab/ is the length of the line between points a and b);
 * |ab| + |bc| > |ac|
 * |bc| + |ac| > |ab|
 * |ab| + |ac| > |bc|
 * A point belongs to a triangle if it lies somewhere on or inside the triangle. Given two points
 * p = (xp, yp) and q = (xq, yq), return the correct scenario number:
 * - 0 : if the triangle abc does not form a valid non- degenerated triangle
 * - 1 : if point p belongs to the triangle but point q does not.
 * - 2 : if point q belongs to the triangle but point p does not.
 * - 3 : if both p and q belong to the triangle.
 * - 4 : if neither point p nor point q belong to the triangle
* */
public class DegenerateTriangle {

    /**
     * Solution: A point p lies within a triangle ABC if the sum of the areas of the 3 triangle formed with the 3 sides of the
     * main triangle, ApB + ApC + BpC = the area of ABC.
     *
     * The area of a triangle can be calculated from the 3 sides of the triangle by using
     * Heron’s formula. The formula is
     * Area = {sqrt (s(s-a)(s-b)(s-c))}, where s = (a+b+c)/2 is called semi perimeter of the triangle with sides a,b and c.
     */

    public static int tri(int x1, int y1, int x2, int y2, int x3, int y3, int xp, int yp, int xq, int yq) {

        double ab = getLength(x1,y1,x2,y2);
        double bc = getLength(x2,y2,x3,y3);
        double ac = getLength(x1,y1,x3,y3);

        double ap = getLength(x1,y1,xp,yp);
        double bp = getLength(x2,y2,xp,yp);
        double cp = getLength(x3,y3,xp,yp);

        double aq = getLength(x1,y1,xq,yq);
        double bq = getLength(x2,y2,xq,yq);
        double cq = getLength(x3,y3,xq,yq);


        //Check if triangle is degenerate or not
        if (!((ab+bc > ac) && (bc+ac > ab) && (ac+ab > bc))) return 0;

        //Calculate main area of triangle
        double mainArea = calcArea(ab, ac, bc);

        //calculate the areas of the 3 triangles formed by p on the sides' ab, bc, ac
        double pArea = calcArea(ap, bp, ab);
        pArea += calcArea(ap, cp, ac);
        pArea += calcArea(bp, cp, bc);

        //calculate the areas of the 3 triangles formed by q on the sides' ab, bc, ac
        double qArea = calcArea(aq, bq, ab);
        qArea += calcArea(aq, cq, ac);
        qArea += calcArea(bq, cq, bc);


        if (pArea == mainArea && qArea != mainArea) return 1;
        if (qArea == mainArea && pArea != mainArea) return 2;
        if (pArea == mainArea && qArea == mainArea) return 3;
        if (pArea != mainArea && qArea != mainArea) return 4;


        return -1;

    }

    public static double getLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt((Math.pow(Math.abs(x1-x2),2) + Math.pow(Math.abs(y1-y2),2)));
    }

    public static double calcArea(double a, double b, double c) {
        double s = (a+b+c)*0.5;
        return Math.sqrt((s*(s-a)*(s-b)*(s-c)));
    }
}
