package tcj.task.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import rx.Completable
import tcj.task.network.AllApiData

@Dao
interface AppDao {
//    @Query("SELECT * FROM user")
//    fun getAll(): List<User>
//
//    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): List<User>
//
//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): User
//
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<AllApiData>) : Completable
//
//    @Delete
//    fun delete(user: User)
}