package dev.tuhkanens.crossplatformlib.api

interface SchedulerAPI {
    fun runAsync(task: () -> Unit)
}