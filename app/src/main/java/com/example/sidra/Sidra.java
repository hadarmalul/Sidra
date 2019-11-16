package com.example.sidra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Sidra extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnCreateContextMenuListener {

    String s;
    Double num1, num2, n;
    Double [] numbers = new Double[20];
    ListView lv;
    int p;
    TextView tv;

    /**
     * s is the type of the progression
     * num1 is the first number
     * num2 is the difference/ multiplication
     * n is the number in position n
     * p is the position of the selected number
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidra);

        lv = (ListView) findViewById(R.id.lv);
        tv = (TextView) findViewById(R.id.tv);
        /**
         * Connecting between the java components to the xml components
         */

        Intent gi = getIntent();
        s = gi.getStringExtra("sidra");
        num1 = gi.getDoubleExtra("first", 0.0);
        num2 = gi.getDoubleExtra("d/m", 0.0);

        numbers[0] = num1;

        if (s.equals("Arithmetic")) {

            for (int i = 1; i < 20; i++) {

                numbers[i] = numbers[i - 1] + num2;
            }
        }
        else {

            for (int i = 1; i < 20; i++){

                numbers[i] = numbers[i - 1] * num2;
            }
        }
        /**
         * filling the array according to the progression type
         */

        ArrayAdapter<Double> adp = new ArrayAdapter<Double>(this,R.layout.support_simple_spinner_dropdown_item, numbers);
        lv.setAdapter(adp);

        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(this);
        lv.setOnCreateContextMenuListener(this);
        /**
         * making the list view and setting its features
         */

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        p = position;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo ){

        menu.add("position");
        menu.add("sum");

    }

    /**
     * making the context menu
     */

    public boolean onContextItemSelected(MenuItem item){
        String st = item.getTitle().toString();
        if (st.equals("position")){
            tv.setText("position:" +(p+1));
        }
        else {
            if(s.equals("Arithmetic")){
                n = (num1+(p*num2));
                tv.setText("sum:"+ (p+1)*((num1+n)/2));}
            else {
                n = num1* (Math.pow(num2,(p+1)));
                tv.setText("sum:"+ (num1*((Math.pow(num2,(p+1))-1)))/(num2-1));
            }


        }
        return super.onContextItemSelected(item);
    }

    /**
     * setting the text according to the item that is chosen on the context menu
     */

    public void back(View view) {
        finish();
    }

    /**
     * if back is clicked the screen moves to the main activity
     */

    public void credits(View view) {
        Intent si2 = new Intent(this, Credits.class);
        startActivity(si2);

    }
    /**
     * if credits is clicked the screen moves to the credits activity
     */
}
