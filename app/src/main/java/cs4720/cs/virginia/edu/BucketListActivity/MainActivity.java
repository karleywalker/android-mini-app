package cs4720.cs.virginia.edu.BucketListActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.security.cert.Certificate;
import java.util.Collections;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView RecyclerView;

    private LinearLayoutManager LinearLayoutManager;

    List<BucketItem> mdata = BucketItem.getMdata();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //generate items from the activity-main xml
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //generate a list of BucketItems

        Collections.sort(mdata);

        //access the RecyclerView from the main activity
        RecyclerView = (RecyclerView) findViewById(R.id.rvContacts);
        BucketListAdapter mAdapter = new BucketListAdapter(mdata, this);
        RecyclerView.setAdapter(mAdapter);
        LinearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.setLayoutManager(LinearLayoutManager);

        RecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        //generate floating action button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Go to next page", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddItemActivity.class);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (1) : {
                if (resultCode == Activity.RESULT_OK) {

                    String returnValue = data.getStringExtra("title_key");
                    String dValue = data.getStringExtra("desc_key");
                    String laValue = data.getStringExtra("lat_key");
                    String loValue = data.getStringExtra("lon_key");
                    int dyValue = Integer.parseInt(data.getStringExtra("day_key"));
                    int month_value = Integer.parseInt(data.getStringExtra("mo_key"));
                    int yrValue = Integer.parseInt(data.getStringExtra("yr_key"));
                    BucketItem item = new BucketItem();

                    item.setName(returnValue);
                    item.setDescription(dValue);
                    item.setLatitude(laValue);
                    item.setLongitude(loValue);
                    item.setDay(dyValue);
                    item.setMonth(month_value);
                    item.setYear(yrValue);
                    mdata.add(item);
                    Collections.sort(mdata);
                    //refresh
                    BucketListAdapter mAdapter = new BucketListAdapter(mdata, this);
                    RecyclerView.setAdapter(mAdapter);

                } else {
                    //you hit the back arrow
                }
                break;
            }
        }

    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Rotation stuff?
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Also rotation stuff? It won't crash? Hooray?
        super.onRestoreInstanceState(savedInstanceState);

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

    }

    private static String clickname;

    public static String getclickname() {
        return clickname;
    }

    public void setclickname(String clickname){
        this.clickname = clickname;
    }

    public void openItem(View view){
        TextView currentItem = (TextView)view;
        setclickname(currentItem.getText().toString());
        //Log.d("ListExample", "sendMessage to " + currentItem.getText().toString());
        //Toast.makeText(this, "Sending message to " + num, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, EditItemActivity.class);
        startActivity(new Intent(intent));

    }

    public void itemClicked(View view){
        //clicked on checkbox
    }

}