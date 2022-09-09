package weather;

public class Weather {

    private double temp;

    public Weather() {
        this.temp = 0;
    }

    public void setWeather(double temp) {
        this.temp = temp;
    }


    public String evaluateWeather() {

        if (temp >= 22) {
            return "Heute ist ein schöner Tag!";
        }
        return "Heute ist nicht so schön!";
    }
}
