public class Covid {
    private int date;
    private int deaths;
    private int recoveries;
    private double fatality;

    public Covid(int date, int deaths, int recoveries, double fatality) {
        this.date = date;
        this.deaths = deaths;
        this.recoveries = recoveries;
        this.fatality = fatality;
    }

    public int getDate() {
        return date;
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

    public String toString() {
        return String.format("Date: %s, deaths: %s, recoveries: %s, fatality: %.2f ", date, deaths, recoveries, fatality);
    }

}



