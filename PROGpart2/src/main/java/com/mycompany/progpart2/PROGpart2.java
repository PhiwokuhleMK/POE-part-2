/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progpart2;
import javax.swing.JOptionPane;
import java.util.Random;
/**
 *
 * @author lab_services_student
 */
public class PROGpart2 {

    public static void main(String[] args) {
       
     // Display welcome message
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat", "QUICKCHAT APP", JOptionPane.INFORMATION_MESSAGE);     //Welcome message

        while (true) {
            String[] options = {"Send Messages", "Show Recent Messages", "Quit"};    //Promt the user to make a choice 
            int choice = JOptionPane.showOptionDialog(
                null,
                "Choose an option:",
                "QuickChat Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
            );
            

            if (choice == 0) {                                   // Send Messages
                sendMessages();
                
            } else if (choice == 1) {                                  // Show Recent Messages
                JOptionPane.showMessageDialog(null, "Coming soon...");
                
            } else if (choice == 2 || choice == JOptionPane.CLOSED_OPTION) { // Quit(close the app)
                JOptionPane.showMessageDialog(null, "Goodbye:)");
                System.exit(0);
            }
        }
    }

    private static void sendMessages() {
        int count = 0;  
        while (true) {
            String input = JOptionPane.showInputDialog("How many messages would you like to send?");   //Asking the user how many messages are they going to use 
            if (input == null) return;    //if non try again
            try {
                count = Integer.parseInt(input);
                if (count > 0) break;
                JOptionPane.showMessageDialog(null, "Please enter a number greater than 0.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number. Try again.");
            }
        }

        for (int i = 0; i < count; i++) {
            String messageID = generateMessageID();

            // Get recipient number
            String recipient = "";
            while (true) {
                recipient = JOptionPane.showInputDialog("Enter recipient number (must start with +27 or 0):");
                if (recipient == null) return;
                if (recipient.matches("^(\\+27|0)[6-8][0-9]{8}$")) break;
                JOptionPane.showMessageDialog(null, "Invalid number. It must start with (+27 or 0).");
            } 

            // Get message text
            String messageText = "";
            while (true) {
                messageText = JOptionPane.showInputDialog("Enter your message (max 250 characters):");
                if (messageText == null) return;
                if (messageText.length() <= 250 && !messageText.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Message recorded");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Enter a message of less than 250 characters.");
                }
            }

           
            String hash = generateMessageHash(messageID, i, messageText);      // Genetate message hash

            // Show message summary
            JOptionPane.showMessageDialog(null,"Message ID: " + messageID +"\nRecipient: " + recipient +"\nHash: " + hash);    // Show message summary
        
           // Ask user what to do with the message after it has been recorded
            String[] actions = {"Send message", "Store message to send later", "Disregard message"};
            int action = JOptionPane.showOptionDialog(
                null,
                "What would you like to do with this message?",
                "Choose Action",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                actions,
                actions[0]
            );

            switch (action) {
                case 0: // display if user chooses to Send message 
                    JOptionPane.showMessageDialog(null, "Message successfully sent.");
                    break;
                case 1: // display if user chooses to Store message
                   JOptionPane.showMessageDialog(null, "Message successfully stored.");
                    break;
                case 2: //display if user chooses to Delete message 
                    JOptionPane.showMessageDialog(null, "Message deleted.");
                    break;
                default:
                   
                    return;
            }
}
}
    

    private static String generateMessageID() { //Auto generate the MessageID
        Random rand = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            id.append(rand.nextInt(10));
        }
        return id.toString();
    }

    private static String generateMessageHash(String messageID, int index, String message) {
        String[] words = message.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0].toUpperCase() : "";
        String lastWord = words.length > 1 ? words[words.length - 1].toUpperCase() : firstWord;

        String hashPrefix = "(" + messageID.substring(0, 2) + ":" + index + ")";
        return hashPrefix + " " + firstWord + " " + lastWord;
    }
    }
     
         
     
             

 