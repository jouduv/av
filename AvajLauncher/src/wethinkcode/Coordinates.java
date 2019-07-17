package wethinkcode;

class Coordinates
{
    
    private int _longitude;
    private int _height;
    private int _latitude;
    

    Coordinates(int longitude, int latitude, int height)
    {
        this._longitude = longitude;

        this._latitude = latitude;
        
        this._height = height < 0 ? 0 : height > 100 ? 100 : height;;
    }


    public int getLatitude() 
    {
        return (this._latitude);
    }

    public int getLongitude () 
    {
        return (this._longitude);
    }
    
    
    public int getHeight()
    {
        return (this._height);
    }
}