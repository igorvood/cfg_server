package ru.vtb.configuration.server.repo.move

interface IMoveDictServiceRepo {
    fun srvArrowsMove(
        newId: String,
        newProfile: String,
        id: String,
        profile: String
    ): Int

    fun abstractServiceMove(
        newId: String,
        newProfile: String,
        id: String,
        profile: String
    ): Int

    fun flinkPropValueMove(
        newId: String,
        newProfile: String,
        id: String,
        profile: String
    ): Int

    fun serviceGroupMove(
        newId: String,
        newProfile: String,
        id: String,
        profile: String
    ): Int

    fun serviceNodeMove(
        newId: String,
        newProfile: String,
        id: String,
        profile: String
    ): Int


    fun placeHolderByServiceMove(
        newId: String,
        newProfile: String,
        id: String,
        profile: String
    ): Int

}