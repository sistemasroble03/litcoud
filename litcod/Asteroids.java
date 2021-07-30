package litcod;

import java.util.Arrays;
import java.util.Stack;

public class Asteroids {

  public static int[] asteroids(int[] input) {
    Stack<Integer> stack = new Stack<>();
    int[] output;
    int i;
    boolean use_current;
    int last;

    for (int current : input) {
      use_current = true;
      if (current < 0) {
        while (!stack.isEmpty()) {
          last = stack.peek();

          if (last > 0 && last <= Math.abs(current)) stack.pop();
          if (last >= Math.abs(current)) use_current = false;
          if (last < 0 || !use_current) break;
        }
      }
      if (use_current) stack.add(current);
    }

    output = new int[stack.size()];
    i = 0;
    for (int accepted : stack) output[i++] = accepted;

    return output;
  }

  public static void main(String[] args) {
    int[][][] cases = {
      {{}, {}},
      {{-1}, {-1}},
      {{1}, {1}},
      {{-1, -2}, {-1, -2}},
      {{1, 2}, {1, 2}},
      {{-1, 2}, {-1, 2}},
      {{5, 10, -2}, {5, 10}},
      {{8, -8}, {}},
      {{10, 2, -5}, {10}},
      {{-2, -1, 1, 2}, {-2, -1, 1, 2}},
      {{1, -2, -2, 1}, {-2, -2, 1}}
    };

    for (int[][] test : cases) {
      int[] output = asteroids(test[0]);
      System.out.println(
        String.format("[ Input: %s | Output %s | Expected %s | Result: %s ]",
                      Arrays.toString(test[0]),
                      Arrays.toString(output),
                      Arrays.toString(test[1]),
                      Arrays.equals(test[1], output) ? "PASS" : "FAIL")
      );
    }
  }
}
