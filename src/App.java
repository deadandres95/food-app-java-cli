import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws IOException {

        // Declare the variables on the top of code
        // Keyboard as a standard input
        Scanner keyboard = new Scanner(System.in);
        // Variables for the user
        String  userName = "",
                userPassword = "",
                password = "",
                newUserName = "",
                newPassword = "";
        // Variables for the menu
        byte    mainMenuOption = 0,
                userMenuOption = 0,
                orderMenuOption = 0,
                foodMenuOption = 0,
                beverageMenuOption = 0,
                removeMenuOption = 0,
                number = 1,
                choiceFinishOrder = 0;
        // Variable for the food menu
        String[] foodMenu = {
                "Pizza",
                "Burguer",
                "Fish\'n\'Chips"
        };
        // Variable for the beverages menu
        String[] beverageMenu = {
                "Water",
                "Juice",
                "Coke"
        };
        // Variable for the order
        ArrayList order = new ArrayList<String>();

        // Begin program
        System.out.println("Hello and welcome to your food app");
        while (userName.isEmpty() && userPassword.isEmpty()){
            // Set the username
            do{
                System.out.println(("May I ask your name?"));
                userName = keyboard.next();
                if (userName.isEmpty()){
                    System.out.println(("Your name can't be empty\n"));
                    System.in.read();
                    
                }
            } while (userName.isEmpty());
            // Set the password
            do{
                System.out.println("Could you set a password?");
                userPassword = keyboard.next();
                if (userPassword.isEmpty()){
                    System.out.println(("Your password can't be empty\n"));
                    System.in.read();
                    
                }
            } while (userPassword.isEmpty());
        }

        if (!userName.isEmpty() && !userPassword.isEmpty()){
            // Block for check the password
            do {
                System.out.println("Please, type your password");
                password = keyboard.next();
                if (!password.equals(userPassword)){
                    System.out.println("Incorrect password\n");
                    System.in.read();
                    
                }
            } while (!password.equals(userPassword));
            // Main menu
            do {
                System.out.println("Hello "+ userName +", What do you want to do today?\n");
                System.out.println("1. Update user settings");
                System.out.println("2. Make an order");
                System.out.println("3. Exit");
                mainMenuOption = keyboard.nextByte();

                switch (mainMenuOption) {
                    case 1:
                        // start of the user settings administration
                        do {
                            if (userMenuOption != 0){
                                userMenuOption = 0;
                            }
                            System.out.println("What do you want to modify?\n");
                            System.out.println("1. Name of the user");
                            System.out.println("2. Password");
                            System.out.println("3. Go back");
                            userMenuOption = keyboard.nextByte();

                            switch (userMenuOption) {
                                // Change of username
                                case 1:
                                    do {
                                        System.out.println("This is your current username: " + userName);
                                        System.out.println("What will be your new username?");
                                        newUserName = keyboard.next();
                                        if (newUserName.isEmpty()) {
                                            System.out.println(("Your name can't be empty\n"));
                                            System.in.read();
                                        } else {
                                            userName = newUserName;
                                            System.out.println("Now, your current username is: " + userName);
                                        }
                                    } while (newUserName.isEmpty());
                                    break;
                                // Change of password
                                case 2:
                                    do {
                                        System.out.println("This is your current password: " + userPassword);
                                        System.out.println("What will be your new password?");
                                        newPassword = keyboard.next();

                                        if (newPassword.isEmpty()) {
                                            System.out.println(("Your password can't be empty\n"));
                                            System.in.read();
                                        } else {
                                            userPassword = newPassword;
                                            System.out.println("Now, your current password is: " + userPassword);
                                        }
                                    } while (newPassword.isEmpty());
                                    break;
                                //Return to the main menu
                                case 3:
                                    System.out.println("Returning to main menu");
                                    System.in.read();
                                    break;
                                default:
                                    System.out.println("You picked a non valid action");
                                    break;
                            }
                        } while (userMenuOption != 3);
                        break;
                    case 2:
                        // begin with the food ordering
                        do {
                            if (orderMenuOption != 0){
                                orderMenuOption = 0;
                            }
                            if (order.isEmpty()) {
                                System.out.println("Your order is empty\n");
                            } else {
                                number = 1;
                                for (Object item : order) {
                                    System.out.println(number + " : " + item);
                                    number++;
                                }
                            }
                            System.out.println("What do you want to do with your order\n");
                            System.out.println("1: Add item (food)");
                            System.out.println("2: Add item (beverages)");
                            System.out.println("3: remove item");
                            System.out.println("4: Finish order");
                            System.out.println("5: Go back");
                            orderMenuOption = keyboard.nextByte();

                            switch (orderMenuOption){
                                // Add food
                                case 1:
                                    do {
                                        System.out.println("What food do you want to eat\n");
                                        number = 1;
                                        for (Object item : foodMenu) {
                                            System.out.println(number + " : " + item);
                                            number++;
                                        }
                                        System.out.println("0: Go back");
                                        foodMenuOption = keyboard.nextByte();

                                        switch (foodMenuOption){
                                            case 0:
                                                System.out.println("Going back to the order menu");
                                                System.in.read();
                                                break;
                                            case 1,2,3:
                                                int foodIndex = foodMenuOption - 1;
                                                System.out.println("Adding "+ foodMenu[foodIndex] + " to the order");
                                                order.add(foodMenu[foodIndex]);
                                                break;
                                            default:
                                                System.out.println("We don't have that food on sale");
                                                System.in.read();
                                                break;
                                        }
                                    } while (foodMenuOption < 0 || foodMenuOption > number - 1);
                                    break;
                                // Add drink
                                case 2:
                                    do{
                                        System.out.println("What beverages do you want to drink\n");
                                        number = 1;
                                        for (Object item : beverageMenu) {
                                            System.out.println(number + " : " + item);
                                            number++;
                                        }
                                        System.out.println("0: Go back");
                                        beverageMenuOption = keyboard.nextByte();

                                        switch (beverageMenuOption){
                                            case 0:
                                                System.out.println("Going back to the order menu");
                                                System.in.read();
                                                break;
                                            case 1,2,3:
                                                int beverageIndex = beverageMenuOption - 1;
                                                System.out.println("Adding "+ beverageMenu[beverageIndex] + " to the order");
                                                order.add(beverageMenu[beverageIndex]);
                                                break;
                                            default:
                                                System.out.println("We don't have that beverage on sale");
                                                System.in.read();
                                                break;
                                        }
                                    } while (beverageMenuOption < 0 || beverageMenuOption > number - 1);
                                    break;
                                // Remove item (food or drink)
                                case 3:
                                    do {
                                        if (order.isEmpty()){
                                            System.out.println("Your order is empty so you can't remove items\n");

                                        } else {
                                            System.out.println("What item do you want to remove\n");
                                            number = 1;
                                            for (Object item : order) {
                                                System.out.println(number + " : " + item);
                                                number++;
                                            }
                                        }
                                        System.out.println("0: Go back");

                                        removeMenuOption = keyboard.nextByte();
                                        int removeIndex = removeMenuOption - 1;
                                        if (removeMenuOption <= order.size() && removeMenuOption != 0){
                                            System.out.println("Removing "+ order.get(removeIndex) + " of the order");
                                            order.remove(removeIndex);
                                        } else if (removeMenuOption == 0) {
                                            System.out.println("Going back to the order menu");
                                            System.in.read();
                                        } else {
                                                System.out.println("You don't have that item");
                                                System.in.read();
                                        }
                                    } while ((removeMenuOption < 0 && removeMenuOption > 0) || removeMenuOption > number -1);
                                    break;
                                // Finishing the order
                                case 4:
                                    do {
                                        System.out.println("This is what you have ordered\n");
                                        for (Object item : order) {
                                            System.out.println("* " + item);
                                        }
                                        System.out.println("1: Finish order");
                                        System.out.println("2: Go back");
                                        choiceFinishOrder = keyboard.nextByte();

                                        if (choiceFinishOrder == 1){
                                            System.out.println("Thank you for buying lunch with us\n");
                                            order.clear();
                                            System.in.read();

                                        } else if (choiceFinishOrder == 2) {
                                            System.out.println("Going back to the order menu");
                                            System.in.read();

                                        } else {
                                            System.out.println("You picked a non valid action");
                                            System.in.read();
                                        }
                                    } while (choiceFinishOrder != 1 && choiceFinishOrder != 2);
                                    break;
                                case 5:
                                    System.out.println("Going back to the main menu");
                                    System.in.read();
                                    break;
                                default:
                                    System.out.println("You picked a non valid action");
                                    System.in.read();
                                    break;
                            }
                        } while (orderMenuOption != 5);
                        break;
                    case 3:
                        System.out.println("All right, Have a nice day");
                        System.in.read();
                        break;
                    default:
                        System.out.println("You picked a non valid action");
                        System.in.read();
                        break;
                }
            } while (mainMenuOption != 3);
        }
    }
}
