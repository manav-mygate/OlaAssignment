package com.mygate.ola.engine

import com.mygate.ola.model.GitApiData

interface IGitHubList {
    fun getData():List<GitApiData?>?
}