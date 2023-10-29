package com.app.ichsanulalifwan.barani.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.ichsanulalifwan.barani.core.data.repository.news.NewsRepository
import com.app.ichsanulalifwan.barani.core.di.Injection
import com.app.ichsanulalifwan.barani.ui.profil.ProfilViewModel
import com.app.ichsanulalifwan.barani.ui.report.LaporViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory private constructor(private val repository: NewsRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ProfilViewModel::class.java) -> {
                ProfilViewModel() as T
            }

            modelClass.isAssignableFrom(LaporViewModel::class.java) -> {
                LaporViewModel() as T
            }

            else -> throw Throwable("Unknown ViewModel Class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(application: Application, isMock: Boolean): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(application, isMock)).apply {
                    instance = this
                }
            }
    }
}