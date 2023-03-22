package ru.vtb.configuration.server.repo.move

interface IMoveDictServiceRepo {
    fun srvArrowsMove(
        newServiceId: String,
        newProfile: String,
        serviceId: String,
        profile: String
    ): Int

    fun abstractServiceMove(
        newServiceId: String,
        newProfile: String,
        serviceId: String,
        profile: String
    ): Int

    fun flinkPropValueMove(
        newServiceId: String,
        newProfile: String,
        serviceId: String,
        profile: String
    ): Int

    fun serviceGroupMove(
        newServiceId: String,
        newProfile: String,
        serviceId: String,
        profile: String
    ): Int

    fun serviceNodeMove(
        newServiceId: String,
        newProfile: String,
        serviceId: String,
        profile: String
    ): Int


    fun placeHolderByServiceMove(
        newServiceId: String,
        newProfile: String,
        serviceId: String,
        profile: String
    ): Int

}