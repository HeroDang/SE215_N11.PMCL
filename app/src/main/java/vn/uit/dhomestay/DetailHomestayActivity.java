package vn.uit.dhomestay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.uit.dhomestay.adapters.CommentAdapter;
import vn.uit.dhomestay.models.CommentModel;

public class DetailHomestayActivity extends AppCompatActivity {

    private CommentAdapter adapter;
    private List<CommentModel> commentModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_homestay);

        generateDummyData();
        setUpView();
    }

    private void setUpView(){
        ImageView btnBack = findViewById(R.id.btnBack);

        RecyclerView rvListRate = findViewById(R.id.rvListRate);
        TextView btnAllComment = findViewById(R.id.btnAllComment);
        adapter = new CommentAdapter(commentModels);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvListRate.setLayoutManager(layoutManager);
        rvListRate.setAdapter(adapter);

        btnAllComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailHomestayActivity.this, AllCommentActivity.class);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void generateDummyData() {
        CommentModel comment1 = new CommentModel("Hồ Đăng",3, "10/02/2023", "Đang đi homestay");
        CommentModel comment2 = new CommentModel("Phạm Phong",4, "08/02/2023", "Đang đi homestay");
        CommentModel comment3 = new CommentModel("Dặng Hùng",2, "04/02/2023", "Đang đi homestay");
        CommentModel comment4 = new CommentModel("Phùng Khôi",5, "24/01/2023", "Đang đi homestay");
        commentModels.add(comment1);
        commentModels.add(comment2);
        commentModels.add(comment3);
        commentModels.add(comment4);
    }
}