import java.util.Scanner;

public class App {
    public static void main(String[] args){

        System.out.println("Hello and welcome to the food app");
        System.out.println("Please create a password");

        Scanner keyboard = new Scanner(System.in);
        String registredPassword = keyboard.next();

        System.out.println("Your password is now: "+registredPassword);

        System.out.println("Please enter your password");
        String password = keyboard.next();

        while(!password.equals(registredPassword)){
            System.out.println("This is not the right password, please try again: ");
            password = keyboard.next();
        }

        System.out.println("Access granted");
        System.out.println("Are you hungry? (Y/N)");
        String hungryAnswer = keyboard.next();

        if(hungryAnswer.equals("Y")){

            System.out.println("Choose what you want to eat (pizza/burger/fish)");
            String foodAnswer = keyboard.next();

            while(!foodAnswer.equals("pizza") && !foodAnswer.equals("burger") && !foodAnswer.equals("fish")){

                System.out.println("Sorry, we don't have that, what would you like to eat (pizza/burger/fish)");
                foodAnswer = keyboard.next();
            }

            if(foodAnswer.equals("pizza") || foodAnswer.equals("burger") || foodAnswer.equals("fish")){

                System.out.println("Do you want something to drink? (Y/N)");
                String beverageAnswer = keyboard.next();

                while(!beverageAnswer.equals("Y") && !beverageAnswer.equals("N")){

                    System.out.println("Wrong command, please try again");
                    beverageAnswer = keyboard.next();
                }

                if(beverageAnswer.equals("Y")){

                    System.out.println("what would you like to drink? (coke/juice)");
                    String beverageType = keyboard.next();

                    while(!beverageType.equals("coke") && !beverageType.equals("juice")){

                        System.out.println("Sorry, we don't have that beverage, what would you like to drink? (coke/juice)");
                        beverageType = keyboard.next();
                    }

                    if(beverageType.equals("coke") || beverageType.equals("juice")){

                        System.out.println("Great, you have ordered the next:");
                        System.out.println("Food: "+foodAnswer);
                        System.out.println("Beverage: "+beverageType);

                    }

                } else {

                    System.out.println("Great, you have ordered the next:");
                    System.out.println("Food: "+foodAnswer);

                }
            }

        } else {

            System.out.println("All right, have a good day");

        }
    }
}
