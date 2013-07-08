package uk.gov.dvla.core;


import junit.framework.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TestChecksumTool {

    @Test
    public void testChecksumCreation() throws Exception
    {
        String aTextFilePath = this.getClass().getClassLoader().getResource("a.txt").getFile();
        String aTextShaFilePath = this.getClass().getClassLoader().getResource("a.txt.sha").getFile();
        String generatedChecksum = ChecksumTool.generateSha256Checksum(aTextFilePath);

        Assert.assertEquals("Checksum does not match expected", readFileContents(aTextShaFilePath), generatedChecksum);
    }

    @Test
    public void testChecksumComparison() throws Exception
    {
        String aTextFilePath = this.getClass().getClassLoader().getResource("a.txt").getFile();
        String aTextShaFilePath = this.getClass().getClassLoader().getResource("a.txt.sha").getFile();
        Assert.assertTrue(ChecksumTool.isValidChecksum(aTextFilePath, readFileContents(aTextShaFilePath)));
    }

    private String readFileContents(String filePath) throws Exception
    {
        FileInputStream fin =  new FileInputStream(filePath);
        BufferedReader myInput = new BufferedReader(new InputStreamReader(fin));
        StringBuilder sb = new StringBuilder();
        String thisLine = null;
        while ((thisLine = myInput.readLine()) != null) {
            sb.append(thisLine);
        }
        return sb.toString();
    }
}
