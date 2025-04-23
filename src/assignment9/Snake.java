package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;

	public Snake() {
		segments = new LinkedList<>();
		segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE));
		deltaX = 0;
		deltaY = 0;
	}

	public void changeDirection(int direction) {
		if (direction == 1) { // up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { // down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { // left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { // right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}

	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		// Get head position
		BodySegment head = segments.getFirst();
		double newX = head.getX() + deltaX;
		double newY = head.getY() + deltaY;

		// Add new head and remove tail
		segments.addFirst(new BodySegment(newX, newY, SEGMENT_SIZE));
		segments.removeLast();
	}

	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (BodySegment s : segments) {
			s.draw();
		}
	}

	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		BodySegment head = segments.getFirst();
		double dist = Math.hypot(head.getX() - f.getX(), head.getY() - f.getY());

		if (dist < SEGMENT_SIZE + Food.FOOD_SIZE) {
			// Grow by copying the tail
			BodySegment tail = segments.getLast();
			segments.addLast(new BodySegment(tail.getX(), tail.getY(), SEGMENT_SIZE));
			return true;
		}
		return false;
	}

	/**
	 * Returns true if the head of the snake is in bounds
	 */
	public boolean isInbounds() {
		BodySegment head = segments.getFirst();
		double x = head.getX();
		double y = head.getY();
		return (x >= 0 && x <= 1 && y >= 0 && y <= 1);
	}
}
