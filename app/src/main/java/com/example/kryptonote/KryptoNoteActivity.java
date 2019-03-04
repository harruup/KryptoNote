package com.example.kryptonote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import static android.widget.Toast.makeText;


public class KryptoNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kryptonote_layout);
    }

   /* public void onEncrypt(View v) {

        EditText editKey = findViewById(R.id.key);
        String givenKey = editKey.getText().toString();

        EditText editData = findViewById(R.id.data);
        String givenData = editData.getText().toString();


        CipherModel encryptText = new CipherModel(givenKey);
        String encryptedData = encryptText.encrypt(givenData);

        ((EditText) findViewById(R.id.data)).setText(encryptedData);

    }

    public void onDecrypt(View v) {

        EditText editKey = findViewById(R.id.key);
        String givenKey = editKey.getText().toString();

        EditText encryptedData = findViewById(R.id.data);
        String currentData = encryptedData.getText().toString();


        CipherModel decryptText = new CipherModel(givenKey);
        String decryptedData = decryptText.decrypt(currentData);

        ((EditText) findViewById(R.id.data)).setText(decryptedData);

    }*/
    public void onCipher(View v) {

        EditText editKey = findViewById(R.id.key);
        String givenKey = editKey.getText().toString();

        EditText editData = findViewById(R.id.data);
        String givenData = editData.getText().toString();

        CipherModel cipherText = new CipherModel(givenKey);

        switch(v.getId())
        {
            case R.id.encrypt:

                String encryptedData = cipherText.encrypt(givenData);
                ((EditText) findViewById(R.id.data)).setText(encryptedData);

            break;

            case R.id.decrypt:

                String decryptedData = cipherText.decrypt(givenData);
                ((EditText) findViewById(R.id.data)).setText(decryptedData);

            break;
        }
    }



    public void onSave(View v) {

        try
        {

            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileWriter fw = new FileWriter(file);
            fw.write(((EditText) findViewById(R.id.data)).getText().toString());
            fw.close();
            Toast label = Toast.makeText(this, "Note Saved.", Toast.LENGTH_LONG);
            label.show();

        }
        catch (Exception e) {

          Toast label= Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
          label.show();
        }
        }



    public void onLoad(View v) {

        try {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileReader fr = new FileReader(file);
            String show ="";
            for (int c = fr.read(); c != -1; c = fr.read())
            {
                show += (char) c;
            }
            fr.close();
            ((EditText) findViewById(R.id.data)).setText(show);
        }
        catch (Exception e) {

           Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
            label.show();
        }
    }

}



