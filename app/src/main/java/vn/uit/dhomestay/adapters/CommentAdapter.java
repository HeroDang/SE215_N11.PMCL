package vn.uit.dhomestay.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.uit.dhomestay.R;
import vn.uit.dhomestay.models.CommentModel;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private List<CommentModel> commentModels;
    private TextView tvName, tvDayRated, tvComment;
    private RatingBar rtRated;

    public CommentAdapter(List<CommentModel> commentModels) {
        this.commentModels = commentModels;
    }

    public void updateData(List<CommentModel> commentModels){
        this.commentModels = commentModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_item_comment_homestay,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CommentModel item = commentModels.get(position);
        View view = holder.getView();
        mapToView(view);
        setDataToView(item, view, position);
    }

    @Override
    public int getItemCount() {
        return commentModels.size();
    }

    private void mapToView(View view){
        tvName = view.findViewById(R.id.tvName);
        tvDayRated = view.findViewById(R.id.tvDayRated);
        tvComment = view.findViewById(R.id.tvComment);
        rtRated = view.findViewById(R.id.rtRated);
    }

    private void setDataToView(CommentModel item,View view, int position){
        tvName.setText(item.getName());
        tvDayRated.setText((item.getDay()));
        tvComment.setText(item.getComment());
        rtRated.setRating(item.getNumStar());
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
