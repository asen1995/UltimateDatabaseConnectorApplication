package org.db.connectors;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Component
public class SQLResources {

    public static String CREATE_PRODUCT_MARIA_DB;
    public static String GET_PRODUCT_BY_ID_MARIA_DB;

    static {
        try {
            CREATE_PRODUCT_MARIA_DB = readFully("/mariaDB/sql/crud/insert_product.sql");
            GET_PRODUCT_BY_ID_MARIA_DB = readFully("/mariaDB/sql/crud/get_product_by_id.sql");
        } catch (Exception e) {
            throw new RuntimeException("Error occured reading sql resources " + e.getMessage());
        }
    }

    private static String readFully(String path) throws IOException {
        InputStream in = SQLResources.class.getResourceAsStream(path);
        InputStreamReader streamReader = new InputStreamReader(in, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        StringBuilder queryBuilder = new StringBuilder();
        for (String line; (line = reader.readLine()) != null; ) {
            queryBuilder.append(line);
        }

        in.close();
        streamReader.close();
        reader.close();

        return queryBuilder.toString();
    }
}
