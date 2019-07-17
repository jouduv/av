package wethinkcode;

class AircraftFactory
{
    public static Flyable newAircraft(String type, String name, int latitude, int longitude, int height)
    {

        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        String vehicle = type.toLowerCase();

        if (latitude < 0 || longitude < 0 )
        {
            System.out.println("Latitude or longitude cannot be negative numbers");
            Simulator.writer.println("Latitude or longitude cannot be negative numbers");
        }

        if (vehicle.equals("baloon"))
        {
            return new Baloon(name, coordinates);
        }

        else if (vehicle.equals("helicopter"))
        {
            return new Helicopter(name, coordinates);
        }

        else if (vehicle.equals("jetplane"))
        {
            return new JetPlane(name, coordinates);
        }

        else
        {
            System.out.println("Please input a valid aircraft.");
            Simulator.writer.println("Please input a valid aircraft.");
        }
        return null;
    }
}