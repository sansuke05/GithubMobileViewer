package com.alicelab.githubmobileviewer.repository

import com.alicelab.githubmobileviewer.model.Project
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    // プロジェクト一覧
    @GET("users/{user_id}/repos")
    suspend fun getProjectList(@Path("user_id") userId: String): Response<List<Project>>

    // プロジェクト詳細
    @GET("/repos/{user_id}/{repo_name}")
    suspend fun getProjectDetails(@Path("user_id") userId: String, @Path("repo_name") projectName: String): Response<Project>
}