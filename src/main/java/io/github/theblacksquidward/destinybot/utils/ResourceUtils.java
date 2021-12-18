package io.github.theblacksquidward.destinybot.utils;

import org.jetbrains.annotations.Nullable;

import java.io.*;

public class ResourceUtils {

    //TODO proof and document

    public static final ResourceUtils INSTANCE = new ResourceUtils();

    public InputStream getFileAsIOStream(final String fileName) {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);
        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }

    public @Nullable String getKeyFromFile(InputStream inputStream) {
        try (InputStreamReader isr = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(isr))
        {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getDestinyAPIKey() {
        try (FileReader fileReader = new FileReader("secrets/destiny_api_key.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                return bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
