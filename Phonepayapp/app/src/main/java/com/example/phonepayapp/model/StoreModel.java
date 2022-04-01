package com.example.phonepayapp.model;

public class StoreModel {
    int storeImage;
    String storeName;
    String storeType;
    String storeDetail;
    String storeRating;
    String storeRatingCount;

    public StoreModel() {
    }

    public StoreModel(int storeImage, String storeName, String storeType, String storeDetail, String storeRating, String storeRatingCount) {
        this.storeImage = storeImage;
        this.storeName = storeName;
        this.storeType = storeType;
        this.storeDetail = storeDetail;
        this.storeRating = storeRating;
        this.storeRatingCount = storeRatingCount;
    }

    public int getStoreImage() {
        return storeImage;
    }

    public void setStoreImage(int storeImage) {
        this.storeImage = storeImage;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getStoreDetail() {
        return storeDetail;
    }

    public void setStoreDetail(String storeDetail) {
        this.storeDetail = storeDetail;
    }

    public String getStoreRating() {
        return storeRating;
    }

    public void setStoreRating(String storeRating) {
        this.storeRating = storeRating;
    }

    public String getStoreRatingCount() {
        return storeRatingCount;
    }

    public void setStoreRatingCount(String storeRatingCount) {
        this.storeRatingCount = storeRatingCount;
    }
}
