package com.mapyo.findtravel;

import com.google.common.io.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

public class TestUtils {

    public static File getAssetFile(String name) throws FileNotFoundException {
        String[] appDirs = {".", "app"};
        for (String appDir : appDirs) {
            // todo 今回はassetsにjsonを直接置いているのでこのpathになっている
            // 通信してjsonを取りにいくようにするとなった時は、jsonの保存場所を変更する
            File file = new File(appDir, "src/main/assets/" + name);

            if (file.exists()) {
                return file;
            }
        }
        throw new FileNotFoundException("No resource file: " + name);
    }

    public static String getAssetFileString(String name) throws IOException {
        return Files.toString(getAssetFile(name), Charset.defaultCharset());
    }
}

