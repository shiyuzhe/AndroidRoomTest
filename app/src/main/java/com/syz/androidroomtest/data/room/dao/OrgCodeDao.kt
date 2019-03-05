package com.syz.androidroomtest.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.syz.androidroomtest.data.room.bean.OrgCode
import io.reactivex.Flowable

/**
 *   @ClassName: OrgCodeDao
 *   @Date: 2019/3/5 11:09 AM
 *   @Author: syz
 *   @Description:
 */

@Dao
interface OrgCodeDao {

    /**
     * @Query methods: Room supports return values of type Publisher, Flowable, and Observable.
     */
    @Query("SELECT * FROM OrgCode")
    fun getOrgCodes(): Flowable<List<OrgCode>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg orgCode: OrgCode)
}