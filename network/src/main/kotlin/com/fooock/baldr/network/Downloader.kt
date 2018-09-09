package com.fooock.baldr.network

import com.fooock.baldr.spider.Spider
import mu.KotlinLogging
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.io.File

/**
 *
 */
class Downloader(private val downloaderProcessor: DownloaderProcessor) {
    private val logger = KotlinLogging.logger { }
    private val httpClient: OkHttpClient

    init {
        val cache = Cache(File(".cache"), 1024 * 1024 * 100)
        httpClient = OkHttpClient.Builder().cache(cache).build()
    }

    /**
     *
     */
    fun get(request: Request, spider: Spider) {
        logger.info { "Downloading $request for $spider" }

        val httpRequest = okhttp3.Request.Builder().url(request.toString()).build()
        val response = httpClient.newCall(httpRequest).execute()
        val respSource = if (response.networkResponse() != null) "(network: ${response.networkResponse()?.code()} over ${response.protocol()})" else "(cache)"
        val respCode = response.code()
        logger.info { String.format("%03d: %s %s", respCode, request.toString(), respSource) }

        if (respCode == 404) {
            downloaderProcessor.onUrlNotFound(request, spider)
            response.close()
            return
        }
        if (respCode == 500 || respCode == 503) {
            downloaderProcessor.onServerError(request, spider)
            response.close()
            return
        }
        val contentType = response.header("Content-Type")
        if (contentType == null || respCode != 200) {
            downloaderProcessor.onInvalidResponse(request, spider)
            response.close()
            return
        }
        val resp = Response(response)
        downloaderProcessor.onSuccessResponse(request, resp, spider)
        response.close()
    }
}
