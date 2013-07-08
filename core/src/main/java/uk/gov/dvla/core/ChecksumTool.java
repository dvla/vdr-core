package uk.gov.dvla.core;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/**
 * Class used to create checksum
 */
public class ChecksumTool {

    /**
     *
     * @param fileInput
     * @return
     * @throws Exception
     */
    public static String generateSha256Checksum(File fileInput) throws Exception
    {
        FileInputStream fis = new FileInputStream(fileInput);
        byte[] b = createChecksum(fis);
        String result = "";
        for (int i=0; i < b.length; i++) {
            result +=
                    Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }

    public static String generateSha256Checksum(String filename) throws Exception
    {
        return generateSha256Checksum(new File(filename));
    }

    public static boolean isValidChecksum(File fileInput, String checksum) throws Exception
    {
        return generateSha256Checksum(fileInput).equalsIgnoreCase(checksum);
    }

    public static boolean isValidChecksum(String filename, String checksum) throws Exception
    {
        return isValidChecksum(new File(filename), checksum);
    }

    private static byte[] createChecksum(FileInputStream fileInputStream) throws Exception
    {
        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("SHA-256");
        int numRead;
        do {
            numRead = fileInputStream.read(buffer);
            if (numRead > 0) {
                complete.update(buffer, 0, numRead);
            }
        } while (numRead != -1);
        fileInputStream.close();
        return complete.digest();
    }
}
