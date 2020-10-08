package com.alicelab.githubmobileviewer.repository

import com.alicelab.githubmobileviewer.model.Project
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProjectRepository {
    private val HTTPS_API_GITHUB_URL = "https://api.github.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(HTTPS_API_GITHUB_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var githubService: GithubService = retrofit.create(GithubService::class.java)

    // APIにリクエスト -> レスポンスをコルーチンで受け取る(プロジェクト一覧)
    suspend fun getProjectList(userId: String): Response<List<Project>> =
        githubService.getProjectList(userId)

    // APIにリクエスト -> レスポンスをコルーチンで受け取る(プロジェクト詳細)
    suspend fun getProjectDetails(userId: String, projectName: String): Response<Project> =
        githubService.getProjectDetails(userId, projectName)

    // singletonでRepositoryインスタンスを返すFactory
    companion object Factory {
        val instance: ProjectRepository
            @Synchronized get() {
                return ProjectRepository()
            }
    }
}