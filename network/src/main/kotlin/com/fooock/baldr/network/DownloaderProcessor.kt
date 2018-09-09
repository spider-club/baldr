package com.fooock.baldr.network

/**
 *
 */
interface DownloaderProcessor {
    /**
     *
     */
    fun onInvalidResponse(request: Request, spiderId: String)

    /**
     *
     */
    fun onUrlNotFound(request: Request, spiderId: String)

    /**
     *
     */
    fun onServerError(request: Request, spiderId: String)

    /**
     *
     */
    fun onSuccessResponse(request: Request, response: Response, spiderId: String)
}