public class Room {
    private String id_room;
    private String name_room;
    private double price ;
    private boolean status_room;

    public void setStatus_room(boolean status_room) {
        this.status_room = status_room;
    }

    public Room(String id_room, String name_room, double price) {
        this.id_room = id_room;
        this.name_room = name_room;
        this.price = price;
    }
    public String getId_room() {
        return id_room;
    }



    public String getName_room() {
        return name_room;
    }


    public double getPrice() {
        return price;
    }


    public boolean isStatus_room() {
        return status_room;
    }






    @Override
    public String toString() {
        return "Room{" +
                "id_room='" + id_room + '\'' +
                ", name_room='" + name_room + '\'' +
                ", price=" + price +
                ", status_room=" + status_room +
                '}';
    }
}
