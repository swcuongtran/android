package com.example.lab1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    Activity context;
    int resource;
    public SanPhamAdapter(Activity context, int resource){
        super(context,resource);
        this.context = context;
        this.resource = resource;
    }
    public View Getview(int position, @Nullable View convertView, @Nullable ViewGroup parent){
        LayoutInflater inflater = this.context.getLayoutInflater();
        View viewsp=inflater.inflate(this.resource,null);
        ImageView imgHinh=viewsp.findViewById(R.id.imageView11);
        TextView txtTensp =viewsp.findViewById(R.id.textView16);
        TextView txtMotaSP=viewsp.findViewById(R.id.textView17);
        TextView txtGiaSP = viewsp.findViewById(R.id.textView18);
        SanPham sanPham = getItem(position);
        imgHinh.setImageResource(sanPham.getHinhsp());
        txtTensp.setText(sanPham.getTensp());
        txtMotaSP.setText(sanPham.getMotasp());
        txtGiaSP.setText(sanPham.getGiasp());
        return viewsp;
    }
}

