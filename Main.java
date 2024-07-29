package SnakeGame;

public class Main {

    public static void main(String[] args) {
        // Create a new instance of the Snake game with a 6x6 board
        Snake game = new Snake(6, 6);

        // Print a welcome message to the user
        System.out.println("Welcome to the Snake Game!");
        System.out.println("Controls:");
        System.out.println("W - Move Up");
        System.out.println("S - Move Down");
        System.out.println("A - Move Left");
        System.out.println("D - Move Right");
        System.out.println("Press Q to Quit");

        // Start the game
        game.startGame();
    }
}

