package SnakeGame;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Snake {
	private final char[][] snakeBoard;
	private final Queue<node> snakeBody = new LinkedList<>();
	private final Queue<node> food = new LinkedList<>();
	private final Scanner scanner = new Scanner(System.in);
	private int currentRow = 0;
	private int currentCol = 0;

	public Snake(int rows, int cols) {
		snakeBoard = new char[rows][cols];
		snakeBody.add(new node(0, 0));
		snakeBoard[0][0] = '.';

		// Initialize food positions
		food.add(new node(1, 0));
		food.add(new node(2, 2));
		food.add(new node(3, 4));
		food.add(new node(5, 2));
		food.add(new node(4, 5));

		// Display first food (o)
		displayFood(food.poll());
	}

	public void startGame() {
		while (true) {
			printBoard();
			System.out.print("Enter a direction (U/D/L/R): ");
			char direction = scanner.next().toUpperCase().charAt(0);

			switch (direction) {
			case 'U':
				moveSnake(currentRow - 1, currentCol);
				break;
			case 'D':
				moveSnake(currentRow + 1, currentCol);
				break;
			case 'L':
				moveSnake(currentRow, currentCol - 1);
				break;
			case 'R':
				moveSnake(currentRow, currentCol + 1);
				break;
			default:
				System.out.println("Invalid direction! Use U, D, L, or R.");
			}
		}
	}

	private void moveSnake(int newRow, int newCol) {
		// Wrap around edges
		newRow = (newRow + snakeBoard.length) % snakeBoard.length;
		newCol = (newCol + snakeBoard[0].length) % snakeBoard[0].length;

		// Check for collisions with the snake's body
		if (snakeBoard[newRow][newCol] == '.') {
			System.out.println("Game Over! You collided with yourself.");
			System.exit(0);
		}

		// Add new head position
		snakeBody.add(new node(newRow, newCol));

		// Check if the snake has eaten food
		if (snakeBoard[newRow][newCol] == 'o') {
			if (food.isEmpty()) {
				System.out.println("You ate all the food. You Win!");
				System.exit(0);
			}
			displayFood(food.poll());
		} else {
			// Remove the tail
			node tail = snakeBody.poll();
			snakeBoard[tail.getRow()][tail.getColumn()] = ' ';
		}

		// Update snake's head position
		snakeBoard[newRow][newCol] = '.';
		currentRow = newRow;
		currentCol = newCol;
	}

	private void displayFood(node node) {
		snakeBoard[node.getRow()][node.getColumn()] = 'o';
	}

	private void printBoard() {
		for (char[] row : snakeBoard) {
			for (char cell : row) {
				System.out.print(cell == '\0' ? ' ' : cell);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
}
