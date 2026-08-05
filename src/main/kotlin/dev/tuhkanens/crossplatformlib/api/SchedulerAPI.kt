package dev.tuhkanens.crossplatformlib.api

interface SchedulerAPI {
    fun getSyncExecutor(executor: (() -> Unit) -> Unit)
}