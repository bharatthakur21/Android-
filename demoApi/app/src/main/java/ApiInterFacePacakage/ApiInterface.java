package ApiInterFacePacakage;

import com.google.gson.JsonObject;

import ApiInputAndResponsePacakage.DataInputClass;
import ApiInputAndResponsePacakage.DataResponseClass;
import ApiInputAndResponsePacakage.SecondPageResponse;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {


    @POST("login")
    Call<DataResponseClass> loginApi (@Body DataInputClass dataInputClass);


    @GET("get-stores")
    Call<SecondPageResponse> homeApi(@Header("Authorization") String givetoken);

    @Multipart
    @POST ("upload-profile-pic")
    Call<JsonObject>  uploadprofilePicApi (@Header("Authorization") String  accessToken, @Part MultipartBody.Part profileImage);

}


