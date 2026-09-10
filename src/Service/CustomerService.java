package Service;

import DBConfig.DBConnection;
import Entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    public void addCustomer(Customer customer) throws SQLException{
        Connection conn= DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(
                "INSERT INTO customer(cname,phone,addreaa) VALUES (?,?,?)"
        );

        ps.setString(1, customer.getName());
        ps.setString(2,customer.getPhone());
        ps.setString(3,customer.getAddress());

        ps.executeUpdate();
        ps.close();

    }

    public List<Customer>getAllCustomer() throws SQLException{
        List<Customer>list=new ArrayList<>();
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs =st.executeQuery(
                "SELECT * FROM customer"
        );
                while(rs.next()){
                    list.add(
                            new Customer(
                                    rs.getInt("cid"),
                                    rs.getString("cname"),
                                    rs.getString("phone"),
                                    rs.getString("addreaa")
                            )
                    );
                }

        rs.close();
        st.close();
        conn.close();

        return list;
    }
    public Customer getCustomerBasedOnNumber(String number) throws SQLException {

        Customer customer = null;

        Connection conn = DBConnection.getConnection();

        PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM customer WHERE phone = ?"
        );

        ps.setString(1, number);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {

            customer = new Customer(
                    rs.getInt("cid"),
                    rs.getString("cname"),
                    rs.getString("phone"),
                    rs.getString("addreaa")
            );
        }
        rs.close();
        ps.close();
        conn.close();

        return customer;


    }
}
