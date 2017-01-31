package cs4720.cs.virginia.edu.BucketListActivity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    private RecyclerView RecyclerView;
    private BucketListAdapter adapter;
    private LinearLayoutManager LinearLayoutManager;


    //making the list~~~
    public static String[] names = {"Streak the Lawn", "Lighting of the Lawn", "High-Five Dean Groves"};
    public static String[] descs = {"Go run around the homesr statue and come back.", "Have a great time and see some lights",
        "Just put your hand right on his hand!"};
    public static double[] lats = {38.0889, 38.0881, 38.0887};
    public static double[] longs = {-78.5596, -78.5593, -78.5591};

    public static List<BucketItem> getListData(){
        List<BucketItem> mdata = new ArrayList<>();

        for(int i = 0; i < names.length; i++) {
            BucketItem item = new BucketItem();
            item.setName(names[i]);
            item.setDescription(descs[i]);
            item.setLongitude(longs[i]);
            item.setLatitude(lats[i]);
            mdata.add(item);
        }
        return mdata;
    }
    //end of list setup - probably should move that????



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //generate items from the activity-main xml
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<BucketItem> mdata = getListData();
        adapter = new BucketListAdapter(mdata, this);

        RecyclerView.setAdapter(adapter);

        //access the RecyclerView from the main activity
        RecyclerView = (RecyclerView) findViewById(R.id.rvContacts);
        LinearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.setLayoutManager(LinearLayoutManager);

        //generate floating action button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This button doesn't do anything yet", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
