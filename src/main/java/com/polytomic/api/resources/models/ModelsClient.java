/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.polytomic.api.resources.models;

import com.polytomic.api.core.ApiError;
import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.MediaTypes;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.core.RequestOptions;
import com.polytomic.api.resources.models.requests.V2CreateModelRequest;
import com.polytomic.api.resources.models.requests.V2UpdateModelRequest;
import com.polytomic.api.types.V2ModelListResponseEnvelope;
import com.polytomic.api.types.V2ModelResponseEnvelope;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ModelsClient {
    protected final ClientOptions clientOptions;

    public ModelsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public V2ModelListResponseEnvelope list() {
        return list(null);
    }

    public V2ModelListResponseEnvelope list(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/models")
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2ModelListResponseEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public V2ModelResponseEnvelope create(V2CreateModelRequest request) {
        return create(request, null);
    }

    public V2ModelResponseEnvelope create(V2CreateModelRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/models");
        if (request.getAsync().isPresent()) {
            httpUrl.addQueryParameter("async", request.getAsync().get().toString());
        }
        Map<String, Object> properties = new HashMap<>();
        if (request.getAdditionalFields().isPresent()) {
            properties.put("additional_fields", request.getAdditionalFields());
        }
        if (request.getConfiguration().isPresent()) {
            properties.put("configuration", request.getConfiguration());
        }
        properties.put("connection_id", request.getConnectionId());
        if (request.getFields().isPresent()) {
            properties.put("fields", request.getFields());
        }
        if (request.getIdentifier().isPresent()) {
            properties.put("identifier", request.getIdentifier());
        }
        if (request.getLabels().isPresent()) {
            properties.put("labels", request.getLabels());
        }
        properties.put("name", request.getName());
        if (request.getOrganizationId().isPresent()) {
            properties.put("organization_id", request.getOrganizationId());
        }
        if (request.getPolicies().isPresent()) {
            properties.put("policies", request.getPolicies());
        }
        if (request.getRelations().isPresent()) {
            properties.put("relations", request.getRelations());
        }
        if (request.getTrackingColumns().isPresent()) {
            properties.put("tracking_columns", request.getTrackingColumns());
        }
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(properties), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2ModelResponseEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public V2ModelResponseEnvelope get(String id) {
        return get(id, null);
    }

    public V2ModelResponseEnvelope get(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/models")
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2ModelResponseEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(String id) {
        remove(id, null);
    }

    public void remove(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/models")
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

    public V2ModelResponseEnvelope update(String id, V2UpdateModelRequest request) {
        return update(id, request, null);
    }

    public V2ModelResponseEnvelope update(String id, V2UpdateModelRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/models")
                .addPathSegment(id);
        if (request.getAsync().isPresent()) {
            httpUrl.addQueryParameter("async", request.getAsync().get().toString());
        }
        Map<String, Object> properties = new HashMap<>();
        if (request.getAdditionalFields().isPresent()) {
            properties.put("additional_fields", request.getAdditionalFields());
        }
        if (request.getConfiguration().isPresent()) {
            properties.put("configuration", request.getConfiguration());
        }
        properties.put("connection_id", request.getConnectionId());
        if (request.getFields().isPresent()) {
            properties.put("fields", request.getFields());
        }
        if (request.getIdentifier().isPresent()) {
            properties.put("identifier", request.getIdentifier());
        }
        if (request.getLabels().isPresent()) {
            properties.put("labels", request.getLabels());
        }
        properties.put("name", request.getName());
        if (request.getOrganizationId().isPresent()) {
            properties.put("organization_id", request.getOrganizationId());
        }
        if (request.getPolicies().isPresent()) {
            properties.put("policies", request.getPolicies());
        }
        if (request.getRelations().isPresent()) {
            properties.put("relations", request.getRelations());
        }
        if (request.getTrackingColumns().isPresent()) {
            properties.put("tracking_columns", request.getTrackingColumns());
        }
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(properties), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("PATCH", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2ModelResponseEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
