package snake.client;

import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SmartSnake {
  private Point stone;
  private Point apple;
  private Lee lee;
  private Point snake_head;
  private boolean gameOver;
  private ArrayList<Point> obstacles = new ArrayList<>();;

  public SmartSnake(Board board) {
    List<Point> walls = board.getWalls();
    gameOver = board.isGameOver();
    stone = board.getStones().get(0);
    apple = board.getApples().get(0);
    List<Point> snake = board.getSnake();
    snake_head = board.getHead();
    int dimX = walls.stream().mapToInt(Point::getX).max().orElse(0) + 1;
    int dimY = walls.stream().mapToInt(Point::getY).max().orElse(0) + 1;
    obstacles.addAll(walls);
    obstacles.add(stone);
    obstacles.addAll(snake);
    lee = new Lee(dimX, dimY);
  }

  Direction solve() {
    if (gameOver) return Direction.UP;

    // your code mus tbe here!
    Optional<List<LeePoint>> solution_apple = lee.trace(snake_head, apple, obstacles);

    return Direction.UP;
  }

  private Direction coord_to_direction(Point from, LeePoint to) {
    if (to.x() < from.getX()) return Direction.LEFT;
    if (to.x() > from.getX()) return Direction.RIGHT;
    if (to.y() > from.getY()) return Direction.UP;   // vise versa because of reverted board
    if (to.y() < from.getY()) return Direction.DOWN; // vise versa because of reverted board
    throw new RuntimeException("you shouldn't be there...");
  }

}
