package com.rizaldev.debtcollector.api;

import com.rizaldev.debtcollector.models.User;

import io.reactivex.Observable;
import io.reactivex.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * Created by devel on 22/10/2017.
 */

public interface DebtApi {
    @FormUrlEncoded
    @POST("login.php")
    Call<User> login(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("register.php")
    Call<User> register(@Field("username") String username, @Field("email") String email, @Field("password") String password, @Field("name") String name, @Field("phone") String phone, @Field("address") String address, @Field("city") String city, @Field("province") String province, @Field("postal_code") String postal_code);
}
