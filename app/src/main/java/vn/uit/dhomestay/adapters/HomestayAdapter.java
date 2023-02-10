package vn.uit.dhomestay.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.uit.dhomestay.R;
import vn.uit.dhomestay.interfaces.Callback;
import vn.uit.dhomestay.models.HomestayModel;

public class HomestayAdapter extends RecyclerView.Adapter<HomestayAdapter.ViewHolder> {
    private List<HomestayModel> homestayModels;
    private TextView tvNameHomestay, tvNumStar, tvComment, tvPrice;
    public Callback callback;

    public HomestayAdapter(List<HomestayModel> homestayModels, Callback callback) {
        this.homestayModels = homestayModels;
        this.callback = callback;
    }

    public void updateData(List<HomestayModel> homestayModels){
        this.homestayModels = homestayModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_item_homestay,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomestayModel item = homestayModels.get(position);
        View view = holder.getView();
        mapToView(view);
        setDataToView(item, view, position);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onItemClick(holder.getOldPosition(),item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return homestayModels.size();
    }

    private void mapToView(View view){
        tvNameHomestay = view.findViewById(R.id.tvNameHomestay);
        tvNumStar = view.findViewById(R.id.tvNumStar);
        tvComment = view.findViewById(R.id.tvComment);
        tvPrice = view.findViewById(R.id.tvPrice);
    }

    private void setDataToView(HomestayModel item,View view, int position){
        tvNameHomestay.setText(item.getName());
        tvNumStar.setText(String.valueOf((item.getNumStar())));
        tvComment.setText(String.valueOf((item.getNumComt())) + " nhận xét");
        tvPrice.setText(String.valueOf((item.getNumStar())) + " triệu");
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }

        View getView() { return view;}
    }
}
