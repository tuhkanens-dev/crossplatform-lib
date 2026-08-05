package dev.tuhkanens.crossplatformlib.loader

import dev.tuhkanens.crossplatformlib.api.SchedulerAPI

abstract class SchedulerLoader : SchedulerAPI {

    private var syncExecutor: ((() -> Unit) -> Unit)? = null

    protected fun registerSyncExecutor(executor: (() -> Unit) -> Unit) {
        syncExecutor = executor
    }

    override fun getSyncExecutor(): (() -> Unit) -> Unit {
        return syncExecutor
            ?: error("Sync executor was not registered")
    }

}