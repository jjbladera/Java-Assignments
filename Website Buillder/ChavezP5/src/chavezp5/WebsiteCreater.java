/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chavezp5;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 

/**
 *
 * @author youracow
 */
public class WebsiteCreater {
    private String doc;
    private String name;
    private String header;
    private String projectName;
    private boolean wantFooter;
    private boolean wantNav;
    private boolean wantHeader;
    private boolean wantCarousel;
    private boolean wantTextOnly;
    private int numberOfColumns;
    private boolean[] headFont; //t is lobster f t anton f f default
    private String setHeadFont; // used for font string
 
    
    //private 
    
    public WebsiteCreater() {
        doc = "";
        name = "Javier C";
        header = "Hello World";
        projectName = "Cool Stuff";
        wantFooter = true;
        wantNav = true;
        wantHeader = true;
        //wantTextOnly = false;
        numberOfColumns = 3;
        headFont = new boolean[2];
        headFont[0] = true;
        buildDoc();
    }

    public void setHeader(String header) {
        this.header = header;
    }
    public String getHeader(){
        return header;
    }
    
    public void setWantFooter(boolean wantFooter) {
        this.wantFooter = wantFooter;          
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName (){
        return name;
    }
    
    /**
     * @return the wantFooter
     */
    public boolean isWantFooter() {
        return wantFooter;
    }

    /**
     * @return the wantNav
     */
    public boolean isWantNav() {
        return wantNav;
    }

    /**
     * @param wantNav the wantNav to set
     */
    public void setWantNav(boolean wantNav) {
        this.wantNav = wantNav;
    }

    /**
     * @return the wantHeader
     */
    public boolean isWantHeader() {
        return wantHeader;
    }

    /**
     * @param wantHeader the wantHeader to set
     */
    public void setWantHeader(boolean wantHeader) {
        this.wantHeader = wantHeader;
    }

    /**
     * @return the headFont
     */
    public boolean[] getHeadFont() {
        return headFont;
    }

    /**
     * @param headFont the headFont to set
     */
    public void setHeadFont(boolean[] headFont) {
        this.headFont = headFont;
    }
    
    /**
     * @return the wantCarousel
     */
    public boolean isWantCarousel() {
        return wantCarousel;
    }

    /**
     * @param wantCarousel the wantCarousel to set
     */
    public void setWantCarousel(boolean wantCarousel) {
        this.wantCarousel = wantCarousel;
    }

    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    /**
     * @return the numberOfColumns
     */
    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    /**
     * @param numberOfColumns the numberOfColumns to set
     */
    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }
    /**
     * @return the wantTextOnly
     */
    public boolean isWantTextOnly() {
        return wantTextOnly;
    }

    /**
     * @param wantTextOnly the wantTextOnly to set
     */
    public void setWantTextOnly(boolean wantTextOnly) {
        this.wantTextOnly = wantTextOnly;
    }
    
    public void saveDoc(){
        try{
            File file = new File("../site.html");
            
            if (!file.exists()) {
                    file.createNewFile();
            }
            
            buildDoc();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(doc);
            
            bw.close(); 
        }
        catch(IOException e){
        
        }
    }
    
    private void buildDoc(){
        doc = "";
        doc += "<!DOCTYPE html>\n<html><head>"
                +"<link href=\"http://twitter.github.com/bootstrap/assets/css/bootstrap.css\" "+
                " rel=\"stylesheet\">";
        insertFont();
        insertJSCall();
        doc += "</head><body style =\"padding-top: 60px;padding-bottom: 40px;\">";
        if (wantNav) {
            makeNavBar();
        }
        
        doc +="<div class=\"container\">";
        if (wantCarousel) {
            instertCarousel();
        }
        if (wantHeader || wantTextOnly) {
            makeHeader();
        }
        makeCol();
        if (wantFooter) {
            makeFooter();
        }
        doc += "\n</div></body>\n</html>";

    }
    
