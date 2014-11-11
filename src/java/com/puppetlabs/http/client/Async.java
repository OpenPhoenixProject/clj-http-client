package com.puppetlabs.http.client;

import com.puppetlabs.http.client.impl.Promise;
import com.puppetlabs.http.client.impl.SslUtils;
import com.puppetlabs.http.client.impl.JavaClient;
import com.puppetlabs.http.client.impl.PersistentAsyncHttpClient;
import com.puppetlabs.http.client.impl.CoercedClientOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

public class Async {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sync.class);

    private static Promise<Response> request(SimpleRequestOptions requestOptions) {
        return JavaClient.request(requestOptions, null);
    }

    public static AsyncHttpClient createClient(ClientOptions clientOptions) {
        clientOptions = SslUtils.configureSsl(clientOptions);
        CoercedClientOptions coercedClientOptions = JavaClient.coerceClientOptions(clientOptions);
        return new PersistentAsyncHttpClient(JavaClient.createClient(coercedClientOptions));
    }

    public static Promise<Response> get(String url) throws URISyntaxException {
        return get(new URI(url));
    }
    public static Promise<Response> get(URI uri) {
        return get(new SimpleRequestOptions(uri));
    }
    public static Promise<Response> get(SimpleRequestOptions simpleRequestOptions) {
        return request(simpleRequestOptions.setMethod(HttpMethod.GET));
    }

    public static Promise<Response> head(String url) throws URISyntaxException {
        return head(new URI(url));
    }
    public static Promise<Response> head(URI uri) {
        return head(new SimpleRequestOptions(uri));
    }
    public static Promise<Response> head(SimpleRequestOptions simpleRequestOptions) {
        return request(simpleRequestOptions.setMethod(HttpMethod.HEAD));
    }

    public static Promise<Response> post(String url) throws URISyntaxException {
        return post(new URI(url));
    }
    public static Promise<Response> post(URI uri) {
        return post(new SimpleRequestOptions(uri));
    }
    public static Promise<Response> post(SimpleRequestOptions simpleRequestOptions) {
        return request(simpleRequestOptions.setMethod(HttpMethod.POST));
    }

    public static Promise<Response> put(String url) throws URISyntaxException {
        return put(new URI(url));
    }
    public static Promise<Response> put(URI uri) {
        return put(new SimpleRequestOptions(uri));
    }
    public static Promise<Response> put(SimpleRequestOptions simpleRequestOptions) {
        return request(simpleRequestOptions.setMethod(HttpMethod.PUT));
    }

    public static Promise<Response> delete(String url) throws URISyntaxException {
        return delete(new URI(url));
    }
    public static Promise<Response> delete(URI uri) {
        return delete(new SimpleRequestOptions(uri));
    }
    public static Promise<Response> delete(SimpleRequestOptions simpleRequestOptions) {
        return request(simpleRequestOptions.setMethod(HttpMethod.DELETE));
    }

    public static Promise<Response> trace(String url) throws URISyntaxException {
        return trace(new URI(url));
    }
    public static Promise<Response> trace(URI uri) {
        return trace(new SimpleRequestOptions(uri));
    }
    public static Promise<Response> trace(SimpleRequestOptions simpleRequestOptions) {
        return request(simpleRequestOptions.setMethod(HttpMethod.TRACE));
    }

    public static Promise<Response> options(String url) throws URISyntaxException {
        return options(new URI(url));
    }
    public static Promise<Response> options(URI uri) {
        return options(new SimpleRequestOptions(uri));
    }
    public static Promise<Response> options(SimpleRequestOptions simpleRequestOptions) {
        return request(simpleRequestOptions.setMethod(HttpMethod.OPTIONS));
    }

    public static Promise<Response> patch(String url) throws URISyntaxException {
        return patch(new URI(url));
    }
    public static Promise<Response> patch(URI uri) {
        return patch(new SimpleRequestOptions(uri));
    }
    public static Promise<Response> patch(SimpleRequestOptions simpleRequestOptions) {
        return request(simpleRequestOptions.setMethod(HttpMethod.PATCH));
    }
}
