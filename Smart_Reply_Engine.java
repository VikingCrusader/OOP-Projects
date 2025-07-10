package OOP_Projects;
import java.util.*;
import java.util.Scanner;

public class Smart_Reply_Engine {
    public static void main(String[] args) {
        System.out.println("Welcome to use our automatic smart reply engine! What can I do for you?");
        replyStrategy strategy = (msg) -> {
            msg = msg.toLowerCase();
            if(msg.contains("hi")||msg.contains("hello")||msg.contains("how")||msg.contains("hey")) {
                return "Hello! How can I help you?";
            }else if (msg.contains("damn")||msg.contains("shit")||msg.contains("fuck")) {
                return "Please use appropriate language.";
            }else if (msg.contains("buy")||msg.contains("discount")||msg.contains("promo")) {
                return "Please refrain from posting advertisements.";
            }else {
                return "Sorry, I didn't understand that.";
            }
        };
        replyEngine engine = new replyEngine();
        engine.addStrategy(strategy);
        engine.handleMessage("Hi, I need help");
        engine.handleMessage("Buy this now!");
        engine.handleMessage("You are damn slow");
        engine.handleMessage("Is anyone there?");
    }
}

@FunctionalInterface
interface replyStrategy {
    String generateReply(String userMessage);
}

class replyEngine {
    ArrayList<replyStrategy> strategies = new ArrayList<>();
    void addStrategy(replyStrategy strategy) {
        strategies.add(strategy);
    }
    void handleMessage(String message) {
        for (replyStrategy strategy : strategies) {
            String reply = strategy.generateReply(message);
            System.out.println(reply);
        }
    }
}