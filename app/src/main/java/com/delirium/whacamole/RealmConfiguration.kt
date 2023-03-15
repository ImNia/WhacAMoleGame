package com.delirium.whacamole

import io.realm.RealmConfiguration

class RealmConfiguration {
    private val config: RealmConfiguration =
        RealmConfiguration.Builder()
            .name("bestResult.realm")
            .schemaVersion(1)
            .build()

    fun getConfigDB() = config
}