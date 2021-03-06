package cs4720.cs.virginia.edu.BucketListActivity;

/**
 * The adapter class that handles how a BucketItem appears in the RecyclerView
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BucketListAdapter extends RecyclerView.Adapter<BucketListAdapter.ItemHolder> {

    private ArrayList<BucketItem> listData;
    private LayoutInflater inflater;

    public BucketListAdapter (List<BucketItem> listData, Context c){
        this.inflater = LayoutInflater.from(c);
        this.listData = (ArrayList<BucketItem>) listData;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recyclerview_item_row, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        BucketItem item = listData.get(position);
        holder.name.setText(item.getName());
        String mDate = (item.getMonth()+1) + "-" + item.getDay() + "-" + item.getYear();
        holder.date.setText(mDate);

    }


    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void delete(int position) { //removes the row
        BucketItem duplicate = listData.get(position);
        listData.remove(position);
        notifyItemRemoved(position);
        addToEnd(duplicate);
    }

    public void addToEnd(BucketItem duplicate) { //removes the row
        listData.add(duplicate);
    }


    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView name;
        private TextView date;
        private View container;
        private CheckBox checkDisBox;


        public ItemHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.item_data);
            date = (TextView)itemView.findViewById(R.id.date);
            container = itemView.findViewById(R.id.container_item_root);

            checkDisBox = (CheckBox) itemView.findViewById(R.id.checkbox_item);
            checkDisBox.setOnClickListener(this);
            checkDisBox.setEnabled(true);
        }

        public void onClick(View v) {
            delete(getAdapterPosition()); //calls the method above to delete
            checkDisBox.setEnabled(false);
            checkDisBox.setChecked(true);
        }
    }

}