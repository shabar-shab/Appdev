package com.example.Shabir_Ahmad142_appdev;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

   private  List<DataList> dataLists;
    private Context context;

//    public DataAdapter(@NonNull FirebaseRecyclerOptions<DataList> options) {
//        super(options);
//    }


    public DataAdapter(List<DataList> dataLists, Context context) {
        this.dataLists = dataLists;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
         DataList dataList = dataLists.get(position);
        holder.city_Name.setText("City Name: "+dataList.getCityName());
        holder.locality_Name.setText("Locality Name: "+dataList.getLocalityName());
        holder.owner_Name.setText("Owner Name: "+dataList.getOwnerName());
        holder.phone_Number.setText("Owner Number: "+dataList.getPhoneNumber());
        holder.preffered_Language.setText("Preferred Language: "+dataList.getPrefferededLanguae());
        holder.property_Name.setText("Property Name: "+dataList.getPropertyName());
        holder.application_status.setText("Application Status: "+dataList.getApplicationStatus());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailedDataList.class);
                intent.putExtra("selected user", dataLists.get(position));
                 context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView city_Name;
        public TextView locality_Name;
        public TextView owner_Name;
        public TextView phone_Number;
        public TextView preffered_Language;
        public TextView property_Name;
        public TextView application_status;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            city_Name = (TextView) itemView.findViewById(R.id.city_editText_data);
            locality_Name = (TextView) itemView.findViewById(R.id.locality_editText_data);
            owner_Name = (TextView) itemView.findViewById(R.id.owner_name_data);
            phone_Number = (TextView) itemView.findViewById(R.id.phone_number_data);
            preffered_Language= (TextView) itemView.findViewById(R.id.preffered_language_data);
            property_Name = (TextView) itemView.findViewById(R.id.property_name_data);
            application_status = (TextView) itemView.findViewById(R.id.applications_status_data);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout_dataList);

        }
    }
}
