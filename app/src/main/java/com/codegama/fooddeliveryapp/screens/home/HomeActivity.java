package com.codegama.fooddeliveryapp.screens.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.codegama.fooddeliveryapp.R;
import com.codegama.fooddeliveryapp.screens.Constant;


import com.codegama.fooddeliveryapp.screens.categorymodel.Categories;
import com.codegama.fooddeliveryapp.screens.categorymodel.CategoriesResponse;
import com.codegama.fooddeliveryapp.screens.retrofit.ApiInterface;
import com.codegama.fooddeliveryapp.screens.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    ViewPager viewPager;
    private int dotscount;
    private ImageView[] dots;
    LinearLayout sliderDotspanel;
    RecyclerView categoryRecyclerView;
    CategoriesAdapter categoriesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager = findViewById(R.id.viewPager);
        sliderDotspanel = findViewById(R.id.SliderDots);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];
        for (int i = 0; i < dotscount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(), R.drawable.nonactive_dot
            ));
            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDotspanel.addView(dots[i], params);

        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }


            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<CategoriesResponse> call = apiInterface.getCategories(Constant.ApiKEy);
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading..");
        progressDialog.show();
        call.enqueue(new Callback<CategoriesResponse>() {
            @Override
            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
                progressDialog.dismiss();
                CategoriesResponse categoriesResponse = response.body();
                getCategoryData(categoriesResponse);
            }

            @Override
            public void onFailure(Call<CategoriesResponse> call, Throwable t) {
                Toast.makeText(HomeActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();


            }
        });
    }

    private void getCategoryData(CategoriesResponse categoriesResponse) {
        List<ImageList> imageListLis = new ArrayList<>();
        imageListLis.add(new ImageList(R.drawable.deliveryhome));
        imageListLis.add(new ImageList(R.drawable.dineouthome));
        imageListLis.add(new ImageList(R.drawable.nightlighhome));
        imageListLis.add(new ImageList(R.drawable.catchinguphome));
        imageListLis.add(new ImageList(R.drawable.takeawayhome));
        imageListLis.add(new ImageList(R.drawable.cafehome));
        imageListLis.add(new ImageList(R.drawable.dailymenuhome));
        imageListLis.add(new ImageList(R.drawable.breakfasthome));
        imageListLis.add(new ImageList(R.drawable.lunchhome));
        imageListLis.add(new ImageList(R.drawable.deliveryhome));
        imageListLis.add(new ImageList(R.drawable.pubsandbar));
        imageListLis.add(new ImageList(R.drawable.poketfrendlyhome));
        imageListLis.add(new ImageList(R.drawable.clubsandlounges));
        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);
        categoriesAdapter = new CategoriesAdapter(this, categoriesResponse.getCategories(), imageListLis);
        categoryRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        categoryRecyclerView.setAdapter(categoriesAdapter);

    }


}