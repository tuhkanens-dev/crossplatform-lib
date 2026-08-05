package dev.tuhkanens.crossplatformlib.api

interface SchedulerAPI {
    fun setSyncExecutor(executor: (() -> Unit) -> Unit)
}