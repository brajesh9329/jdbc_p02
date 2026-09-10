package Entity;

import java.sql.Date;

public class Booking {
private int bookingId;
private int customerID;
private Date eventDate;
private int guestCount;
private double totalAmount;

    public Booking(int bookingId, int customerID, Date eventDate, int guestCount, double totalAmount) {
        this.bookingId = bookingId;
        this.customerID = customerID;
        this.eventDate = eventDate;
        this.guestCount = guestCount;
        this.totalAmount = totalAmount;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", customerID=" + customerID +
                ", eventDate='" + eventDate + '\'' +
                ", guestCount=" + guestCount +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
