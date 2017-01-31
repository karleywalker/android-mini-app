package cs4720.cs.virginia.edu.BucketListActivity;

/**
 * The adapter class that handles how a BucketItem appears in the RecyclerView
 */

import android.app.LauncherActivity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BucketListAdapter extends RecyclerView.Adapter<BucketListAdapter.ItemHolder> {

    private List<BucketItem> listData;
    private LayoutInflater inflater;

    public BucketListAdapter (List<BucketItem> listData, Context c){
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.bucket_item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        BucketItem item = listData.get(position);
        holder.name.setText(item.getName());
        holder.desc.setText(item.getDescription());
        String s = "" + item.getLatitude();
        holder.lat.setText(s);
        String t = "" + item.getLongitude();
        holder.longi.setText(t);

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView desc;
        private TextView lat;
        private TextView longi;
        private View container;


        public ItemHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.rvContacts);
            container = itemView.findViewById(R.id.container_item_root);
        }
    }

}