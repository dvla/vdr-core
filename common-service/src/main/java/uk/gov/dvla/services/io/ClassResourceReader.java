package uk.gov.dvla.services.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassResourceReader implements ResourceReader {

    public byte[] read(String resource) throws IOException {
        InputStream is = getClass().getResourceAsStream(resource);
        return readStream(is);
    }

    private byte[] readStream(InputStream is) throws IOException {
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream ous = new ByteArrayOutputStream();
        int read;
        while ((read = is.read(buffer)) != -1) {
            ous.write(buffer, 0, read);
        }
        is.close();
        return ous.toByteArray();
    }
}
