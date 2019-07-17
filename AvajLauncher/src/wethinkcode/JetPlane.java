package wethinkcode;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower = new WeatherTower();

    JetPlane(String name, Coordinates coordinates)
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
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                Simulator.writer.println("JetPlane#" + name + "(" + id + "): " + "The fog is killing me. Request permission to land.");
                break;
            }

            case "Sun":
            {
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                Simulator.writer.println("JetPlane#" + name + "(" + id + "): " + "This is hot.");
                break;
            }

            case "Rain":
            {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 2, coordinates.getHeight());
                Simulator.writer.println("JetPlane#" + name + "(" + id + "): " + "It's raining. Better watch out for lightnings");
                break;
            }
            
            case "Snow":
            {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
                Simulator.writer.println("JetPlane#" + name + "(" + id + "): " + "OMG! Winter is coming!");
                break;
            }       
        }   
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.writer.println("Tower says: " + this.getClass().getSimpleName() + "#" + name  + "(" + this.id + ") registered to weather tower.");
    }
}