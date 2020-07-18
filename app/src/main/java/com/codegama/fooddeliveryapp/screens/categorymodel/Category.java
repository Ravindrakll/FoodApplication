
package com.codegama.fooddeliveryapp.screens.categorymodel;

import com.google.gson.annotations.SerializedName;


public class Category {

    @SerializedName("categories")
    private Categories mCategories;

    public Categories getCategories() {
        return mCategories;
    }

    public void setCategories(Categories categories) {
        mCategories = categories;
    }

}
