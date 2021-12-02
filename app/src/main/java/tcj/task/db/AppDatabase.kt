package tcj.task.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tcj.task.network.AllApiData

@Database(entities = [AllApiData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): AppDao
}