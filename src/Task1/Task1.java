package Task1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) {
        try (FileWriter fileWriter = new FileWriter("src/Task1/tms.txt");
             FileReader fileReader = new FileReader("src/Task1/romeo-and-juliet.txt")) {
             StringBuilder sb = new StringBuilder("");
             int i;
             while((i = fileReader.read()) != -1){
                 sb.append((char) i);
             }
             String[] array = sb.toString().replaceAll("\\W", " ").split(" ");
             String max = array[0];
            for(String line: array){
                if(line.length() >= max.length()){
                    max = line;
                }
            }
            fileWriter.write(max);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
