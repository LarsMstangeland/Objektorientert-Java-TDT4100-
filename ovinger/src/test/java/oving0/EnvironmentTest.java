package oving0;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Denne testen sjekker om du har riktig versjon av Java installert.
 */
public class EnvironmentTest {

    private static final int RECOMMENDED_JAVA_VERSION = 17;

    @Test
    public void testJavaVersion() {
        int javaVersionNumber = this.getVersion();
        assertEquals(RECOMMENDED_JAVA_VERSION, javaVersionNumber, "Feil javaversjon! Vi anbefaler at dere bruker " + RECOMMENDED_JAVA_VERSION);
    }

    private int getVersion() {
        String version = System.getProperty("java.version");

        if (version.startsWith("1.")) {
            version = version.substring(2, 3);
        } else {
            int dot = version.indexOf(".");
            if (dot != -1) {
                version = version.substring(0, dot);
            }
        }

        return Integer.parseInt(version);
    }
}
