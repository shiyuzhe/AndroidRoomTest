package com.syz.androidroomtest.data.room.dao

import androidx.room.*
import com.syz.androidroomtest.data.room.bean.User
import io.reactivex.Flowable
import io.reactivex.Observable

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user")
    fun getAllUser(): Observable<List<User>>

    /**
     * @Query methods: Room supports return values of type Publisher, Flowable, and Observable.
     */
    @Query("SELECT * FROM user")
    fun getAllUser2(): Flowable<List<User>>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    /**
     * @Insert,
     * @Update, and
     * @Delete
     * methods: Room 2.1.0 and higher supports return values of type Completable, Single<T>, and Maybe<T>.
     *
     *
     * onConflict = OnConflictStrategy.REPLACE 主键冲突，重复插入时替换原有数据
     */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}