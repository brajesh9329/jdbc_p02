package Service;


import DBConfig.DBConnection;
import Entity.FoodItems;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



    public class FoodService {

        public void addFood(FoodItems food) throws SQLException {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO food_items(food_name, price_per_plate) VALUES (?, ?)"
            );

            ps.setString(1, food.getFoodName());
            ps.setInt(2, food.getPrice());

            ps.executeUpdate();

            ps.close();
            conn.close();
        }


        public List<FoodItems> getAllFood() throws SQLException {

            List<FoodItems> list = new ArrayList<>();

            Connection conn = DBConnection.getConnection();

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(
                    "SELECT * FROM food_items"
            );

            while (rs.next()) {

                list.add(
                        new FoodItems(
                                rs.getInt("food_id"),
                                rs.getString("food_name"),
                                rs.getInt("price_per_plate")
                        )
                );
            }

            rs.close();
            st.close();
            conn.close();

            return list;
        }


        public FoodItems getFoodById(int foodId) throws SQLException {

            FoodItems food = null;

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM food_items WHERE food_id = ?"
            );

            ps.setInt(1, foodId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                food = new FoodItems(
                        rs.getInt("food_id"),
                        rs.getString("food_name"),
                        rs.getInt("price_per_plate")
                );
            }

            rs.close();
            ps.close();
            conn.close();

            return food;
        }
    }

