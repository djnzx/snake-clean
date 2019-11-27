package snake.client;

import com.codenjoy.dojo.services.Point;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Snake {
  private final List<LeePoint> data;

  private static List<LeePoint> convert(List<Point> points) {
    return points.stream().map(LeePoint::new).collect(Collectors.toList());
  }

  public static Snake from(List<Point> unsorted) {
    // TODO: implement sort
    return new Snake(convert(unsorted));
  }

  /**
   * Elements:
   *
   * HEAD_DOWN('▼'),
   * HEAD_LEFT('◄'),
   * HEAD_RIGHT('►'),
   * HEAD_UP('▲'),
   * TAIL_END_DOWN('╙'),
   * TAIL_END_LEFT('╘'),
   * TAIL_END_UP('╓'),
   * TAIL_END_RIGHT('╕'),
   * TAIL_HORIZONTAL('═'),
   * TAIL_VERTICAL('║'),
   * TAIL_LEFT_DOWN('╗'),
   * TAIL_LEFT_UP('╝'),
   * TAIL_RIGHT_DOWN('╔'),
   * TAIL_RIGHT_UP('╚'),
   *
   * GOOD_APPLE('☺'),
   * BAD_APPLE('☻'),
   *
   * BREAK('☼'),
   */
  public static Snake from(Board board) {
    LinkedList<Point> body_unsorted = (LinkedList<Point>)board.getSnake();
    LinkedList<LeePoint> body_sorted = new LinkedList<>();

    Point head = body_unsorted.removeFirst();
    body_sorted.add(new LeePoint(head));
    Point prev = head;
    while (body_unsorted.size() > 0) {
      // find the next point
      switch (board.getAt(prev)) {
        case HEAD_UP:;
        // ...
      }
      // ...
    }
    // TODO: implement
    return new Snake(body_sorted);
  }

  public Snake(List<LeePoint> data) {
    this.data = data;
  }

  public List<LeePoint> body() {
    return data;
  }

  public LeePoint head() {
    throw new IllegalArgumentException("not implemented yet");
  }
}
