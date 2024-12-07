public class MapObject {
    private String id;



    private int latitude;
    private int longitude;

    public MapObject(String id, int latitude, int longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }


    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "MapObject{" +
                "id='" + id + '\'' +
                ", m=" + latitude +
                ", n=" + longitude +
                '}';
    }
}