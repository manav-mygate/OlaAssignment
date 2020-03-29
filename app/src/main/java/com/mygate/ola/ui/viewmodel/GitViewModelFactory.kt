package com.mygate.ola.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mygate.ola.engine.EngineImpl
import com.mygate.ola.engine.IEngine

class GitViewModelFactory : ViewModelProvider.Factory {

    private val iEngine:IEngine by lazy{
       EngineImpl()
    }

    companion object {
        private val gitViewModelFactory = GitViewModelFactory()
        fun getInstance(): GitViewModelFactory {
            return gitViewModelFactory;
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(GitViewModel::class.java) -> GitViewModel(iEngine) as T
            else -> throw IllegalArgumentException("Unknown model class $modelClass")

        }
    }

}