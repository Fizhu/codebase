package com.fizhu.base.api

import com.fizhu.base.BaseApp
import com.fizhu.base.common.Fungsiku
import com.google.gson.GsonBuilder
import com.kazee.waktoo.model.persetujuan.ContohResponse
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by fizhu on 26,December,2019
 * Hvyz.anbiya@gmail.com
 */
interface ApiServiceInterface {

    @FormUrlEncoded
    @POST(ApiEndPoint.ENDPOINT_GET_CONTOH)
    fun postContoh(
        @Field("name") name: String,
        @Field("token") token: String
    ): Observable<ContohResponse>

    @GET(ApiEndPoint.ENDPOINT_GET_CONTOH)
    fun getContoh(
        @Query("username") username: String
    ): Single<ContohResponse>

    @Multipart
    @POST(ApiEndPoint.ENDPOINT_GET_CONTOH)
    fun postContohMultipart(
        @Part("name") name: RequestBody,
        @Part("token") token: RequestBody,
        @Part file: MultipartBody.Part
    ): Single<ContohResponse>

    companion object Factory {
        fun create(): ApiServiceInterface {
            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(BaseApp.client!!)
                .baseUrl(Fungsiku.apiURL)
                .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}