import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DishApp {

    //show the customer dishes the restaurant has
    static List<Dish> dishList = new ArrayList<>();

    //What the customer ordered
    static List<Dish> personDish = new ArrayList<>();

    public static void main(String[] args) {
        initDish();
        Scanner s  = new Scanner((System.in));

        while (true) {
            //show user the menu
            showMenu();
            //obtain the number
            int num = s.nextInt();

            switch (num) {
                case 1:
                    while(true) {
                        //show the menu
                        showDishMenu();
                        //obtain the number of the dish
                        int id = s.nextInt();
                        if (id == 0) {
                            break;
                        }
                        Dish dish = dishList.get(id - 1);
                        System.out.println("You plan to order " + dish.name);
                        personDish.add(dish);
                    }
                case 2:
                    //show what the customer has ordered
                    showPersonDish();
                    break;
                case 3:
                    //place the order
                    placeOrder();
                    Scanner con = new Scanner(System.in);
                    int n = con.nextInt();
                    if (n == 0) {
                        System.out.println("Thank you for ordering, your dishes will be ready soon, " +
                                "we hope you will enjoy our dishes!");
                        return;
                    } else {
                        break;
                    }
            }
        }
    }

    public static void initDish(){
        Dish dish1 = new Dish(1, "Key lime pie",29.0);
        dishList.add(dish1);
        Dish dish2 = new Dish(2, "Tater tots",58.0);
        dishList.add(dish2);
        dishList.add(new Dish(3, "San Francisco sourdough bread",20.0));
        dishList.add(new Dish(4, "Cobb salad",30.0));
        dishList.add(new Dish(5, "Pot roast",48.0));
    }

    public static void showMenu() {
        System.out.println("----Main Menu----");
        System.out.println("Menu\t\t\t1");
        System.out.println("Ordered Dishes\t2");
        System.out.println("Place order\t\t3");
        System.out.println("----Please make a selection----");
    }

    public static void showDishMenu(){
        System.out.println("----Please Order----");
        for (int i = 0; i < dishList.size(); i++) {
            Dish dish = dishList.get(i);
            System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
        }
        System.out.println("----Please enter the dish number, enter 0 to return to the last menu----");
    }

    public static void showPersonDish(){
        for (int i = 0; i < personDish.size(); i++) {
            Dish dish = personDish.get(i);
            System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
        }
    }
    public static void placeOrder(){
        double total = 0;
        for (int i = 0; i < personDish.size(); i++) {
            Dish dish = dishList.get(i);
            System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
            total += dish.price;
        }
        System.out.println("\nYour total: " + total);
        System.out.println("Just to confirm that you are done ordering.");
        System.out.println("Press 0 to confirm, press 1 to return to the last menu");
    }
}
