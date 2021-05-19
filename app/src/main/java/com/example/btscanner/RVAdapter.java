package com.example.btscanner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    Button Detail;
    private List<ScannedData> arrayList = new ArrayList<>();
    private Activity activity;

    public RVAdapter(Activity activity) {
        this.activity = activity;
    }
    /*清除搜尋到的裝置列表*/
    public void clearDevice(){
        this.arrayList.clear();
        notifyDataSetChanged();
    }
    /*若有不重複的裝置出現，則加入列表中*/
    public void addDevice(List<ScannedData> arrayList){
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAddress, tvInfo, tvRssi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.textView_DeviceName);
            tvAddress = itemView.findViewById(R.id.textView_Address);
            tvInfo = itemView.findViewById(R.id.textView_Rssi);
            tvRssi = itemView.findViewById(R.id.textView_Rssi);
            Detail=itemView.findViewById(R.id.ButDetail);
        }
    }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scanned_item,parent,false);
            return new ViewHolder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvName.setText(arrayList.get(position).getDeviceName());
        holder.tvAddress.setText("裝置位址："+arrayList.get(position).getAddress());
        holder.tvRssi.setText("訊號強度："+arrayList.get(position).getRssi());
        Detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent i =new Intent(context, Detail.class);
                Bundle bundle =new Bundle();
                bundle.putString("details",arrayList.get(position).getDeviceByteInfo());//要傳送的資料 key&value
                bundle.putString("devicename",arrayList.get(position).getDeviceName());
                bundle.putString("address",arrayList.get(position).getAddress());
                i.putExtras(bundle);
                context. startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
