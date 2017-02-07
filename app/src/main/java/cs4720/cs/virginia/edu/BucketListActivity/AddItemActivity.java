package cs4720.cs.virginia.edu.BucketListActivity;

/**
 * An Activity that lets a user add an item to the list
 */

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;


import java.util.List;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        //onclick method
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent();
                EditText edit = (EditText) findViewById(R.id.editText7);
                i.putExtra("title_key", edit.getText().toString());
                edit = (EditText) findViewById(R.id.editText8);
                i.putExtra("desc_key", edit.getText().toString());
                edit = (EditText) findViewById(R.id.editText9);
                i.putExtra("lat_key", edit.getText().toString());
                edit = (EditText) findViewById(R.id.editText10);
                i.putExtra("lon_key", edit.getText().toString());
                DatePicker dp = (DatePicker) findViewById(R.id.datePicker3);
                i.putExtra("day_key", String.valueOf(dp.getDayOfMonth()));
                i.putExtra("mo_key", String.valueOf(dp.getMonth()));
                i.putExtra("yr_key", String.valueOf(dp.getYear()));
                setResult(Activity.RESULT_OK, i);
                finish();

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            Intent returnIntent = new Intent();
            setResult(Activity.RESULT_CANCELED, returnIntent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}