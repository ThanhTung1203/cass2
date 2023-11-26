import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MenuManage {
    public static void main(String[] args) throws IOException {

        ManageRoom manage = new ManageRoom();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        while (true) {
            System.out.println("----MENU----");
            System.out.println("1.Người dùng");
            System.out.println("2.Người quản lý");
            System.out.println("0.Thoát ");
            System.out.println("Nhập vào vài trò sử dụng :");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Danh sách phòng còn trống ");
                    manage.showListRoomByStatus();

                    break;
                case 2:
                    int choice1 = 1;
                    while (choice1 != 0) {
                        System.out.println("Lựa chọn :");
                        System.out.println("1.Tim kiếm phòng theo giá");
                        System.out.println("2.Tim kiếm phòng theo trạng thái");
                        System.out.println("3.Đặt phòng");
                        System.out.println("4.Xem danh sách hóa đơn ");
                        System.out.println("5.Xem thông tin phòng ");
                        List<Room> loadedRooms = ReadWrite.readRoom("saveListRoom.csv");
                        System.out.println("Danh sách phòng đơn từ file:");
                        for (Room room : loadedRooms) {
                            System.out.println(room);
                        }
                        choice1 = scanner.nextInt();
                        if (choice1 == 1) {
                            manage.search_RoomByPrice();
                            break;
                        }
                        if (choice1 == 2) {
                            manage.search_RoomByStatus();
                        }
                        if (choice1 == 3) {
                            System.out.println("Nhập ID room: ");
                            int roomId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Nhập tên khách: ");
                            String name1 = scanner.nextLine();
                            LocalDate start = LocalDate.now();
                            System.out.println("Nhập thời gian checkout (yyyy-MM-dd): ");
                            //k xet dc trang thai phong

                            String endString = scanner.nextLine();
                            LocalDate end = LocalDate.parse(endString);
                            double payment = manage.calculatePayment(roomId, start, end);
                            manage.add_Invoice(new Invoice(roomId, name1, start, end, payment));
                            ReadWrite.writeInvoice("saveListInvoice.csv",manage.getListInvoice());
                        }

                        if (choice1 == 4) {
                            List<Invoice> loadedInvoices = ReadWrite.readInvoice("saveListInvoice.csv");
                            System.out.println("Danh sách hóa đơn từ file:");
                            for (Invoice invoice : loadedInvoices) {
                                System.out.println(invoice);
                            }
                            break;

                        }
                        if (choice1 == 5) {
                            int choice2 = 1;
                            while (choice2 != 0) {
                                System.out.println("__ Lựa Chọn __");
                                System.out.println("1.Xem trạng thái phòng");
                                System.out.println("2. Danh sách phòng");
                                choice2 = scanner.nextInt();
                                if (choice2 == 1) {

                                    break;
                                }
                                if (choice2 == 2) {
                                    int choice3 = 1;
                                    while (choice3 != 0) {
                                        System.out.println("CRUD");
                                        System.out.println("1.creat");
                                        System.out.println("2.delete");

                                        System.out.println("3.hiển thị danh sách phòng");

                                        choice3 = scanner.nextInt();

                                        if (choice3 == 1) {
                                            System.out.println("nhập id_room ");
                                            String id2 = scanner1.nextLine();
                                            System.out.println("nhập name_room");
                                            String name2 = scanner1.nextLine();
                                            System.out.println("nhập giá ");
                                            int price2 = scanner.nextInt();
                                            manage.add_Room(new Room(id2, name2, price2));
                                            System.out.println("thêm thành công");

                                            ReadWrite.writeToFile("saveListRoom.csv", manage.getListRoom());
                                        }
                                        if (choice3 == 3) {

                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }

                    return;
                case 0:
                    System.out.println("Chào mừng bạn đến với kỷ nguyên vô tận ");
                    System.exit(1);
                    break;

            }
        }
    }
}
