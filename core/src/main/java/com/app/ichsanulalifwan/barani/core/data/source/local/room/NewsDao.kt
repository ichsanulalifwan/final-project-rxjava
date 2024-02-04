package com.app.ichsanulalifwan.barani.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.ichsanulalifwan.barani.core.data.source.local.entity.NewsEntity
import com.app.ichsanulalifwan.barani.core.data.source.local.entity.PublisherEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    /* RxJava */

    /**
     * Load data.
     */
    @Query("SELECT * FROM news_entities")
    fun allNewsByFlowable(): Flowable<List<NewsEntity>>

    @Query("SELECT * FROM publisher_entities")
    fun allPublisherByFlowable(): Flowable<List<PublisherEntity>>

    /**
     * Insert data.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewsAsCompletable(newsEntities: List<NewsEntity>): Completable

    @Query("DELETE FROM news_entities")
    fun deleteNewsAsCompletable(): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPublisherAsCompletable(publisherEntities: List<PublisherEntity>): Completable

    @Query("DELETE FROM publisher_entities")
    fun deletePublisherAsCompletable(): Completable


    /* Kotlin FLow */

    /**
     * Load data.
     */
    @Query("SELECT * FROM news_entities")
    fun allNewsByFlow(): Flow<List<NewsEntity>>

    @Query("SELECT * FROM publisher_entities")
    fun allPublisherByFlow(): Flow<List<PublisherEntity>>

    /**
     * Insert data.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(newsEntities: List<NewsEntity>)

    @Query("DELETE FROM news_entities")
    suspend fun deleteAllNews()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPublisher(publisherEntities: List<PublisherEntity>)

    @Query("DELETE FROM publisher_entities")
    suspend fun deleteAllPublishers()

    /* Reactor */

    /**
     * Load data.
     */
    @Query("SELECT * FROM news_entities")
    fun allNewsByFlux(): Flowable<List<NewsEntity>>

    @Query("SELECT * FROM publisher_entities")
    fun allPublisherByFlux(): Flowable<List<PublisherEntity>>

    /**
     * Insert data.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewsAsMono(newsEntities: List<NewsEntity>): Completable

    @Query("DELETE FROM news_entities")
    fun deleteAllNewsAsMono(): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPublisherAsMono(publisherEntities: List<PublisherEntity>): Completable

    @Query("DELETE FROM publisher_entities")
    fun deleteAllPublishersAsMono(): Completable
}