    private void makeHeader(){
        String textOnly = "";
        
        if (wantTextOnly) {
            textOnly = "";
        }
        if (!wantTextOnly){
            textOnly = "hero-unit";
        }
        
        doc+="<div class="+ textOnly +">" +
        "<h1 "+setHeadFont+">"+header+"</h1>";
        if(!wantTextOnly){
            doc += "<p>it and three unique.</p>" +
            "<p><a class=\"btn btn-primary btn-large\">Learn more &raquo;</a></p>"+
            "</div>";
        }
    }
    
    private void makeCol(){
        doc += "<div class=\"row\">";
        for (int i = 0; i < numberOfColumns; i++) {
        
            doc +="<div class=\"span4\">"+
          "<h2>Heading</h2>"+
          "<p>magna mollis euismod. Donec sed odio dui. </p>"+
          "<p><a class=\"btn\" href=\"#\">View details &raquo;</a></p>"+
            "</div>";            
        }

       doc += "</div><hr>";
    }
    
    private void makeNavBar(){
        doc+="<div class=\"navbar navbar-fixed-top\">"+
      "<div class=\"navbar-inner\">"+
        "<div class=\"container\">"+
          "<a class=\"brand\" href=\"#\">"+projectName+"</a>"+
          "<div class=\"nav-collapse collapse\">"+
            "<ul class=\"nav\">"+
              "<li class=\"active\"><a href=\"#\">Home</a></li>"+
              "<li><a href=\"#about\">About</a></li>"+
              "<li><a href=\"#contact\">Contact</a></li>"+
            "</ul>"+
            "<form class=\"navbar-form pull-right\">"+
             "<input class=\"span2\" type=\"text\" placeholder=\"Email\">"+
              "<input class=\"span2\" type=\"password\" placeholder=\"Password\">"+
              "<button type=\"submit\" class=\"btn\">Sign in</button>"+
            "</form>"+
          "</div>"+
        "</div>"+
      "</div>"+
    "</div>";
    }
    
    public void insertJSCall(){
        doc +="<script src=\"http://twitter.github.com/bootstrap/assets/js/jquery.js\"></script>";
        doc +="<script src=\"http://twitter.github.com/bootstrap/assets/js/bootstrap-carousel.js\"></script>";
        doc += "<script>$(function () {"+
                "$('.carousel').carousel();"+
                "jQuery.browser.mobile;"+
            "});</script>";
    }
    
    private void insertFont(){
        doc +="<link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>";
        doc += "<link href='http://fonts.googleapis.com/css?family=Anton' rel='stylesheet' type='text/css'>";
        if (headFont[0]) {
            setHeadFont = "style =\"font-family: 'Lobster', cursive;\"";
        }
        else if(headFont[1]){
            setHeadFont = "style =\"font-family: 'Anton', sans-serif;\"";
        }
        else{
            setHeadFont= "";
        }

    }
    private void instertCarousel(){
        doc+="<div class=\"span12\">"+
              "<div class=\"carousel slide\">"+
              "<div class=\"carousel-inner\">"+
              "<div class=\"item active\">"+
              "<img src=\"http://farm9.staticflickr.com/8332/8081062220_9aafd41f1e_b.jpg\">"+
              "<div class=\"carousel-caption\">"+
              "<h4>First Thumbnail label</h4>"+
              "<p>Cras justo ut id elit.</p>"+
              "</div>"+
              "</div>"+
              "<div class=\"item\">"+
              "<img src=\"http://farm9.staticflickr.com/8052/8081067837_250865e273_b.jpg\">"+
              "<div class=\"carousel-caption\">"+
              "<h4>Second Thumbnail label</h4>"+
              "<p>id nibh ultricies ut id elit.</p>"+
              "</div>"+
              "</div>"+
              "</div>"+
              "</div>"+
              "</div>";
    }
    
    private void makeFooter(){
        if(isWantFooter()){
            doc += "<footer><p>&copy;" + name +" 2012</p> </footer>";
        }
    }
}
