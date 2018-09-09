package com.fooock.baldr.network

import com.fooock.baldr.spider.Spider

/**
 *
 */
interface DownloaderProcessor {
    /**
     *
     */
    fun onInvalidResponse(request: Request, spider: Spider)

    /**
     *
     */
    fun onUrlNotFound(request: Request, spider: Spider)

    /**
     *
     */
    fun onServerError(request: Request, spider: Spider)

    /**
     *
     */
    fun onSuccessResponse(request: Request, response: Response, spider: Spider)
}