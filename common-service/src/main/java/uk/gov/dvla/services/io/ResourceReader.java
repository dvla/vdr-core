package uk.gov.dvla.services.io;

import java.io.IOException;

public interface ResourceReader {

    byte[] read(String resource) throws IOException;
}
