package com.example.morsecodetranslator;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class TranslateActivity extends AppCompatActivity {

    TextView textTranslate,morseTranslate;
    EditText englishText;
    @SuppressLint("StaticFieldLeak")
    static TextView morseText;
    ImageView copy,copy1,paste,delete,share,share1;
    CardView change;
    ClipboardManager clipboardManager;
    boolean isEnglish = true;
    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        textTranslate = findViewById(R.id.english);
        morseTranslate = findViewById(R.id.morse);


        //text for writing a sentence
        englishText = findViewById(R.id.enText);
        morseText = findViewById(R.id.morseText);

        copy = findViewById(R.id.copy);
        copy1 = findViewById(R.id.copy1);
        paste = findViewById(R.id.paste);
        delete = findViewById(R.id.delete);
        share = findViewById(R.id.share);
        share1 = findViewById(R.id.share1);
        change = findViewById(R.id.change);

        char[] engAlphabet = { 'a', 'à', 'b', 'c', 'd', 'e', 'è', 'é',
                'f', 'g', 'h', 'i', 'ì', 'j', 'k', 'l',
                'm', 'n', 'o', 'ò', 'p', 'q', 'r', 's',
                't', 'u', 'ù', 'v', 'w', 'x', 'y', 'z',
                '1', '2', '3', '4', '5', '6', '7', '8',
                '9', '0', ' ', '(', '-', '¿', '&', ',',
                '?', '\'', ')', ':', '!', '$', ';', '.',
                '@', '\"', '/', '¡', '=', '_', '+'};

        String[] morseAlphabet = { ".-", ".--.-", "-...", "-.-.", "-..", ".", ".-..-", "..-..",
                "..-.", "--.", "....", "..", ".---.", ".---", "-.-", ".-..",
                "--", "-.", "---", "---.", ".--.", "--.-", ".-.", "...",
                "-", "..-", "..--", "...-", ".--", "-..-", "-.--", "--..",
                ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..",
                "----.", "-----", "/", "-.--.", "-....-", "..-.-", ".-...", "--..--",
                "..--..", ".----.", "-.--.-", "---...", "-.-.--", "...-..-", "-.-.-.", ".-.-.-",
                ".--.-.", ".-..-.", "-..-.", "--...-", "-...-", "..--.-", ".-.-."};

        englishText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                morseText.setText(R.string.preText);
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    stringToMorse(morseAlphabet,englishText.getText().toString(),engAlphabet);

            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        textTranslate.setText("English");
        morseTranslate.setText("Morse");
//        change.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                isEnglish = !isEnglish;
//                if (isEnglish){
//                    textTranslate.setText("English");
//                    morseTranslate.setText("Morse");
//                } else {
//                    textTranslate.setText("Morse");
//                    morseTranslate.setText("English");
//                    String e = englishText.getText().toString();
//
//                }
//            }
//        });

        delete.setOnClickListener(view -> ClearText());
        copy.setOnClickListener(view -> Copy(englishText.getText().toString()));
        copy1.setOnClickListener(view -> Copy(morseText.getText().toString()));
        paste.setOnClickListener(view -> Paste());
        share.setOnClickListener(view -> Share(englishText.getText().toString()));
        share1.setOnClickListener(view -> Share(morseText.getText().toString()));
    }

    // create a Clear function and clear the text
    public void ClearText(){
        englishText.getText().clear();
    }
    // create a Copy function and copy the text
    public void Copy(String input) {
        clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        if (!input.isEmpty()){
            ClipData clipData = ClipData.newPlainText("Copy",input);
            clipboardManager.setPrimaryClip(clipData);
        }else {
            Toast.makeText(this, "No Text Copied...", Toast.LENGTH_SHORT).show();
        }
    }
    // Create a paste function
    public void Paste(){
        ClipData.Item item = clipboardManager.getPrimaryClip().getItemAt(0);
        String output = (String) item.getText();

        if (!output.isEmpty()) {
            englishText.setText(output);
        } else {
            Toast.makeText(this, "No Text Paste...", Toast.LENGTH_SHORT).show();
        }
    }
    // Create a share function
    public void Share(String data){

        if (data.isEmpty()){
            Toast.makeText(this, "No Share Data..", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT,data);
            startActivity(intent);
        }
    }
    public void stringToMorse( String[] morseAlphabet, String a, char[] engAlphabet ){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < engAlphabet.length; j++) {
                if (a.charAt(i) == engAlphabet[j]) {
                    str.append(morseAlphabet[j]).append(" ");
                    break;
                }
            }
        }
        morseText.setText(str.toString());
    }

}