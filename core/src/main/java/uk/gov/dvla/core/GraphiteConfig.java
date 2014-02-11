package uk.gov.dvla.core;

import javax.validation.constraints.NotNull;

public class GraphiteConfig {
    @NotNull
    public String status = "on";

    @NotNull
    public String server = "localhost";

    @NotNull
    public Integer port = 2003;

    @NotNull
    public Integer timeoutSecs = 5;

    @Override
    public String toString() {
        return String.format("GraphiteConfiguration: Status $s Server %s  Port: %s DB: %s Timeout(secs): %s", status, server, port, timeoutSecs);
    }

}