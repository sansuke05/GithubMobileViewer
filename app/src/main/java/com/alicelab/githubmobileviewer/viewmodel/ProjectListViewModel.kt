package com.alicelab.githubmobileviewer.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alicelab.githubmobileviewer.model.Project
import com.alicelab.githubmobileviewer.repository.ProjectRepository

class ProjectListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ProjectRepository.instance

    // 監視対象のLiveData
    var projectListLiveData: MutableLiveData<List<Project>> = MutableLiveData()

    // ViewModel初期化時にロード
    init {
        loadProjectList()
    }

    private fun loadProjectList() {
        // viewModelScope->ViewModel.onCleared() のタイミングでキャンセルされる CoroutineScope
    }
}