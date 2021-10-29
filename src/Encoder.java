import java.io.*;
import java.nio.charset.Charset;

public class Encoder {
    Charset utf8 = Charset.forName("UTF-8");
    Charset ansi = Charset.forName("WINDOWS-1252");
    File draft = new File("src/draft.none");
    int count = 0;

    public void chooseAnExtension(String extension) throws IOException {
        ++count;
        boolean isText = extension.equalsIgnoreCase("TXT");
        if (isText) {
            encodeToUTF8(extension, count);
        } else {
            notTextExtension(extension, count);
        }

    }

    private void encodeToUTF8(String extension, int count) throws IOException {
        Reader reader = new FileReader(draft, ansi);
        Writer writer = new FileWriter(("src/utf8_text-" + count + "." + extension), utf8);
        char[] buffer = new char[1024];
        int length;
        while ((length = reader.read(buffer)) != -1) {
            writer.write(buffer, 0, length);
        }
        reader.close();
        writer.close();
    }

    private void notTextExtension(String extension, int count) throws IOException {
        FileInputStream fis = new FileInputStream(draft);
        FileOutputStream fos = new FileOutputStream("src/result-" + count + "." + extension);
        byte[] buffer = new byte[10240];
        int length;
        while ((length = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, length);
        }
        fis.close();
        fos.close();
    }
}
