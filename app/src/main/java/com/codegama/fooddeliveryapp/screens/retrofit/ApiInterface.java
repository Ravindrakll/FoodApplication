package com.codegama.fooddeliveryapp.screens.retrofit;



import com.codegama.fooddeliveryapp.screens.categorymodel.CategoriesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiInterface {
    @GET("categories")
    Call<CategoriesResponse> getCategories(@Header("user-key") String userKey);
}
