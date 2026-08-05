package dev.tuhkanens.crossplatformlib.loader

import dev.tuhkanens.crossplatformlib.api.SchedulerAPI

abstract class SchedulerLoader : SchedulerAPI {

    abstract val syncExecutor: (() -> Unit) -> Unit

}