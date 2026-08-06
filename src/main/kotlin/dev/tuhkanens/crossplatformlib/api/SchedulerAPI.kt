package dev.tuhkanens.crossplatformlib.api

interface SchedulerAPI {
    fun runSync(task: () -> Unit)
    fun runAsync(task: () -> Unit)
}