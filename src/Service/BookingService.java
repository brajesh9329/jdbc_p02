package Service;
import DBConfig.DBConnection;
import Entity.Booking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;




    public class BookingService {

        public void addBooking(Booking booking) throws SQLException {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO booking(cid, event_date, guest_count, total_amount) VALUES (?, ?, ?, ?)"
            );

            ps.setInt(1, booking.getCustomerID());
            ps.setDate(2, booking.getEventDate());
            ps.setInt(3, booking.getGuestCount());
            ps.setDouble(4, booking.getTotalAmount());

            ps.executeUpdate();

            ps.close();
            conn.close();
        }


        public List<Booking> getAllBookings() throws SQLException {

            List<Booking> list = new ArrayList<>();

            Connection conn = DBConnection.getConnection();

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(
                    "SELECT * FROM booking"
            );

            while (rs.next()) {

                list.add(
                        new Booking(
                                rs.getInt("booking_id"),
                                rs.getInt("cid"),
                                rs.getDate("event_date"),
                                rs.getInt("guest_count"),
                                rs.getDouble("total_amount")
                        )
                );
            }

            rs.close();
            st.close();
            conn.close();

            return list;
        }


        public Booking getBookingById(int bookingId) throws SQLException {

            Booking booking = null;

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM booking WHERE booking_id = ?"
            );

            ps.setInt(1, bookingId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                booking = new Booking(
                        rs.getInt("booking_id"),
                        rs.getInt("cid"),
                        rs.getDate("event_date"),
                        rs.getInt("guest_count"),
                        rs.getDouble("total_amount")
                );
            }

            rs.close();
            ps.close();
            conn.close();

            return booking;



        }

        // Add food item to a booking
        public void addFoodToBooking(
                int bookingId,
                int foodId,
                int quantity
        ) throws SQLException {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO food_receipt(booking_id, food_id, quantity) " +
                            "VALUES (?, ?, ?)"
            );

            ps.setInt(1, bookingId);
            ps.setInt(2, foodId);
            ps.setInt(3, quantity);

            ps.executeUpdate();

            ps.close();
            conn.close();
        }
    }

