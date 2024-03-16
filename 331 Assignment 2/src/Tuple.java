/**
 * Tuple represents a simple data structure to hold information about a product.
 * It consists of a brand name, price, and discount.
 */
public class Tuple {
    private String brand;  // Brand name
    private int price;     // Price of the product
    private int discount; // Discount percentage applied to the product

    /**
     * Constructs a new Tuple object with the specified brand, price, and discount.
     *
     * @param brand    the brand name of the product
     * @param price    the price of the product
     * @param discount the discount percentage applied to the product
     */
    public Tuple(String brand, int price, int discount) {
        this.brand = brand;
        this.price = price;
        this.discount = discount;
    }

    /**
     * Retrieves the brand name of the product.
     *
     * @return the brand name of the product
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Retrieves the price of the product.
     *
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Retrieves the discount percentage applied to the product.
     *
     * @return the discount percentage applied to the product
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Returns a string representation of the Tuple object.
     *
     * @return a string representation of the Tuple object
     */
    @Override
    public String toString() {
    	// return "(" + brand + ", " + price + ", " + discount + ")";
        return "(" + this.brand + ", " + this.price + ", " + this.discount + ")";
    }

}



