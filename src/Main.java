import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        final String FILE_IN_NAME = "24_demo.txt";
        StringBuilder text = new StringBuilder();
        try(FileReader reader = new FileReader(FILE_IN_NAME))
        {
            int c;
            while ((c=reader.read())!=-1) {
                text.append((char)c);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        int answer = 0;
        int count = 0;

        String letters = text.toString();

        for (char letter: letters.toCharArray()) {
            if (letter == 'X') count++;
            else {
                answer = Math.max(answer, count);
                count = 0;
            }
        }
        answer = Math.max(answer, count);

        System.out.println(answer);
    }
}