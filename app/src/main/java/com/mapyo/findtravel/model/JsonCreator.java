package com.mapyo.findtravel.model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;

public class JsonCreator {
    public static String readFromAssets(Context context, String fileName) throws IOException {
        AssetManager assetManager = context.getResources().getAssets();
        InputStream inputStream = assetManager.open(fileName);

        byte[] readBytes = new byte[inputStream.available()];
        inputStream.read(readBytes);
        return new String(readBytes);
    }
}
