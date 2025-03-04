public class Country {
    // Properties
    protected String countryCode;
    protected String countryName;
    protected float totalArea;
    
    // contructors
    public Country() {
    }

    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

     //set/get
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    //display
    public void display() {
        
        System.out.println(this.countryCode + "\t"
                + this.countryName + "\t"
                + this.totalArea);
    }
}
