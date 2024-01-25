
package com.polytomic.api.resources.bulksync.schemas;

import com.polytomic.api.core.ApiError;
import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.core.RequestOptions;
import com.polytomic.api.resources.bulksync.schemas.requests.V3UpdateBulkSchema;
import com.polytomic.api.types.V3BulkSchemaEnvelope;
import com.polytomic.api.types.V3ListBulkSchemaEnvelope;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SchemasClient {
    protected final ClientOptions clientOptions;

    public SchemasClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public V3ListBulkSchemaEnvelope list(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/bulk/syncs")
                .addPathSegment(id)
                .addPathSegments("schemas")
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V3ListBulkSchemaEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public V3ListBulkSchemaEnvelope list(String id) {
        return list(id, null);
    }

    public V3BulkSchemaEnvelope update(String id, String schemaId) {
        return update(id, schemaId, V3UpdateBulkSchema.builder().build());
    }

    public V3BulkSchemaEnvelope update(
            String id, String schemaId, V3UpdateBulkSchema request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/bulk/syncs")
                .addPathSegment(id)
                .addPathSegments("schemas")
                .addPathSegment(schemaId)
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V3BulkSchemaEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public V3BulkSchemaEnvelope update(String id, String schemaId, V3UpdateBulkSchema request) {
        return update(id, schemaId, request, null);
    }

    public V3BulkSchemaEnvelope get(String id, String schemaId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/bulk/syncs")
                .addPathSegment(id)
                .addPathSegments("schemas")
                .addPathSegment(schemaId)
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V3BulkSchemaEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public V3BulkSchemaEnvelope get(String id, String schemaId) {
        return get(id, schemaId, null);
    }
}
