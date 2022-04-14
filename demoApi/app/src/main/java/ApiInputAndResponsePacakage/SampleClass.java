package ApiInputAndResponsePacakage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SampleClass {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("next_page")
    @Expose
    private boolean nextPage;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public boolean isNextPage() {
        return nextPage;
    }

    public void setNextPage(boolean nextPage) {
        this.nextPage = nextPage;
    }

    public class Datum {

        @SerializedName("id")
        @Expose
        private long id;
        @SerializedName("userId")
        @Expose
        private long userId;
        @SerializedName("storeLogo")
        @Expose
        private String storeLogo;
        @SerializedName("storeName")
        @Expose
        private String storeName;
        @SerializedName("isFollow")
        @Expose
        private long isFollow;
        @SerializedName("totalFollowers")
        @Expose
        private long totalFollowers;

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

        public String getStoreLogo() {
            return storeLogo;
        }

        public void setStoreLogo(String storeLogo) {
            this.storeLogo = storeLogo;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public long getIsFollow() {
            return isFollow;
        }

        public void setIsFollow(long isFollow) {
            this.isFollow = isFollow;
        }

        public long getTotalFollowers() {
            return totalFollowers;
        }

        public void setTotalFollowers(long totalFollowers) {
            this.totalFollowers = totalFollowers;
        }


    }
}

