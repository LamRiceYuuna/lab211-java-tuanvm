//extends
public class EastAsiaCountries extends Country{
    // Properties
    private String countryTerrain;
    
    // Constructors
    EastAsiaCountries(){
        
    }

    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    //get/set
    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    //display
    @Override
    public void display() {
        
        System.out.format("%-20s%-20s%-20s%-20s\n", countryCode, countryName, totalArea, countryTerrain);
    }
}
