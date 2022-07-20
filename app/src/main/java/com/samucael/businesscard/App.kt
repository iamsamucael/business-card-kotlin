package com.samucael.businesscard

import android.app.Application
import com.samucael.businesscard.data.AppDatabase
import com.samucael.businesscard.data.BusinessCardRepository

class App : Application() {

    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }

}