package daniel.t2s;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech t2s;
    EditText text;
    Button b1;
    private Spinner spinner1;
    final Locale locSpanish = new Locale("spa", "MEX");
    Locale locLang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=(EditText)findViewById(R.id.editText);
        b1=(Button)findViewById(R.id.button);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        String []opciones={"Spanish","English","French","German"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);


        t2s=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    //t2s.setLanguage(Locale.UK);
                    t2s.setLanguage(locSpanish);
                }
            }
        });
    }

    public void speak (View view){

        String selec=spinner1.getSelectedItem().toString();
        if(selec.equals("Spanish")){
            locLang = locSpanish;
        }else
        if(selec.equals("English")){
            locLang = Locale.ENGLISH;
        }else
        if(selec.equals("French")){
            locLang = Locale.FRENCH;
        }else
        if(selec.equals("German")){
            locLang = Locale.GERMAN;
        }
        t2s.setLanguage(locLang);
        String toSpeak = text.getText().toString();
        t2s.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null, null);
        //t2s.speak()
    }

}
