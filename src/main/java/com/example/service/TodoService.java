package com.example.service;


import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;

import static io.micronaut.http.HttpRequest.GET;

@Singleton
public class TodoService {

    @Inject
    @Client("vault")
    private RxHttpClient vaultClient;

    public TodoService(RxHttpClient vaultClient) {
        this.vaultClient = vaultClient;
    }

    public static class VaultResponse {
        private Map<String, String> data;

        public void setData(Map<String, String> data) {
            this.data = data;
        }

        public Map<String, String> getData() {
            return data;
        }
    }

    public String getPassword() {
        return vaultClient.toBlocking()
            .retrieve(GET("/v1/secret/db/password").header("X-Vault-Token", "root"), VaultResponse.class)
            .getData()
            .get("PASSWORD");
    }
}
