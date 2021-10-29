
import java.io.IOException;


public class Tester {
    public static void main(String[] args) throws IOException {

        Encoder enc = new Encoder();
        enc.chooseAnExtension("txt");
        enc.chooseAnExtension("pdf");
        enc.chooseAnExtension("jpg");

    }
}
