
package com.codegama.fooddeliveryapp.screens.categorymodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class CategoriesResponse {

    @SerializedName("categories")
    private List<Category> mCategories;

    public List<Category> getCategories() {
        return mCategories;
    }

    public void setCategories(List<Category> categories) {
        mCategories = categories;
    }

}
