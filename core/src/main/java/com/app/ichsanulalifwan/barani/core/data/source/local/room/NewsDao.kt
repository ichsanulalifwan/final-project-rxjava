package com.app.ichsanulalifwan.barani.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.ichsanulalifwan.barani.core.data.source.local.entity.NewsEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface NewsDao {

    /**
     * Load data.
     */
    @Query("SELECT * FROM news_entities")
    fun allByFlowable(): Flowable<List<NewsEntity>>

    @Query("SELECT * FROM news_entities")
    fun allBySingle(): Single<List<NewsEntity>>

    /**
     * Insert data.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAsCompletable(newsEntities: List<NewsEntity>): Completable

    @Query("DELETE FROM news_entities")
    fun deleteAsCompletable() : Completable
}