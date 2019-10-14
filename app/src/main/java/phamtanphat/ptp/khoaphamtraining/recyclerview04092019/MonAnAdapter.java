package phamtanphat.ptp.khoaphamtraining.recyclerview04092019;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MonAnAdapter extends RecyclerView.Adapter<MonAnAdapter.MonanViewHolder> {

    //Các bước thự thi trong adapter
    // 1 : Định nghĩa ra lớp ViewHolder (Quan lý các view trong 1 dòng)
    // 2 : Kết thừa RecyclerView.Adapter<ViewHolder>
    // 3 : Định nghĩa các phương thức trong adapter
    ArrayList<MonAn> mArraysMonAn;
    private OnItemClickListener mOnItemClickListener;


    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public MonAnAdapter(ArrayList<MonAn> mArraysMonAn) {
        this.mArraysMonAn = mArraysMonAn;
    }

    @NonNull
    @Override
    public MonanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_mon_an,null);
        return new MonanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonanViewHolder holder, int position) {
        MonAn monAn = mArraysMonAn.get(position);
        holder.txtTen.setText(monAn.getTen());
        holder.txtGia.setText(monAn.getGia() + " ");
        holder.txtMota.setText(monAn.getMota());
        holder.img.setImageResource(monAn.getHinhanh());
    }

    @Override
    public int getItemCount() {
        /*
        Cách 1
        if (mArraysMonAn == null){
            return 0;
        }
        return mArraysMonAn.size();

        */
        return mArraysMonAn == null ? 0 : mArraysMonAn.size();
    }



    class MonanViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txtTen,txtGia,txtMota;
        public MonanViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageviewMonAn);
            txtTen = itemView.findViewById(R.id.textviewTen);
            txtGia = itemView.findViewById(R.id.textviewGia);
            txtMota = itemView.findViewById(R.id.textviewMoTa);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onClick(view, getLayoutPosition());
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mOnItemClickListener.onLongClick(view, getLayoutPosition());
                    return true;
                }
            });
        }
    }
}
