import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ManageRoom {


    List<Invoice> listInvoice = new ArrayList<>();
    List<Room> listRoom = new ArrayList<>();

    public List<Invoice> getListInvoice() {
        return listInvoice;
    }



    public double getPriceRoom(int roomId) {
        for (Room room : listRoom) {
            if (room.getId_room().equals(String.valueOf(roomId))) {
                return room.getPrice();
            }
        }
        return 0;
    }

        public int calculatePayment(int roomId, LocalDate start, LocalDate end) {
        int numberOfDays = (int) start.until(end, ChronoUnit.DAYS);
        double roomPrice = getPriceRoom(roomId);
//        System.out.println("roomPrice: " + roomPrice);
        return (int) (roomPrice * numberOfDays);
    }

    public void setListRoom(List<Room> listRoom) {
        this.listRoom = listRoom;
    }

    public List<Room> getListRoom() {
        return listRoom;
    }

    void add_Room(Room room) {
        this.listRoom.add(room);

    }

    void edit_RooomByID() {

    }

    void delete_RoomByID() {

    }

    void search_Room() {
    }

    void search_RoomByPrice() {
    }

    void check_Status() {
    }


    void showListRoom() {
        for (Room item : listRoom
        ) {
            System.out.println(item);

        }
    }
     public void deleteById(){

     }

    void showListRoomByPrice() {
    }

    void showListRoomByStatus() {
    }

    public void search_RoomByStatus() {
    }

    public void add_Invoice(Invoice invoice) {
        listInvoice.add(invoice);
    }





    public void showListInvoice() {
        for (Invoice invoice : listInvoice) {
            System.out.println(invoice);
        }
    }


}
