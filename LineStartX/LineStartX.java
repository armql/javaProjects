package LineStartX;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineStartX {
  private String filename;

  public LineStartX(String filename) {
    this.filename = filename;
  }

  public void evenXLine() {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String longestLine = "";
      int longestLineNum = 0;
      int lineNum = 1;
      String line = reader.readLine();
      while (line != null) {
        if (line.startsWith("X") && line.length() % 2 == 0 && line.length() > longestLine.length()) {
          longestLine = line;
          longestLineNum = lineNum;
        }
        line = reader.readLine();
        lineNum++;
      }

      if (longestLineNum > 0) {
        System.out.println("The longest line of even length starting with X is: " + longestLine);
      } else {
        System.out.println("There are no lines of even length starting with X.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred while reading the file.");
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    LineStartX lineStartX = new LineStartX("java.txt");
    lineStartX.evenXLine();
  }
}
