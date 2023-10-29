package com.app.ichsanulalifwan.barani.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.ichsanulalifwan.barani.core.data.source.local.entity.NewsEntity
import com.app.ichsanulalifwan.barani.core.data.source.local.entity.PublisherEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface NewsDao {

    /**
     * Load data.
     */
    @Query("SELECT * FROM news_entities")
    fun allNewsByFlowable(): Flowable<List<NewsEntity>>

    @Query("SELECT * FROM news_entities")
    fun allNewsBySingle(): Single<List<NewsEntity>>

    @Query("SELECT * FROM publisher_entities")
    fun allPublisherByFlowable(): Flowable<List<PublisherEntity>>

    @Query("SELECT * FROM publisher_entities")
    fun allPublisherBySingle(): Single<List<PublisherEntity>>

    /**
     * Insert data.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewsAsCompletable(newsEntities: List<NewsEntity>): Completable

    @Query("DELETE FROM news_entities")
    fun deleteNewsAsCompletable() : Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPublisherAsCompletable(publisherEntities: List<PublisherEntity>): Completable

    @Query("DELETE FROM publisher_entities")
    fun deletePublisherAsCompletable() : Completable
}