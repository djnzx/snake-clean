package snake.client;

import com.codenjoy.dojo.services.Point;

import java.util.List;
import java.util.stream.Collectors;

public class Snake {
  private final List<LeePoint> data;

  private static List<LeePoint> convert(List<Point> points) {
    return points.stream().map(LeePoint::new).collect(Collectors.toList());
  }

  public static Snake from(List<Point> unsorted) {
    // TODO: implement sort !!!
    return new Snake(convert(unsorted));
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
