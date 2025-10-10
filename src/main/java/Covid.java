public class Covid {
    private String date;
    private String country;
    private String state;
    private String ISO;
    private String regionName;
    private String providence;
    private int deaths;
    private int recoveries;
    private double fatality;

    public Covid(String date,String country, String state, String ISO, String regionName, String providence, int deaths, int recoveries, double fatality) {
        this.date = date;
        this.country = country;
        this.state = state;
        this.ISO = ISO;
        this.regionName = regionName;
        this.providence  = providence;
        this.deaths = deaths;
        this.recoveries = recoveries;
        this.fatality = fatality;
    }

    public String getDate() {
        return date;
    }
    public String getCountry() {
        return country;
    }
    public String getState() {return state;}
    public String getISO() {
        return ISO;
    }
    public String getRegionName() {
        return regionName;
    }
    public String getProvidence() {
        return providence;
    }
    public int getDeaths() {
        return deaths;
    }

    public int getRecoveries() {
        return recoveries;
    }

    public double getFatality() {
        return fatality;
    }

}



