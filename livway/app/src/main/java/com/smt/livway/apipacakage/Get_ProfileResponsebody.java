package com.smt.livway.apipacakage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Get_ProfileResponsebody {


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
        @SerializedName("roleId")
        @Expose
        private long roleId;
        @SerializedName("firstName")
        @Expose
        private String firstName;
        @SerializedName("lastName")
        @Expose
        private String lastName;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("mobileNumber")
        @Expose
        private String mobileNumber;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("countryId")
        @Expose
        private long countryId;
        @SerializedName("zipcode")
        @Expose
        private String zipcode;
        @SerializedName("refferalCode")
        @Expose
        private Object refferalCode;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("googleId")
        @Expose
        private Object googleId;
        @SerializedName("facebookId")
        @Expose
        private Object facebookId;
        @SerializedName("avatar")
        @Expose
        private String avatar;
        @SerializedName("status")
        @Expose
        private long status;
        @SerializedName("about")
        @Expose
        private String about;
        @SerializedName("createdAt")
        @Expose
        private String createdAt;
        @SerializedName("updatedAt")
        @Expose
        private String updatedAt;
        @SerializedName("storeId")
        @Expose
        private long storeId;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getRoleId() {
            return roleId;
        }

        public void setRoleId(long roleId) {
            this.roleId = roleId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public long getCountryId() {
            return countryId;
        }

        public void setCountryId(long countryId) {
            this.countryId = countryId;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public Object getRefferalCode() {
            return refferalCode;
        }

        public void setRefferalCode(Object refferalCode) {
            this.refferalCode = refferalCode;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Object getGoogleId() {
            return googleId;
        }

        public void setGoogleId(Object googleId) {
            this.googleId = googleId;
        }

        public Object getFacebookId() {
            return facebookId;
        }

        public void setFacebookId(Object facebookId) {
            this.facebookId = facebookId;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public long getStatus() {
            return status;
        }

        public void setStatus(long status) {
            this.status = status;
        }

        public String getAbout() {
            return about;
        }

        public void setAbout(String about) {
            this.about = about;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public long getStoreId() {
            return storeId;
        }

        public void setStoreId(long storeId) {
            this.storeId = storeId;
        }
    }
}
