package tcj.task.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tcj.task.R
import tcj.task.databinding.ActivityMainBinding
import tcj.task.db.AppDatabase
import tcj.task.extras.MyAdapter
import tcj.task.network.ApiFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var appDatabase : AppDatabase

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        appDatabase = Room.databaseBuilder(this, AppDatabase::class.java,"MyDB").fallbackToDestructiveMigration().build()

        binding.myRcv.layoutManager = LinearLayoutManager(this)

        // It's not a good way to write this code
        // We can use MVVM Architecture with viewmodel and repository for this
        // Just to save some time, I write it here
        ApiFactory.create().getAllData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe ({ result ->
                if (result.isSuccessful && result.body() != null){
                    val myAdapter = MyAdapter(result.body()!!.data)
                    binding.myRcv.adapter = myAdapter
                    myAdapter.notifyDataSetChanged()

                    appDatabase.userDao().insertAll(result.body()!!.data)

                }
            }, { error ->

            })

    }
}