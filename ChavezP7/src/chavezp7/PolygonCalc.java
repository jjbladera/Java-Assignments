/* PolygonCalc.java
 * 
 * Javier Chavez
 * jchavez589@cnm.edu
 * 
 * CIS 2275 Java Programming 1 
 * 
 * Program 7: polygons
 * DUE Nov8 2012
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
    
    PolygonCalc() 
    {
        numberOfSides = 3;
        radius = 1;
        calc();
    }
    
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
     * @return the calculated polygon area
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
