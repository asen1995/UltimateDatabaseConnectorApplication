package org.db.connectors;

public class Util {

    public String readFileFromClasspath(String fileName) {
        return getClass().getClassLoader().getResource(fileName).getFile();
    }
}
