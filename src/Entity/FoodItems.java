package Entity;

public class FoodItems {
    private int FoodID;
    private String FoodName;
    private int price;

    public FoodItems(int foodID, String foodName, int price_per_plate) {
        FoodID = foodID;
        FoodName = foodName;
        this.price = price_per_plate;

    }

    public int getFoodID() {
        return FoodID;
    }

    public void setFoodID(int foodID) {
        FoodID = foodID;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FoodItems{" +
                "FoodID=" + FoodID +
                ", FoodName='" + FoodName + '\'' +
                ", price=" + price +
                '}';
    }
}
