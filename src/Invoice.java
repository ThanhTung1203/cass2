import java.time.LocalDate;

public class Invoice {
    private int id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPayment;







    public Invoice(int id, String name, LocalDate startDate, LocalDate endDate, double totalPayment) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPayment = totalPayment;
    }

    @Override
    public String toString() {
        return "Hóa Đơn" +
                "\nid :" + id +
                "\nname :" + name +
                "\nstartDate :" + startDate +
                "\nendDate :" + endDate +
                "\ntotalPayment :" + totalPayment;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public LocalDate getStartDate() {
        return startDate;
    }


    public LocalDate getEndDate() {
        return endDate;
    }


    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }
}
