package com.example.controller


import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

import static io.micronaut.http.HttpRequest.GET

@MicronautTest
class TodoControllerSpec extends Specification {

    @Inject
    @Client("/")
    RxHttpClient client

    def "get password"() {
        expect:
            client.toBlocking().retrieve(GET('/password')) == 'secret'
    }
}
