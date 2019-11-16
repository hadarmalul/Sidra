package com.example.sidra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author Hadar Malul
 * @since 16.11.19
 */

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3;
    Double num1, num2;

    /**
     * et1,et2,et3 are edit text java components
     * num1 is the first number
     * num2 is the difference/ multiplication
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);

        /**
         * Connecting between the java components to the xml components
         */
    }


    public void next(View view) {

       String st1 = et1.getText().toString();
       String st2 = et1.getText().toString();
       String st3 = et3.getText().toString();

        /**
         * turning Editable into String
         */


        if ((st1.isEmpty()) || (st2.isEmpty()) || (st3.isEmpty())) {

            Toast.makeText(this, "Please fill the blank places or check if you spelled right", Toast.LENGTH_LONG ).show(); }

        else {

            num1 = Double.parseDouble(et2.getText().toString());
            num2 = Double.parseDouble(et3.getText().toString());

            Intent si = new Intent(this, Sidra.class);
            si.putExtra("sidra", st1);
            si.putExtra("first", num1);
            si.putExtra("d/m", num2);
            startActivity(si);

        }
    }
    /**
     * if the edit texts are blank show a toast
     * else turn st2,st3 int double and move to the next activity
     */
}