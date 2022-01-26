package com.example.inostudioTask.domain.repository

import com.example.inostudioTask.data.dataSource.dto.ActorEntity
import com.example.inostudioTask.data.remote.dto.*
import com.example.inostudioTask.data.dataSource.dto.FilmEntity
import kotlinx.coroutines.flow.StateFlow

interface FilmRepository {

    val filmListFlow: StateFlow<List<FilmEntity>>
    val actorListFlow: StateFlow<List<ActorEntity>>

    suspend fun getFilms(
        apiKey: String,
        page: Int,
        language: String
    ): List<Film>

    suspend fun getFilmsById(
        apiKey: String,
        id: String,
        language: String,
        additionalInfo: String
    ): Film

    suspend fun getFilmsBySearch(
        apiKey: String,
        query: String,
        page: Int,
        language: String
    ): List<Film>

    suspend fun getReviewList(
        apiKey: String,
        id: String,
        page: Int,
        language: String
    ): List<ReviewResponse>

    suspend fun getActorsList(
        apiKey: String,
        page: Int,
        language: String
    ): List<Actor>

    suspend fun getActorDetails(
        apiKey: String,
        personId: String,
        language: String,
        additionalInfo: String
    ): Actor

    suspend fun insertFilmDatabase(film: FilmEntity)

    suspend fun deleteFilmDatabase(film: FilmEntity)

    suspend fun getFilmsByIdDatabase(id: Int): FilmEntity?

    suspend fun insertActorDatabase(actor: ActorEntity)

    suspend fun deleteActorDatabase(actor: ActorEntity)

    suspend fun getActorByIdDatabase(id: Int): ActorEntity?

    fun addFavoriteActor(actor: Actor)

    fun addFavoriteFilm(film: Film)
}