package vn.uit.dhomestay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import vn.uit.dhomestay.adapters.CommentAdapter;
import vn.uit.dhomestay.models.CommentModel;

public class AllCommentActivity extends AppCompatActivity {

    private CommentAdapter adapter;
    private List<CommentModel> commentModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_comment);

        generateDummyData();
        setUpView();
    }

    private void setUpView(){
        ImageView btnBack = findViewById(R.id.btnBack);

        RecyclerView rvListRate = findViewById(R.id.rvListComment);
        adapter = new CommentAdapter(commentModels);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvListRate.setLayoutManager(layoutManager);
        rvListRate.setAdapter(adapter);

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
        CommentModel comment5 = new CommentModel("Hồ Đăng",3, "10/02/2023", "Đang đi homestay");
        CommentModel comment6 = new CommentModel("Phạm Phong",4, "08/02/2023", "Đang đi homestay");
        CommentModel comment7 = new CommentModel("Dặng Hùng",2, "04/02/2023", "Đang đi homestay");
        CommentModel comment8 = new CommentModel("Phùng Khôi",5, "24/01/2023", "Đang đi homestay");
        CommentModel comment9 = new CommentModel("Hồ Đăng",3, "10/02/2023", "Đang đi homestay");
        CommentModel comment10 = new CommentModel("Phạm Phong",4, "08/02/2023", "Đang đi homestay");
        CommentModel comment11 = new CommentModel("Dặng Hùng",2, "04/02/2023", "Đang đi homestay");
        CommentModel comment12 = new CommentModel("Phùng Khôi",5, "24/01/2023", "Đang đi homestay");
        commentModels.add(comment1);
        commentModels.add(comment2);
        commentModels.add(comment3);
        commentModels.add(comment4);
        commentModels.add(comment5);
        commentModels.add(comment6);
        commentModels.add(comment7);
        commentModels.add(comment8);
        commentModels.add(comment9);
        commentModels.add(comment10);
        commentModels.add(comment11);
        commentModels.add(comment12);
    }
}