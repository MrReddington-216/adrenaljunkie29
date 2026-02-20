public class Main {
  public static void main(String[] args) {
    String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    // Best-case input: first character matches
    String bestCase = "A";

    // Start timing
    long startTime = System.nanoTime();
    int index = match(text, bestCase);
    // End timing
    long endTime = System.nanoTime();
    long elapsedTime = endTime - startTime;

    if (index >= 0)
      System.out.println("best-case input matched at index " + index +
                         " in " + elapsedTime + " ns");
    else
      System.out.println("best-case input unmatched");   

    // Worst-case input: last character matches
    String worstCase = "9";

    // Start timing
    startTime = System.nanoTime();
    index = match(text, worstCase);
    // End timing
    endTime = System.nanoTime();
    elapsedTime = endTime - startTime;

    if (index >= 0)
      System.out.println("worst-case input matched at index " + index +
                         " in " + elapsedTime + " ns");
    else
      System.out.println("worst-case input unmatched");  
  }

  // match() and isMatched() remain unchanged
  public static int match(String text, String pattern) {
    for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
      if (isMatched(i, text, pattern))
        return i;
    }
    return -1;
  }

  private static boolean isMatched(int i, String text, String pattern) {
    for (int k = 0; k < pattern.length(); k++) {
      if (pattern.charAt(k) != text.charAt(i + k)) {
        return false;
      }
    }
    return true;
  }
}
