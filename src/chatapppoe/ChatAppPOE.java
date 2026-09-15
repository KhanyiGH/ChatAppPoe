//Entry point for PROG5121 Poe- Part 1: Registration and Login
package chatapppoe;

import java.util.Scanner;

public class ChatAppPOE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        
        System.out.println("===Registration===");
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        
        System.out.println("Enter cell phone number: ");
        String cellNumber = scanner.nextLine();
        
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        
        String registerMessage = login.registerUser(username, password, cellNumber, firstName, lastName);
        System.out.println(registerMessage);
        
         System.out.println("\n--- Login ---");
         System.out.println("Enter username: ");
         String loginUsername = scanner.nextLine();

         System.out.println("Enter password: ");
        String loginPassword = scanner.nextLine();

       boolean loginSuccess = login.loginUser(loginUsername, loginPassword);
       String loginMessage = login.returnLoginStatus(loginSuccess);
        System.out.println(loginMessage);
        
        
        
  
    }
    
}
