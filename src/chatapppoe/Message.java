package chatapppoe;

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
}