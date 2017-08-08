package cs4720.cs.virginia.edu.BucketListActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Collections;
import java.util.List;

/**
 * An Activity that lets a user edit an item already on the list and is pre-populated on launch
 */

public class EditItemActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        String clickname = MainActivity.getclickname();
        List<BucketItem> mdata = BucketItem.getMdata();
        int x = 0;
        for(int i = 0; i < mdata.size(); i++){
            if(mdata.get(i).getName() == clickname){
                x = i;
            }
        }
        final int y = x;
        BucketItem item = mdata.get(x);

        EditText text = (EditText) findViewById(R.id.editText7);
        text.setText(item.getName());
        text = (EditText) findViewById(R.id.editText8);
        text.setText(item.getDescription());
        text = (EditText) findViewById(R.id.editText9);
        text.setText(item.getLatitude());
        text = (EditText) findViewById(R.id.editText10);
        DatePicker picker = (DatePicker) findViewById(R.id.datePicker3);
        picker.updateDate(item.getYear(), item.getMonth(), item.getDay());
        text.setText(item.getLongitude());


        //onclick method
        Button button = (Button) findViewById(R.id.edit_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //edit in the list of BucketItem
                List<BucketItem> mdata = BucketItem.getMdata();
                EditText edit = (EditText) findViewById(R.id.editText7);
                mdata.get(y).setName(edit.getText().toString());
                edit = (EditText) findViewById(R.id.editText8);
                mdata.get(y).setDescription(edit.getText().toString());
                edit = (EditText) findViewById(R.id.editText9);
                mdata.get(y).setLatitude(edit.getText().toString());
                edit = (EditText) findViewById(R.id.editText10);
                mdata.get(y).setLongitude(edit.getText().toString());
                DatePicker d = (DatePicker) findViewById(R.id.datePicker3);
                mdata.get(y).setDay(d.getDayOfMonth());
                mdata.get(y).setMonth(d.getMonth());
                mdata.get(y).setYear(d.getYear());
                Collections.sort(mdata);
                BucketItem.setMdata(mdata);
                //Intent intent = new Intent(EditItemActivity.this, MainActivity.class);
                //startActivity(new Intent(intent));
                finishAfterTransition();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
