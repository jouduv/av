package wethinkcode;

public class Baloon extends Aircraft implements Flyable
{   
    private WeatherTower weatherTower = new WeatherTower();

    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }
    
    public void updateConditions()
    {
       String weather = weatherTower.getWeather(coordinates);
        switch (weather)
        {
            case "Fog":
            {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                break;
            }

            case "Snow":
            {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                Simulator.writer.println("Baloon#" + name + "(" + id + "): " + "OMG! Winter is coming!");
                break;
            }

            case "Sun":
            {
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                Simulator.writer.println("Baloon#" + name + "(" + id + "): " + "This is hot.");
                break;
            }

            case "Rain":
            {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                Simulator.writer.println("Baloon#" + name + "(" + id + "): " + "It's raining. Better watch out for lightnings");
                break;
            }
        }  
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.writer.println("Tower says: " + this.getClass().getSimpleName() + "#" + name  + "(" + this.id + ") registered to weather tower.");
    }
}
