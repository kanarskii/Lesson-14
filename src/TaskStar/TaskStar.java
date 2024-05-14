package TaskStar;
        /*Допустим есть txt файл с номерами документов. Номером документа является строка,
        состоящая из букв и цифр(без служебных символов). Пусть этот файл содержит каждый
        номер документа с новой строки и в строке никакой другой информации, только номер
        документа. Валидный номер документа должен иметь длину 15 символов и начинаться с
        последовательности docnum(далее любая последовательность букв/цифр) или
        contract(далее любая последовательность букв/цифр). Написать программу для чтения
        информации из входного файла - путь к входному файлу должен задаваться через
        консоль. Программа должна проверять номера документов на валидность. Валидные
        номера документов следует записать в один файл-отчет. Невалидные номера документов
        следует записать в другой файл-отчет, но после номеров документов следует добавить
        информацию о том, почему этот документ не валиден.*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TaskStar {
    Scanner scanner = new Scanner(System.in);
    String road = scanner.nextLine(); //src/TaskStar/documentNumbers.txt
    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("src/TaskStar/documentNumbers.txt");
            FileWriter fileValid = new FileWriter("src/TaskStar/validDocuments.txt");
            FileWriter fileNotValid = new FileWriter("src/TaskStar/notValidDocuments.txt")){
            StringBuilder sb = new StringBuilder("");
            int i;
            while((i = fileReader.read()) != -1){
                sb.append((char) i);
            }
            String[] array = sb.toString().replaceAll("\\r","").split("\\n");
            for (String str: array) {
                if(str.length() == 15){
                    fileValid.write(str + " \n");
                }else{
                    fileNotValid.write(str + " не валидный номер документа \n");
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
