package com.cshawn.logger

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/*
 * Copyright (c) 2025 Shawn Chen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Description: 实现类
 *
 * Author: Shawn Chen
 * Date: 2025/5/9
 */
internal class Logger(private val tag: String) : ILogger {
    private val logger: Logger = LoggerFactory.getLogger(if (LogUtil.debug) "DEBUG_LOGGER" else "*")

    private fun getMessage(msg: String): String {
        return "$tag $msg"
    }

    override fun t(format: String, vararg arguments: Any) {
        logger.trace(getMessage(format), *arguments)
    }

    override fun d(format: String, vararg arguments: Any) {
        logger.debug(getMessage(format), *arguments)
    }

    override fun i(format: String, vararg arguments: Any) {
        logger.info(getMessage(format), *arguments)
    }

    override fun w(format: String, vararg arguments: Any) {
        logger.warn(getMessage(format), *arguments)
    }

    override fun e(format: String, vararg arguments: Any) {
        logger.error(getMessage(format), *arguments)
    }
}