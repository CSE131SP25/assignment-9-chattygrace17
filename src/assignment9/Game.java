package assignment9;

import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class Game {

	private Snake snake;
	private Food food;
	private int score = 0;

	public Game() {
		StdDraw.setCanvasSize(600, 600);
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);
		StdDraw.enableDoubleBuffering();
		snake = new Snake();
		food = new Food();
	}

	public void play() {
		while (snake.isInbounds()) {
			int dir = getKeypress();
			if (dir != -1) {
				snake.changeDirection(dir);
			}

			snake.move();

			if (snake.eatFood(food)) {
				food.relocate();
				score++; // ✅ update score
			}

			updateDrawing();
			StdDraw.pause(100);
		}

		// ✅ Game over screen with final score
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.55, "Game Over!");
		StdDraw.text(0.5, 0.48, "Final Score: " + score);
		StdDraw.show();
	}

	private int getKeypress() {
		if (StdDraw.isKeyPressed(KeyEvent.VK_W)) return 1;
		if (StdDraw.isKeyPressed(KeyEvent.VK_S)) return 2;
		if (StdDraw.isKeyPressed(KeyEvent.VK_A)) return 3;
		if (StdDraw.isKeyPressed(KeyEvent.VK_D)) return 4;
		return -1;
	}

	private void updateDrawing() {
		StdDraw.clear();
		snake.draw();
		food.draw();

		// ✅ draw score in top-left
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.textLeft(0.02, 0.98, "Score: " + score);

		StdDraw.show();
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
