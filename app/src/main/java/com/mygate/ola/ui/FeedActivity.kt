package com.mygate.ola.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mygate.ola.R
import com.mygate.ola.model.GitApiData
import com.mygate.ola.ui.viewmodel.GitViewModel
import com.mygate.ola.ui.viewmodel.GitViewModelFactory

class FeedActivity : AppCompatActivity() {

    var factory: GitViewModelFactory = GitViewModelFactory.getInstance()

    private val viewModel:GitViewModel by lazy {
       ViewModelProviders.of(this,factory).get(GitViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(supportActionBar!=null)
            supportActionBar!!.hide();

        viewModel.fetchGitData()
        viewModel.gitData.observe(this,gitDataObserver)

    }

    private val gitDataObserver=Observer<List<GitApiData?>>{
        if(it!=null && it.size>0){

        }
    }
}
