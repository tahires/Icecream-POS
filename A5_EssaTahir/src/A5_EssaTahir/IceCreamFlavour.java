/** Name:  Essa Tahir
 * Assignment:  Assignment5
 * Program: PROG24178
 *
 * Making a icecream inventory
 */
package A5_EssaTahir;

/**
 *
 * @author Essa OG
 */
public enum IceCreamFlavour {
    VANILLA(1,"Vanilla"),
    CHOCOLATE(2,"Chocolate"),
    MANGO(3,"Mango"),
    STAWBERRY (4,"Stawberry"),
    BUTTER_PECAN(5,"Butter Pecan"),
    MOOSE(6,"Moose"),
    RASPBERRY(7,"Raspberry");
    
    private String flavourName;
    private int id;
    
private    IceCreamFlavour(int id,String flavourName){
        this.flavourName = flavourName;
        this.id = id;
    }

    /**
     * @return the flavourName
     */
    public String getFlavourName() {
        return flavourName;
    }

    /**
     * @param flavourName the flavourName to set
     */
    public void setFlavourName(String flavourName) {
        this.flavourName = flavourName;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
