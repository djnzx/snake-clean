package com.codenjoy.dojo.snake.client;

import org.junit.Before;
import org.junit.Test;
import snake.client.Lee;
import snake.client.LeePoint;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class LeeTest {

  private Lee lee;

  @Before
  public void setUp() {
    this.lee = new Lee(15, 10);
  }

  @Test
  public void main() {
    LeePoint src = new LeePoint(0, 0);
    LeePoint dst = new LeePoint(14, 9);
    int[][] obstacles = {
        {5,0}, {5,1}, {5,2}, {5,3}, {5,4}, {5,5}, {5,6},
        {10,4}, {10,5}, {10,6}, {10,7}, {10,8}, {10,9}
    };
    Optional<List<LeePoint>> result = lee.trace(src, dst,
        Arrays.stream(obstacles).map(ints -> new LeePoint(ints[0], ints[1])).collect(Collectors.toList()),
        true);
    if (result.isPresent()) {
      List<LeePoint> path = result.get();
      System.out.println("Path found");
      path.forEach(System.out::println);
      lee.printMe(path);
    } else {
      System.out.println("Path not found");
    }
  }
}
