/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api.resources.organization;

import com.polytomic.api.core.ApiError;
import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.MediaTypes;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.core.RequestOptions;
import com.polytomic.api.resources.organization.requests.V2CreateOrganizationRequestSchema;
import com.polytomic.api.resources.organization.requests.V2UpdateOrganizationRequestSchema;
import com.polytomic.api.types.V2OrganizationEnvelope;
import com.polytomic.api.types.V2OrganizationsEnvelope;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OrganizationClient {
    protected final ClientOptions clientOptions;

    public OrganizationClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>Organization endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2OrganizationsEnvelope list() {
        return list(null);
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>Organization endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2OrganizationsEnvelope list(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/organizations")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2OrganizationsEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>Organization endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2OrganizationEnvelope create(V2CreateOrganizationRequestSchema request) {
        return create(request, null);
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>Organization endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2OrganizationEnvelope create(V2CreateOrganizationRequestSchema request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/organizations")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2OrganizationEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>Organization endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2OrganizationEnvelope get(String id) {
        return get(id, null);
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>Organization endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2OrganizationEnvelope get(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/organizations")
                .addPathSegment(id)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2OrganizationEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>Organization endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public void remove(String id) {
        remove(id, null);
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>Organization endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public void remove(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/organizations")
                .addPathSegment(id)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>Organization endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2OrganizationEnvelope update(String id, V2UpdateOrganizationRequestSchema request) {
        return update(id, request, null);
    }

    /**
     * <blockquote>
     * 🚧 Requires partner key
     * <p>Organization endpoints are only accessible using <a href="https://docs.polytomic.com/reference/authentication#partner-keys">partner keys</a></p>
     * </blockquote>
     */
    public V2OrganizationEnvelope update(
            String id, V2UpdateOrganizationRequestSchema request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/organizations")
                .addPathSegment(id)
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("PATCH", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2OrganizationEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
