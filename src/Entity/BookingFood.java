package Entity;

public class BookingFood {

    private int bId;
    private int bookingId;
    private int fid;
    private int quantity;

    public BookingFood(int bId, int bookingId, int fid, int quantity) {
        this.bId = bId;
        this.bookingId = bookingId;
        this.fid = fid;
        this.quantity = quantity;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BookingFood{" +
                "bId=" + bId +
                ", bookingId=" + bookingId +
                ", fid=" + fid +
                ", quantity=" + quantity +
                '}';
    }
}
