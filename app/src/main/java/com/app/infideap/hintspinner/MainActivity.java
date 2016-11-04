package com.app.infideap.hintspinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner withoutHintSpinner = (Spinner) findViewById(R.id.spinner_withoutHint);
        final Spinner withHintSpinner = (Spinner) findViewById(R.id.spinner_withHint);

        Gson gson = new Gson();
        try {
            final List<Phone> phones =
                    Arrays.asList(gson.fromJson(readFromAsset("data/phone.json"), Phone[].class));

            withoutHintSpinner.setAdapter(new SpinnerArrayAdapter<Phone>(
                    MainActivity.this, android.R.layout.simple_spinner_dropdown_item, phones)
            );

            withHintSpinner.setAdapter(new SpinnerArrayAdapter<Phone>(
                    MainActivity.this, android.R.layout.simple_spinner_dropdown_item, phones,
                    "-Select a Phone-")
            );


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method use to read data from Asset Resource Directory (Local).
     *
     * @param path path of the local REST
     * @return plain text from file
     * @throws IOException
     */
    private String readFromAsset(String path) throws IOException {

        byte[] buffer;
        InputStream inputStream;
        try {
            inputStream = getAssets().open(path);
        } catch (IOException e) {
//            e.a(new Throwable("Local file must store in Asset Resource Folder."));
            IOException ioException = new IOException(e.toString() + "\n\r" +
                    "Local REST must store in Asset Resource Folder.");
            ioException.setStackTrace(e.getStackTrace());
            throw ioException;
//            throw new IOException();

        }
        int size = inputStream.available();

        if (size == 0) {
        }

        buffer = new byte[size];

        inputStream.read(buffer);
        inputStream.close();


        return new String(buffer);

    }
}
