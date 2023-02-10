package vn.uit.dhomestay.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.slider.RangeSlider;

import java.util.ArrayList;
import java.util.List;

import vn.uit.dhomestay.DetailFillterActivity;
import vn.uit.dhomestay.DetailHomestayActivity;
import vn.uit.dhomestay.R;
import vn.uit.dhomestay.adapters.HomestayAdapter;
import vn.uit.dhomestay.interfaces.Callback;
import vn.uit.dhomestay.models.HomestayModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FilterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilterFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView tvPriceMin, tvPriceMax;
    EditText edtSearch;
    ImageView btnSearch, imgFilter;
    RangeSlider rsPrice;
    int count = 0;
    private HomestayAdapter adapter;
    private List<HomestayModel> homestayModels = new ArrayList<>();
    private List<HomestayModel> filterHomestayModels = new ArrayList<>();

    private String filterByName;

    public FilterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FilterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FilterFragment newInstance(String param1, String param2) {
        FilterFragment fragment = new FilterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_filter, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        generateDummyData();
        setUpView(view);
    }

    private void filterHomestayByName(String name){
        for (HomestayModel homestayModel : homestayModels){
            if(homestayModel.getName().contains(name)){
                filterHomestayModels.add(homestayModel);
            }
        }
        adapter.updateData(filterHomestayModels);
    }

    private void setUpView(View view){
        RecyclerView rvListHomestays = view.findViewById(R.id.rvListHomestays);
        adapter = new HomestayAdapter(homestayModels, new Callback() {
            @Override
            public void onItemClick(int position, HomestayModel item) {
                openDetailActivity(position, item);
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvListHomestays.setLayoutManager(layoutManager);
        rvListHomestays.setAdapter(adapter);


        rsPrice = view.findViewById(R.id.rsPrice);
        tvPriceMin = view.findViewById(R.id.tvPriceMin);
        tvPriceMax = view.findViewById(R.id.tvPriceMax);
        btnSearch = view.findViewById(R.id.btnSearch);
        edtSearch = view.findViewById(R.id.edtSearch);
        imgFilter = view.findViewById(R.id.imgFilter);

        rsPrice.addOnChangeListener(new RangeSlider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull RangeSlider slider, float value, boolean fromUser) {
                List list = slider.getValues();
                int max = Math.round((float)list.get(1));
                int min = Math.round((float)list.get(0));

                tvPriceMin.setText(String.valueOf(min) + " triệu");
                tvPriceMax.setText(" - " + String.valueOf(max) + " triệu");
            }
        });

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filterByName = edtSearch.getText().toString();
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, filterByName, Toast.LENGTH_SHORT).show();
                filterHomestayByName(filterByName);
            }
        });

        imgFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailFillterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void openDetailActivity(int position, HomestayModel item){
        Intent intent = new Intent(getActivity(), DetailHomestayActivity.class);
        startActivity(intent);
    }

    private void generateDummyData() {
        HomestayModel homestay1 = new HomestayModel("Hoa mai",5,4,4);
        HomestayModel homestay2 = new HomestayModel("Hoa dừa",4,6,5);
        HomestayModel homestay3 = new HomestayModel("Hoa hồng",3,8,7);
        HomestayModel homestay4 = new HomestayModel("Hoa cúc",2,10,9);
        homestayModels.add(homestay1);
        homestayModels.add(homestay2);
        homestayModels.add(homestay3);
        homestayModels.add(homestay4);
    }
}