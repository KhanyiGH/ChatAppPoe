
package chatapppoe;


public class Login{
    
    private String storedUsername;
    private String storedPassword;
    private String storedCellNumber;
    private String firstName;
    private String lastName;
   
    /**
     * Checks that the username contains an underscore and is no more than 5 characters long.
     * */
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length()<=5;
        
    }
    
    /**
 * Checks that the password is at least 8 characters, contains a capital letter,
 * a number, and a special character.
 */
    public boolean checkPasswordComplexity(String password){
        if (password.length()<8) return false;
        boolean hasUpper = false, hasDigit = false, hasSpecial = false;
        for (char c : password.toCharArray()){
            if (Character.isUpperCase(c))hasUpper = true;
            if (Character.isDigit(c))hasDigit = true;
            if (!Character.isLetterOrDigit(c))hasSpecial = true;
        }
        return hasUpper && hasDigit && hasSpecial;
    }
    
    /**
 * Checks that the cell phone number starts with the South African international
 * code (+27) followed by 9 digits.
 */
    public boolean checkCellPhoneNumber(String cellNumber){
        return cellNumber.matches("\\+27\\d{9}");
    }
    
    /**
 * Registers a new user by validating the username, password, and cell number.
 * Returns a message indicating success or which validation failed.
 */
    public String registerUser(String username, String password, String cellNumber, String firstName, String lastName) {
    if (!checkUserName(username)) {
        return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
    }
    if (!checkPasswordComplexity(password)) {
        return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }
    if (!checkCellPhoneNumber(cellNumber)) {
        return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
    }
    storedUsername = username;
    storedPassword = password;
    storedCellNumber = cellNumber;
    this.firstName = firstName;
    this.lastName = lastName;
    
    return "Username successfully captured. Password successfully captured. Cell number successfully captured.";
}
    
    /**
 * Checks whether the given username and password match the stored credentials.
 */
    public boolean loginUser(String username, String password) {
    return username.equals(storedUsername) && password.equals(storedPassword);
}
    
    /**
 * Returns the login status message based on whether login was successful.
 */
    public String returnLoginStatus(boolean loginSuccess) {
    if (loginSuccess) {
        return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
    } else {
        return "Username or password incorrect, please try again.";
    }
    
}
}
