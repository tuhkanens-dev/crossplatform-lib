package dev.tuhkanens.crossplatformlib.loader

import dev.tuhkanens.crossplatformlib.api.SchedulerAPI

abstract class SchedulerLoader : SchedulerAPI {

    abstract override fun getSyncExecutor(executor: (() -> Unit) -> Unit)

}