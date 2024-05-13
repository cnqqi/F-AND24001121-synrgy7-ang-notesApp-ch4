package com.synrgy.challenge4.repository

import com.synrgy.challenge4.database.NoteDatabase
import com.synrgy.challenge4.model.Note

class NoteRepository (private val db:NoteDatabase) {

    suspend fun insertNote(note: Note) = db.getNotDao().insertNote(note)
    suspend fun deleteNote(note: Note) = db.getNotDao().deleteNote(note)
    suspend fun updateNote(note: Note) = db.getNotDao().updateNote(note)

    fun getAllNotes() = db.getNotDao().getAllNotes()
    fun searchNote(query: String?) = db.getNotDao().searchNote(query)
}