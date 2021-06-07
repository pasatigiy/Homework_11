import java.io.*;
import java.util.Scanner;

public class Document {
    public static void main(String[] args) throws IOException {

        System.out.println("Введите путь к файлу.");
        Scanner scan = new Scanner(System.in);
        String path = scan.next();

        System.out.println(path);

        FileReader fileReader = null;
        FileWriter fileWriterInvalid = null;
        FileWriter fileWriterValid = null;

        try {


            File myFile = new File(path);
            File validNumber = new File("ValidNumber.txt");
            File invalidNumber = new File("InvalidNumber.txt");

            fileReader = new FileReader(path);
            Scanner scan1 = new Scanner(fileReader);

            fileWriterInvalid = new FileWriter(invalidNumber, true);
            fileWriterValid = new FileWriter(validNumber, true);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                String str = bufferedReader.readLine();
                System.out.println(str);
                if (str.length() == 15) {
                    fileWriterValid.write(str + "\n");
                } else {
                    if (str.length() < 15 || str.length() > 15) {
                        fileWriterInvalid.write(str + " не соотвествует длина" + "\n");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ioException) {
                }
            }
            if (fileWriterInvalid != null) {
                try {
                    fileWriterInvalid.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }

            if (fileWriterValid != null) {
                try {
                    fileWriterValid.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}



