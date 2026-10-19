package chatapppoe;
import java.util.Random;

/**
 *
 * @author Khanyi
 */
public class Message {

    public boolean checkMessageID(String messageID) {
        return messageID.length() <= 10;
    }

    public String checkRecipientCell(String cellNumber) {
        if (cellNumber.startsWith("+") && cellNumber.length() <= 13) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }
  public String createMessageHash(String messageID, int messageNumber, String message) {
    String[] words = message.split(" ");
    String firstWord = words[0].replaceAll("[^a-zA-Z]", "");
    String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z]", "");
    String start = messageID.substring(0, 2);

    String hash = start + ":" + messageNumber + ":" + firstWord + lastWord;
    return hash.toUpperCase();
}  
    public String generateMessageID() {
    Random random = new Random();
    String id = "";
    for (int i = 0; i < 10; i++) {
        id = id + random.nextInt(10);
    }
    return id;
}
}