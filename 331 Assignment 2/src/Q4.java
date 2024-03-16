import java.util.ArrayList;
/**
 * Q4 class represents a shopping application that manages a dictionary of shoe items
 * and a shopping cart.
 */
public class Q4 {
    private ArrayList<Tuple> dict; // Dictionary of shoe items
    private BoundedStack<Tuple> shoppingCart; // BoundedStack to store selected items

    /**
     * Constructs a new Q4 object with an empty dictionary and an empty shopping cart.
     * Initializes the dictionary with predefined shoe items.
     */
    public Q4() {
        dict = new ArrayList<>();  // Initialize the dictionary
        shoppingCart = new BoundedStack<>(Tuple.class, 10); // Assuming a maximum size of 10 for the stack

        // Adding shoe items to the dictionary
        dict.add(new Tuple("Nike", 450, 15));
        dict.add(new Tuple("Adidas", 400, 10));
        dict.add(new Tuple("Puma", 600, 30));
        dict.add(new Tuple("Sorel", 360, 0));
        dict.add(new Tuple("Aldo", 680, 15));
        dict.add(new Tuple("Skechers", 380, 0));
    }

    /**
     * Adds a shoe item to the shopping cart.
     *
     * @param tuple the shoe item to be added to the shopping cart
     * @throws OverflowException if the shopping cart is full
     */
    public void addToCart(Tuple tuple) throws OverflowException {
        shoppingCart.push(tuple);
    }

    /**
     * Updates the items in the shopping cart based on price and discount comparisons.
     *
     * @throws OverflowException if there is an overflow error in the shopping cart
     * @throws UnderflowException if there is an underflow error in the shopping cart
     */
    public void updateCart() throws OverflowException, UnderflowException {
        for (int i = 1; i < dict.size(); i++) {
            Tuple current = dict.get(i);
            Tuple prev = shoppingCart.peek();

            // Calculate prices after discount
            double prevPrice = (prev.getPrice() * (1 - prev.getDiscount() / 100.0));
            double currPrice = (current.getPrice() * (1 - current.getDiscount() / 100.0));

            // Compare prices and update cart accordingly
            if (currPrice < prevPrice) {
                shoppingCart.pop();
                shoppingCart.push(current);
                System.out.println((i + 1) + "th step: " + shoppingCart +  " as " + current.getPrice() + " X " + current.getDiscount() +" percent = " + currPrice + " is less then " + prevPrice);
            } 
            else if (currPrice > prevPrice) {
            	System.out.println((i + 1) + "th step: " + shoppingCart + " as " + current.getPrice() + " X " + current.getDiscount() +" percent = " + currPrice + " is greater then " + prevPrice);
            	
            }
            	
            else if (currPrice == prevPrice && current.getDiscount() > prev.getDiscount()) {
               shoppingCart.pop();
               shoppingCart.push(current);
               System.out.println((i + 1) + "th step: " + shoppingCart + " as " + current.getPrice() + " X " + current.getDiscount() +" percent = " + currPrice + " and " + current.getBrand() + " has a discount");
           	
            }
            else if (currPrice == prevPrice && current.getDiscount() <= prev.getDiscount()) {
            	System.out.println((i + 1) + "th step: " + shoppingCart + " as " + current.getPrice() + " X " + current.getDiscount() +" percent = " + currPrice + " and " + prev.getBrand() + " has a bigger discount");
               	
            }
            
        }
    }

    /**
     * Returns a string representation of the shopping cart.
     *
     * @return a string representation of the shopping cart
     */
    @Override
    public String toString() {
        return shoppingCart.toString();
    }

    /**
     * The main method to execute the shopping application.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        Q4 shopping = new Q4();

        try {
           
        	shopping.addToCart(shopping.dict.get(0));  // Add the first shoe item to the shopping cart
            System.out.println("Shoes info: " + shopping.dict); // Print the shoe items in the dictionary
            System.out.println("1st step: " + shopping.shoppingCart); // Print the shopping cart before update
            
            shopping.updateCart(); // Update the shopping cart based on price and discount comparisons
        } catch (OverflowException | UnderflowException e) {
            e.printStackTrace();
        }
    }
}
