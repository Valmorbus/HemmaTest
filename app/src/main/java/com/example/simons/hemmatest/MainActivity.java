package com.example.simons.hemmatest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();

                Intent useApp = new Intent(Intent.ACTION_SEND);
                useApp.setType("text/mail");
                useApp.putExtra(Intent.EXTRA_EMAIL, new String[]{"borgstrom.simon@gmail.com"});
                useApp.putExtra(Intent.EXTRA_SUBJECT, "Test att skicka från app");
                useApp.putExtra(Intent.EXTRA_TEXT, "Robin är fan sämst");

                startActivity(Intent.createChooser(useApp, "Välj Epostprogram"));
            }
        });
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
        
        // om många gör switch
        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this, "Du valde Settings", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.action_about){
            Intent i = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(i);

            Toast.makeText(MainActivity.this, "Du valde about", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
