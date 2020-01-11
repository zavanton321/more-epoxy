package ru.zavanton.epoxy.app

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import timber.log.Timber

class CustomDebugTree : Timber.DebugTree() {

    init {
        Logger.addLogAdapter(AndroidLogAdapter())
    }

    override fun createStackElementTag(element: StackTraceElement): String? {
        return "(${element.fileName}:${element.lineNumber})#${element.methodName}"
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {

        Logger.log(priority, tag, message, t)
    }
}