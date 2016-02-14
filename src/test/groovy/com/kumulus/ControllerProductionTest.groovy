package com.kumulus

import groovyx.net.http.RESTClient
import spock.lang.Specification
import spock.lang.Unroll

class ControllerProductionTest extends Specification {

    @Unroll
    def "Should return 200 & some json"() {
        given:
        def host = getHost();
        def client = new RESTClient("http://${host}/")
        def version = System.getProperty('VERSION');

        when:
        def resp = client.get(path: '/info')

        then:
        resp.data.build.name == "microservice"
        resp.data.build.version == version
        resp.status == 200
        resp.contentType == "application/json"
    }

    private String getHost(String host) {
        if (System.getProperty('HOST') == null) {
            host = "localhost:8080";
        } else {
            host = System.getProperty('HOST')
        }
        host
    }

}
