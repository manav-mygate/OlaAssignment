package com.mygate.ola.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mygate.ola.engine.EngineImpl
import com.mygate.ola.engine.IEngine
import com.mygate.ola.engine.IGitHubList
import com.mygate.ola.model.GitApiData
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class GitViewModel(val iEngine:IEngine) : ViewModel() {

    val gitData = MutableLiveData<List<GitApiData?>>()

    @Subscribe
    fun getGitData(event: IGitHubList) {
        gitData.postValue(event.getData())
    }

    fun fetchGitData(){
        EventBus.getDefault().register(this);
        iEngine.getGitData();
    }


    override fun onCleared() {
        super.onCleared()
        EventBus.getDefault().unregister(this);
    }
}