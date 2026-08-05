package dev.tuhkanens.crossplatformlib.loader

import dev.tuhkanens.crossplatformlib.api.SchedulerAPI

abstract class SchedulerLoader : SchedulerAPI {

    private lateinit var syncExecutor: (() -> Unit) -> Unit

    protected fun registerSyncExecutor(
        executor: (() -> Unit) -> Unit
    ) {
        syncExecutor = executor
    }

    override fun runSync(task: () -> Unit) {
        if (!::syncExecutor.isInitialized) return
        syncExecutor(task)
    }

}