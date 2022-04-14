package com.smt.livway.apipacakage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SellerResponseclass {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public class Data {

        @SerializedName("id")
        @Expose
        private long id;
        @SerializedName("userId")
        @Expose
        private long userId;
        @SerializedName("storeName")
        @Expose
        private String storeName;
        @SerializedName("storeEmail")
        @Expose
        private String storeEmail;
        @SerializedName("storePhone")
        @Expose
        private String storePhone;
        @SerializedName("storeLogo")
        @Expose
        private String storeLogo;
        @SerializedName("storeBanner")
        @Expose
        private String storeBanner;
        @SerializedName("countryId")
        @Expose
        private long countryId;
        @SerializedName("stateId")
        @Expose
        private long stateId;
        @SerializedName("storeCity")
        @Expose
        private String storeCity;
        @SerializedName("storeZipcode")
        @Expose
        private String storeZipcode;
        @SerializedName("storeStatus")
        @Expose
        private long storeStatus;
        @SerializedName("totalShares")
        @Expose
        private long totalShares;
        @SerializedName("description")
        @Expose
        private Object description;
        @SerializedName("rejectMessage")
        @Expose
        private Object rejectMessage;
        @SerializedName("isPopular")
        @Expose
        private boolean isPopular;
        @SerializedName("sortOrder")
        @Expose
        private long sortOrder;
        @SerializedName("createdAt")
        @Expose
        private String createdAt;
        @SerializedName("updatedAt")
        @Expose
        private Object updatedAt;
        @SerializedName("totalFollowers")
        @Expose
        private long totalFollowers;
        @SerializedName("totalFollowing")
        @Expose
        private long totalFollowing;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public String getStoreEmail() {
            return storeEmail;
        }

        public void setStoreEmail(String storeEmail) {
            this.storeEmail = storeEmail;
        }

        public String getStorePhone() {
            return storePhone;
        }

        public void setStorePhone(String storePhone) {
            this.storePhone = storePhone;
        }

        public String getStoreLogo() {
            return storeLogo;
        }

        public void setStoreLogo(String storeLogo) {
            this.storeLogo = storeLogo;
        }

        public String getStoreBanner() {
            return storeBanner;
        }

        public void setStoreBanner(String storeBanner) {
            this.storeBanner = storeBanner;
        }

        public long getCountryId() {
            return countryId;
        }

        public void setCountryId(long countryId) {
            this.countryId = countryId;
        }

        public long getStateId() {
            return stateId;
        }

        public void setStateId(long stateId) {
            this.stateId = stateId;
        }

        public String getStoreCity() {
            return storeCity;
        }

        public void setStoreCity(String storeCity) {
            this.storeCity = storeCity;
        }

        public String getStoreZipcode() {
            return storeZipcode;
        }

        public void setStoreZipcode(String storeZipcode) {
            this.storeZipcode = storeZipcode;
        }

        public long getStoreStatus() {
            return storeStatus;
        }

        public void setStoreStatus(long storeStatus) {
            this.storeStatus = storeStatus;
        }

        public long getTotalShares() {
            return totalShares;
        }

        public void setTotalShares(long totalShares) {
            this.totalShares = totalShares;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public Object getRejectMessage() {
            return rejectMessage;
        }

        public void setRejectMessage(Object rejectMessage) {
            this.rejectMessage = rejectMessage;
        }

        public boolean isIsPopular() {
            return isPopular;
        }

        public void setIsPopular(boolean isPopular) {
            this.isPopular = isPopular;
        }

        public long getSortOrder() {
            return sortOrder;
        }

        public void setSortOrder(long sortOrder) {
            this.sortOrder = sortOrder;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public Object getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Object updatedAt) {
            this.updatedAt = updatedAt;
        }

        public long getTotalFollowers() {
            return totalFollowers;
        }

        public void setTotalFollowers(long totalFollowers) {
            this.totalFollowers = totalFollowers;
        }

        public long getTotalFollowing() {
            return totalFollowing;
        }

        public void setTotalFollowing(long totalFollowing) {
            this.totalFollowing = totalFollowing;
        }
    }
}
