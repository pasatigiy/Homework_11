import java.io.*;
import java.util.Scanner;

public class Document {
    public static void main(String[] args) throws IOException {

        System.out.println("Введите путь к файлу.");
        Scanner scan = new Scanner(System.in);
        String path = scan.next();

        System.out.println(path);

        try {


            File myFile = new File(path);
            File validNumber = new File("ValidNumber.txt");
            File invalidNumber = new File("InvalidNumber.txt");

            FileReader fileReader = new FileReader("C:\\Users\\spm.u4\\IdeaProjects\\Docnum.txt");
            Scanner scan1 = new Scanner(fileReader);

            FileWriter fileWriterInvalid = new FileWriter(invalidNumber, true);
            FileWriter fileWriterValid = new FileWriter(validNumber, true);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                if (bufferedReader.readLine().length() == 15) {
                    fileWriterValid.write(bufferedReader.readLine() + "\n");
                } else {
                    if (bufferedReader.readLine().length() < 15 || bufferedReader.readLine().length() > 15) {
                        fileWriterInvalid.write(bufferedReader.readLine() + " не соотвествует длина" + "\n");
                    }
                }

                fileReader.close();
                fileWriterValid.close();
                fileWriterInvalid.close();
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

