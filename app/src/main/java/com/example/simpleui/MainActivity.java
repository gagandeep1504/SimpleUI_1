package com.example.simpleui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private CheckBox checkBox;
    private Button btnStart;
    private RadioGroup radioGroup;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.txtHello);
        textView.setText("Hello Android lovers");

        Button btnHello = (Button) findViewById(R.id.helloBtn);

        editText = (EditText)findViewById(R.id.editText);
        String text = editText.getText().toString();

        checkBox = (CheckBox)findViewById(R.id.checkbox);

        progressBar = findViewById(R.id.progressBar);
         Thread thread = new Thread(new Runnable() {
             @Override
             public void run() {
                 for(int i=0;i<10;i++){
                     progressBar.incrementProgressBy(10);
                     try {
                         Thread.sleep(1000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }
         });
         thread.start();

        Button btnStart = (Button)findViewById(R.id.btnStart);
         radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

    }
    public void onBtnClick(View view){
        TextView textView = (TextView) findViewById(R.id.txtHello);

        textView.setVisibility(View.VISIBLE);
    }
    public void start(View view){
        if(checkBox.isChecked()){
            System.out.println("It is checked");
        }else{
            System.out.println("It is not checked");
        }
        checkBox.setChecked(true);

        int id = radioGroup.getCheckedRadioButtonId();
        switch(id){
            case R.id.rbMale:
                editText.setText("Male");
                break;
            case R.id.rbFemale:
                 editText.setText("Female");
                 break;
            case R.id.rbOther:
                editText.setText("Other");
                break;
            default:
                break;
        }
    }
}
