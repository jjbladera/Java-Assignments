/*
 * To change this template, choose Tools | Templates
 * Javier Chavez
 * jchavez589@cnm.edu
 * 
 * Java 1 P8
 */
package data;

import java.util.Date;
import javax.xml.bind.ParseConversionEvent;

/**
 *
 * @author jchavez589
 */
public class Website {
    private int id;
    private String compName;
    private double assets;
    private String founded;
    private String url;
    private int alexaRank;
    
    public Website()
    {
        
    }

    public Website(String id, String cn, String ca, String f, String url, String rnk  ) {
        //throw new UnsupportedOperationException("Not yet implemented");
        this.id = Integer.parseInt(id);
        compName = cn;
        assets = Double.parseDouble(ca);
        founded = f;
        this.url = url;
        alexaRank = Integer.parseInt(rnk);
        
    }

    /**
     * @return the compName
     */
    public String getCompName() {
        return compName;
    }

    /**
     * @return the assets
     */
    public double getAssets() {
        return assets;
    }

    /**
     * @return the founded
     */
    public String getFounded() {
        return founded.substring(0, 10);
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the alexaRank
     */
    public int getAlexaRank() {
        return alexaRank;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param compName the compName to set
     */
    public void setCompName(String compName) {
        this.compName = compName;
    }

    /**
     * @param assets the assets to set
     */
    public void setAssets(double assets) {
        this.assets = assets;
    }

    /**
     * @param founded the founded to set
     */
    public void setFounded(String founded) {
        this.founded = founded;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @param alexaRank the alexaRank to set
     */
    public void setAlexaRank(int alexaRank) {
        this.alexaRank = alexaRank;
    }
    
    
    
}

