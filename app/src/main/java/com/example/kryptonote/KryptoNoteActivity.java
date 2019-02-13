package com.example.kryptonote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class KryptoNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kryptonote_layout);
    }

    public void onEncrypt(View v) {

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

    }

    public void onSave(View v) {

    }

    public void onLoad(View v) {

    }

    }



