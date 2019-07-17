package wethinkcode;


public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower = new WeatherTower();

    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }
    public void updateConditions() {
         String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "Sun":{
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                Simulator.writer.println("Helicopter#" + name + "(" + id + "): " + "This is hot.");
                break;}
            case "Rain":{
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                Simulator.writer.println("Helicopter#" + name + "(" + id + "): " + "It's raining. Better watch out for lightnings");
                break;}
            case "Fog":{
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude() + 1, coordinates.getHeight());
                Simulator.writer.println("Helicopter#" + name + "(" + id + "): " + "The fog is killing me. Request permission to land.");
                break;}
            case "Snow":{
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                Simulator.writer.println("Helicopter#" + name + "(" + id + "): " + "OMG! Winter is coming!");
                break;}
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.writer.println("Tower says: " + this.getClass().getSimpleName() + "#" + name + "(" + this.id + ") registered to weather tower.");
    }
}