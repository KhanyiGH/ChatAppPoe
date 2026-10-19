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
        
        if (!loginSuccess) {
    return;
}

System.out.println("Welcome to QuickChat.");
System.out.print("How many messages do you want to enter? ");
int numMessages = Integer.parseInt(scanner.nextLine());
int sentCount = 0;
int totalSent = 0;
Message msg = new Message();
     
int choice = 0;

while (choice != 3) {
    System.out.println("1) Send Messages");
    System.out.println("2) Show recently sent messages");
    System.out.println("3) Quit");
    choice = Integer.parseInt(scanner.nextLine());

    switch (choice) {
        case 1: {
    if (sentCount >= numMessages) {
        System.out.println("You have already entered all " + numMessages + " messages.");
        break;
    }
    String messageID = msg.generateMessageID();
    System.out.println("Enter recipient number:");
    String recipient = scanner.nextLine();
    String cellResult = msg.checkRecipientCell(recipient);
    System.out.println(cellResult);
    if (!cellResult.equals("Cell phone number successfully captured.")) {
        break;
    }
    System.out.println("Enter your message:");
    String text = scanner.nextLine();
    String lengthResult = msg.checkMessageLength(text);
    System.out.println(lengthResult);
    if (!lengthResult.equals("Message ready to send.")) {
        break;
    }
    String hash = msg.createMessageHash(messageID, sentCount, text);
         System.out.println("1) Send Message");
System.out.println("2) Disregard Message");
System.out.println("3) Store Message to send later");
int action = Integer.parseInt(scanner.nextLine());
sentCount++;

if (action == 1) {
    msg.recordSent(messageID, hash, recipient, text);
    System.out.println("Message successfully sent.");
    System.out.println("Message ID: " + messageID);
    System.out.println("Message Hash: " + hash);
    System.out.println("Recipient: " + recipient);
    System.out.println("Message: " + text);
} else if (action == 2) {
    System.out.println("Press 0 to delete the message.");
    scanner.nextLine();
} else if (action == 3) {
    msg.storeMessage(messageID, hash, recipient, text);
    System.out.println("Message successfully stored.");
} else {
    System.out.println("Invalid option.");
}
break;
}
        case 2:
            System.out.println("Coming Soon.");
            break;
        case 3:
            System.out.println("Goodbye.");
            System.out.println("Total messages sent: " + msg.returnTotalMessages());
            break;
        default:
            System.out.println("Invalid option.");
    }
} 
  
    }
    
}
