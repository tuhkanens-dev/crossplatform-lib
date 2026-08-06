package dev.tuhkanens.crossplatformlib.bootstrap

import dev.tuhkanens.crossplatformlib.api.SchedulerAPI

abstract class SchedulerBootstrap : SchedulerAPI {

    private lateinit var syncExecutor: (() -> Unit) -> Unit
    private lateinit var asyncExecutor: (() -> Unit) -> Unit

    protected fun registerSyncExecutor(executor: (() -> Unit) -> Unit) {
        syncExecutor = executor
    }

    protected fun registerAsyncExecutor(executor: (() -> Unit) -> Unit) {
        asyncExecutor = executor
    }

    override fun runSync(task: () -> Unit) {
        if (!::syncExecutor.isInitialized) return
        syncExecutor(task)
    }

    override fun runAsync(task: () -> Unit) {
        if (!::asyncExecutor.isInitialized) return
        asyncExecutor(task)
    }

}