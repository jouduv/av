package wethinkcode;

class Aircraft
{

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.id = this.nextid();
        this.coordinates = coordinates;
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    private long nextid()
    {
        idCounter++;
        return idCounter;
    }      
}