package wethinkcode;

import java.io.*;
import java.util.*;

public class Simulator
{
    public  static PrintWriter writer;
    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] arg) throws InterruptedException
    {
        File simulator = new File("simulation.txt");
        try
        {
            writer = new PrintWriter(simulator);
            BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
            String line = reader.readLine();
            if (line != null)
            {
                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations < 0)
                {
                    System.out.println("Ivalid simulations count " + simulations);
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null)
                {
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1], Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]), Integer.parseInt(line.split(" ")[4]));
                    flyables.add(flyable);
                }

                for (Flyable flyable : flyables)
                {
                    flyable.registerTower(weatherTower);
                }

                for(int i= 0; i < simulations; ++i)
                {
                    weatherTower.changeWeather();
                    System.out.println("Simulation(" + i +")");
                }
            }
            reader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Couldn't find file " + arg[0]);
            Simulator.writer.println("Couldn't find file " + arg[0]);
        } 
        catch (IOException e)
        {
            System.out.println("There was an error while reading the file " + arg[0]);
            Simulator.writer.println("There was an error while reading the file " + arg[0]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Specify simulation file " + arg[0]);
            Simulator.writer.println("Specify simulation file " + arg[0]);
        }
        catch (NumberFormatException e)
        {
            System.out.println("NumberFormatException: For input string is not a number\n");   
        }
        finally
        {
        }
        writer.close();
    }
}