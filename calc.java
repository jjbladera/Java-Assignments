/*
 *	Name Javier Chavez
 *	Email jchavez589@cnm.edu
 *	Exercise 5 Polygon Calculator Class
 *	CIS Java Programming I
 *	
 *
 */
package chavezp7;


public class PolygonCalc {
    private int radius;
    private int numberOfSides;
    private double perimeter;
    private double polygonArea;
    private double circumference;
    private double circleArea;
    
    PolygonCalc() { this(3,1); }
    
    PolygonCalc(int s, int r)
    {
        numberOfSides = s;
        radius = r;
        calc();
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(int radius) {
        this.radius = radius;
        calc();
    }

    /**
     * @param numberOfSides the numberOfSides to set
     */
    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        calc();
    }

    /**
     * @return the perimeter
     */
    public double getPerimeter() {
        return perimeter;
    }

    /**
     * @return the polygonArea
     */
    public double getPolygonArea() {
        return polygonArea;
    }

    /**
     * @return the circumference
     */
    public double getCircumference() {
        return circumference;
    }

    /**
     * @return the circleArea
     */
    public double getCircleArea() {
        return circleArea;
    }
    
    private void calcPerimeter(){
        double aG = (360/numberOfSides)/2;
        double sL = (radius* Math.sin(Math.toRadians(aG)))*2;     
        perimeter = sL*numberOfSides;
    }
    
    private void calcAreaPoly(){
        double beg = (numberOfSides*(radius*radius))/2;
        double area = beg * (Math.sin(Math.toRadians(360/numberOfSides)));
        polygonArea = area;
    }
    
    private void calcAreaCircle(){
        double area = Math.PI * (radius*radius);
        circleArea = area;
    }
    
    private void calcCircumf(){
        double c = (2* Math.PI) * radius;
        circumference = c;
    }
    
    //calculate function to house all calculators
    private void calc(){
        calcPerimeter();
        calcAreaPoly();
        calcAreaCircle();
        calcCircumf();
    }
}
