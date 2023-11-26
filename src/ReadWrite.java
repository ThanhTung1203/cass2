import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadWrite {
    public static void writeToFile(String path, List<Room> roomList) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        StringBuilder str = new StringBuilder("id,name,price,status \n");
        for (Room s : roomList
        ) {
            str.append(s.getId_room()).append(',').append(s.getName_room()).append(',').append(s.getPrice()).append(',').append(s.isStatus_room()).append("\n");
        }
        bufferedWriter.write(str.toString());
        bufferedWriter.close();
        fileWriter.close();
    }

    public static void writeInvoice(String path, List<Invoice> invoiceList) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        StringBuilder str = new StringBuilder("Mã HĐ,Tên KH,TG checkin,TG checkout,Thanh Toán \n");
        for (Invoice a : invoiceList
        ) {
            str.append(a.getId()).append(",").append(a.getName()).append(",").append(a.getStartDate()).append(",").append(a.getStartDate()).append(",").append(a.getTotalPayment());

        }
        bufferedWriter.write(str.toString());
        bufferedWriter.close();
        fileWriter.close();
    }


    public static List<Invoice> readInvoice(String path) throws IOException {
        List<Invoice> invoiceList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String header = reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    LocalDate startDate = LocalDate.parse(parts[2]);
                    LocalDate endDate = LocalDate.parse(parts[3]);
                    double totalPayment = Double.parseDouble(parts[4]);

                    Invoice invoice = new Invoice(id, name, startDate, endDate, totalPayment);
                    invoiceList.add(invoice);
                }
            }
        }

        return invoiceList;
    }

    public static List<Room> readRoom(String path) throws IOException {
        List<Room> roomList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            // Đọc header và bỏ qua
            String header = reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    boolean status = Boolean.parseBoolean(parts[3]);

                    Room room = new Room(id, name, price);
                    room.setStatus_room(status);

                    roomList.add(room);
                }
            }
        }

        return roomList;
    }

}