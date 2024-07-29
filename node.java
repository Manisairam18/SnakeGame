package SnakeGame;

import java.util.Objects;

/**
 * Represents a position on the game board using row and column coordinates.
 */
public class node {
	private int row = 0;
	private int column = 0;

	/**
	 * Constructs a Node with specified row and column.
	 *
	 * @param row    the row of the node
	 * @param column the column of the node
	 */
	public node(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		node node = (node) o;
		return row == node.row && column == node.column;
	}

	@Override
	public int hashCode() {
		return Objects.hash(row, column);
	}

	@Override
	public String toString() {
		return "Node{" + "row=" + row + ", column=" + column + '}';
	}
}
