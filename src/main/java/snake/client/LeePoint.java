package snake.client;

import com.codenjoy.dojo.services.Point;

public class LeePoint {
  private int x;
  private int y;

  public LeePoint(Point p) {
    this(p.getX(), p.getY());
  }

  public LeePoint(int x, int y) {
    this.x = x;
    this.y = y;
  }

  LeePoint move(LeePoint delta) {
    return new LeePoint(
        this.x + delta.x,
        this.y + delta.y);
  }

  public int x() {
    return this.x;
  }

  public int y() {
    return this.y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    LeePoint point = (LeePoint) o;

    if (x != point.x) return false;
    return y == point.y;
  }

  @Override
  public int hashCode() {
    return x << 16 + y;
  }

  @Override
  public String toString() {
    return String.format("[%d:%d]", x, y);
  }

}
