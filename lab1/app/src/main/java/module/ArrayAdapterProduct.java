package module;

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

import com.example.lab1.R;

import org.w3c.dom.Text;

public class ArrayAdapterProduct extends ArrayAdapter<Product> {
    Activity context;
    int resource;
    public ArrayAdapterProduct( Activity context, int resource){
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater= context.getLayoutInflater();
        View spView = layoutInflater.inflate(R.layout.item_product,null);
        ImageView imgPro = spView.findViewById(R.id.imgPro);
        TextView txtNamePro = spView.findViewById(R.id.txtNamePro);
        TextView txtPricePro = spView.findViewById(R.id.txtPricePro);
        Product sp = getItem(position);
        imgPro.setImageResource(sp.getImagePro());
        txtNamePro.setText(sp.getNamePro());
        txtPricePro.setText(sp.getPriPro()+ "VND");
        return spView;
    }
}
