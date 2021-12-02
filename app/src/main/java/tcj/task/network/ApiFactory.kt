package tcj.task.network

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import io.reactivex.Observable

interface ApiFactory {

    @GET("/alldata.php")
    fun getAllData(): Observable<Response<AllDataResponse>>

    companion object Factory {
        fun create(): ApiFactory {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://apidev.tjcg.in")
                .build()

            return retrofit.create(ApiFactory::class.java)
        }
    }
}