package dev.tuhkanens.crossplatformlib.api

interface SchedulerAPI {
    fun getSyncExecutor(): (() -> Unit) -> Unit
}