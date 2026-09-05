public class Product
{
    private String ID;
    private String name;
    private String description;
    double cost = 0;

    static private int IDSeed =  1;

    public static void setIDSeed(int IDSeed) {
        Product.IDSeed = IDSeed;
    }

    public static int getIDSeed() {
        return IDSeed;
    }

    public Product(String ID, String name, String description, double cost)
    {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.cost = cost;

        Product.IDSeed++;

    }

    public Product(String name, String description, double cost)
    {
        this.ID = this.genID();
        this.name = name;
        this.description = description;
        this.cost = cost;
    }


    private String genID() {
        String newID = "" + IDSeed;
        while(newID.length() < 8)
        {
            newID = "0" + newID;
        }

        IDSeed++;

        return newID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return cost == product.cost && ID.equals(product.ID) && name.equals(product.name) && description.equals(product.description);
    }

    public String toJSONRecord()
    {
        String retString = "";
        char DQ = '\u0022';  // Assign the double quote char to a variable
        retString =  "{" + DQ + "ID" + DQ + ":" + DQ + this.ID + DQ + ",";
        retString += DQ + "name" + DQ + ":" + DQ + this.name + DQ + ",";
        retString += " " + DQ + "description"  + DQ + ":" + DQ + this.description + DQ + ",";
        retString += " " + DQ + "cost"  + DQ + ":" + this.cost + "}";

        return retString;
    }

    public String toXMLRecord()
    {
        String retString = "";

        retString = "<Product>" + "<ID>" + this.ID + "</ID>";
        retString += "<name>" + this.name + "</name>";
        retString += "<description>" + this.description + "</description>";
        retString += "<cost>" + this.cost + "</cost></Product>";

        return retString;
    }
    public String toCSVRecord() {
        return  this.ID + ", " + this.name + "," + this.description + ", " + cost;
    }
}
