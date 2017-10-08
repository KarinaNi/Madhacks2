package edu.purdue.singh387.madhacks;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Shrehit Goel on 10/7/2017.
 */

public class TextInput extends AppCompatActivity {

    private ArrayList<String> output;

    /*public TextInput(ArrayList<String> x)
    {
        output=x;
    }*/
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //output.add("jsbfjsbjfs");
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);*/
        textview = (TextView) findViewById(R.id.textView);
        output = MainActivity.arraylist;
        String p = "";
        for(int i = 0;i<output.size();i++){
            p=p+output.get(i)+"\n";
        }
        textview.setText(p);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }}
