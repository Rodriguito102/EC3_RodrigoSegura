package com.rodrigo.ec3_rodrigosegura;

import android.os.Parcel;
import android.os.Parcelable;

public class MenuItem implements Parcelable {
    private String name; // Modificado de dishName a name
    private String description;
    private String imageUrl;
    private String ingredients;
    private double price;

    public MenuItem(String name, String description, String imageUrl, String ingredients, double price) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.ingredients = ingredients;
        this.price = price;
    }

    protected MenuItem(Parcel in) {
        name = in.readString();
        description = in.readString();
        imageUrl = in.readString();
        ingredients = in.readString();
        price = in.readDouble();
    }

    public static final Creator<MenuItem> CREATOR = new Creator<MenuItem>() {
        @Override
        public MenuItem createFromParcel(Parcel in) {
            return new MenuItem(in);
        }

        @Override
        public MenuItem[] newArray(int size) {
            return new MenuItem[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(imageUrl);
        dest.writeString(ingredients);
        dest.writeDouble(price);
    }
}
