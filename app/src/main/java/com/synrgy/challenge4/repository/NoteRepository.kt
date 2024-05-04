package com.synrgy.challenge4.repository

import com.synrgy.challenge4.database.NoteDatabase
import com.synrgy.challenge4.model.Note

class NoteRepository (private val db:NoteDatabase) {

    suspend fun insertNote(note: Note) = db.getNotDao()
    suspend fun deleteNote(note: Note) = db.getNotDao()
    suspend fun updateNote(note: Note) = db.getNotDao()

    fun getAllNotes() = db.getNotDao().getAllNotes()
    fun seacrhNote(query: String?) = db.getNotDao().searchNote(query)
}