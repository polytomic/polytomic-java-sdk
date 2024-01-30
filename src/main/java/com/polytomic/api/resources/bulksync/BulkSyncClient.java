package com.polytomic.api.resources.bulksync;

import com.polytomic.api.core.ApiError;
import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.core.RequestOptions;
import com.polytomic.api.core.Suppliers;
import com.polytomic.api.resources.bulksync.executions.ExecutionsClient;
import com.polytomic.api.resources.bulksync.requests.BulkSyncGetRequest;
import com.polytomic.api.resources.bulksync.requests.BulkSyncGetSourceRequest;
import com.polytomic.api.resources.bulksync.requests.BulkSyncRemoveRequest;
import com.polytomic.api.resources.bulksync.requests.V2CreateBulkSyncRequest;
import com.polytomic.api.resources.bulksync.requests.V2UpdateBulkSyncRequest;
import com.polytomic.api.resources.bulksync.schemas.SchemasClient;
import com.polytomic.api.types.V2ActivateSyncEnvelope;
import com.polytomic.api.types.V2ActivateSyncInput;
import com.polytomic.api.types.V2BulkSyncDestEnvelope;
import com.polytomic.api.types.V2BulkSyncListEnvelope;
import com.polytomic.api.types.V2BulkSyncResponseEnvelope;
import com.polytomic.api.types.V3BulkSyncSourceEnvelope;
import com.polytomic.api.types.V3BulkSyncSourceSchemaEnvelope;
import com.polytomic.api.types.V3BulkSyncSourceStatusEnvelope;
import com.polytomic.api.types.V3BulkSyncStatusEnvelope;
import java.io.IOException;
import java.lang.Exception;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.function.Supplier;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class BulkSyncClient {
  protected final ClientOptions clientOptions;

  protected final Supplier<ExecutionsClient> executionsClient;

  protected final Supplier<SchemasClient> schemasClient;

  public BulkSyncClient(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    this.executionsClient = Suppliers.memoize(() -> new ExecutionsClient(clientOptions));
    this.schemasClient = Suppliers.memoize(() -> new SchemasClient(clientOptions));
  }

  public V2BulkSyncDestEnvelope getDestination(String id, RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("api/bulk/dest")
      .addPathSegment(id)
      .build();
    Request okhttpRequest = new Request.Builder()
      .url(httpUrl)
      .method("GET", null)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Content-Type", "application/json")
      .build();
    try {
      Response response = clientOptions.httpClient().newCall(okhttpRequest).execute();
      if (response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2BulkSyncDestEnvelope.class);
      }
      throw new ApiError(response.code(), ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public V2BulkSyncDestEnvelope getDestination(String id) {
    return getDestination(id,null);
  }

  public V3BulkSyncSourceEnvelope getSource(String connectionId) {
    return getSource(connectionId,BulkSyncGetSourceRequest.builder().build());
  }

  public V3BulkSyncSourceEnvelope getSource(String connectionId, BulkSyncGetSourceRequest request,
      RequestOptions requestOptions) {
    HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("api/bulk/source")
      .addPathSegment(connectionId);if (request.getRefreshSchemas().isPresent()) {
        httpUrl.addQueryParameter("refresh_schemas", request.getRefreshSchemas().get().toString());
      }
      if (request.getIncludeFields().isPresent()) {
        httpUrl.addQueryParameter("include_fields", request.getIncludeFields().get().toString());
      }
      Request.Builder _requestBuilder = new Request.Builder()
        .url(httpUrl.build())
        .method("GET", null)
        .headers(Headers.of(clientOptions.headers(requestOptions)))
        .addHeader("Content-Type", "application/json");
      Request okhttpRequest = _requestBuilder.build();
      try {
        Response response = clientOptions.httpClient().newCall(okhttpRequest).execute();
        if (response.isSuccessful()) {
          return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V3BulkSyncSourceEnvelope.class);
        }
        throw new ApiError(response.code(), ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
      }
      catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    public V3BulkSyncSourceEnvelope getSource(String connectionId,
        BulkSyncGetSourceRequest request) {
      return getSource(connectionId,request,null);
    }

    public V3BulkSyncSourceSchemaEnvelope getSourceSchema(String connectionId, String schemaId,
        RequestOptions requestOptions) {
      HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("api/bulk/source")
        .addPathSegment(connectionId)
        .addPathSegments("schema")
        .addPathSegment(schemaId)
        .build();
      Request okhttpRequest = new Request.Builder()
        .url(httpUrl)
        .method("GET", null)
        .headers(Headers.of(clientOptions.headers(requestOptions)))
        .addHeader("Content-Type", "application/json")
        .build();
      try {
        Response response = clientOptions.httpClient().newCall(okhttpRequest).execute();
        if (response.isSuccessful()) {
          return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V3BulkSyncSourceSchemaEnvelope.class);
        }
        throw new ApiError(response.code(), ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
      }
      catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    public V3BulkSyncSourceSchemaEnvelope getSourceSchema(String connectionId, String schemaId) {
      return getSourceSchema(connectionId,schemaId,null);
    }

    public V3BulkSyncSourceStatusEnvelope apiV3GetBulkSourceStatus(String connectionId,
        RequestOptions requestOptions) {
      HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("api/bulk/source")
        .addPathSegment(connectionId)
        .addPathSegments("status")
        .build();
      Request okhttpRequest = new Request.Builder()
        .url(httpUrl)
        .method("GET", null)
        .headers(Headers.of(clientOptions.headers(requestOptions)))
        .addHeader("Content-Type", "application/json")
        .build();
      try {
        Response response = clientOptions.httpClient().newCall(okhttpRequest).execute();
        if (response.isSuccessful()) {
          return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V3BulkSyncSourceStatusEnvelope.class);
        }
        throw new ApiError(response.code(), ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
      }
      catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    public V3BulkSyncSourceStatusEnvelope apiV3GetBulkSourceStatus(String connectionId) {
      return apiV3GetBulkSourceStatus(connectionId,null);
    }

    public V2BulkSyncListEnvelope list(RequestOptions requestOptions) {
      HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("api/bulk/syncs")
        .build();
      Request okhttpRequest = new Request.Builder()
        .url(httpUrl)
        .method("GET", null)
        .headers(Headers.of(clientOptions.headers(requestOptions)))
        .addHeader("Content-Type", "application/json")
        .build();
      try {
        Response response = clientOptions.httpClient().newCall(okhttpRequest).execute();
        if (response.isSuccessful()) {
          return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2BulkSyncListEnvelope.class);
        }
        throw new ApiError(response.code(), ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
      }
      catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    public V2BulkSyncListEnvelope list() {
      return list(null);
    }

    public V2BulkSyncResponseEnvelope create(V2CreateBulkSyncRequest request,
        RequestOptions requestOptions) {
      HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("api/bulk/syncs")
        .build();
      RequestBody body;
      try {
        body = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
      }
      catch(Exception e) {
        throw new RuntimeException(e);
      }
      Request okhttpRequest = new Request.Builder()
        .url(httpUrl)
        .method("POST", body)
        .headers(Headers.of(clientOptions.headers(requestOptions)))
        .addHeader("Content-Type", "application/json")
        .build();
      try {
        Response response = clientOptions.httpClient().newCall(okhttpRequest).execute();
        if (response.isSuccessful()) {
          return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2BulkSyncResponseEnvelope.class);
        }
        throw new ApiError(response.code(), ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
      }
      catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    public V2BulkSyncResponseEnvelope create(V2CreateBulkSyncRequest request) {
      return create(request,null);
    }

    public V2BulkSyncResponseEnvelope get(String id) {
      return get(id,BulkSyncGetRequest.builder().build());
    }

    public V2BulkSyncResponseEnvelope get(String id, BulkSyncGetRequest request,
        RequestOptions requestOptions) {
      HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("api/bulk/syncs")
        .addPathSegment(id);if (request.getRefreshSchemas().isPresent()) {
          httpUrl.addQueryParameter("refresh_schemas", request.getRefreshSchemas().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
          .url(httpUrl.build())
          .method("GET", null)
          .headers(Headers.of(clientOptions.headers(requestOptions)))
          .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        try {
          Response response = clientOptions.httpClient().newCall(okhttpRequest).execute();
          if (response.isSuccessful()) {
            return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2BulkSyncResponseEnvelope.class);
          }
          throw new ApiError(response.code(), ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        }
        catch (IOException e) {
          throw new RuntimeException(e);
        }
      }

      public V2BulkSyncResponseEnvelope get(String id, BulkSyncGetRequest request) {
        return get(id,request,null);
      }

      public void remove(String id) {
        remove(id,BulkSyncRemoveRequest.builder().build());
      }

      public void remove(String id, BulkSyncRemoveRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

          .addPathSegments("api/bulk/syncs")
          .addPathSegment(id);if (request.getRefreshSchemas().isPresent()) {
            httpUrl.addQueryParameter("refresh_schemas", request.getRefreshSchemas().get().toString());
          }
          Request.Builder _requestBuilder = new Request.Builder()
            .url(httpUrl.build())
            .method("DELETE", null)
            .headers(Headers.of(clientOptions.headers(requestOptions)));
          Request okhttpRequest = _requestBuilder.build();
          try {
            Response response = clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
              return;
            }
            throw new ApiError(response.code(), ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
          }
          catch (IOException e) {
            throw new RuntimeException(e);
          }
        }

        public void remove(String id, BulkSyncRemoveRequest request) {
          remove(id,request,null);
        }

        /**
         * <blockquote>
         * 📘 Updating schemas
         * <p>Schema updates can be performed using the <a href="https://docs.polytomic.com/reference/apiv3updatebulksyncschemas">Update Bulk Sync Schemas</a> endpoint.</p>
         * </blockquote>
         */
        public V2BulkSyncResponseEnvelope update(String id, V2UpdateBulkSyncRequest request,
            RequestOptions requestOptions) {
          HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

            .addPathSegments("api/bulk/syncs")
            .addPathSegment(id)
            .build();
          RequestBody body;
          try {
            body = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
          }
          catch(Exception e) {
            throw new RuntimeException(e);
          }
          Request okhttpRequest = new Request.Builder()
            .url(httpUrl)
            .method("PATCH", body)
            .headers(Headers.of(clientOptions.headers(requestOptions)))
            .addHeader("Content-Type", "application/json")
            .build();
          try {
            Response response = clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
              return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2BulkSyncResponseEnvelope.class);
            }
            throw new ApiError(response.code(), ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
          }
          catch (IOException e) {
            throw new RuntimeException(e);
          }
        }

        /**
         * <blockquote>
         * 📘 Updating schemas
         * <p>Schema updates can be performed using the <a href="https://docs.polytomic.com/reference/apiv3updatebulksyncschemas">Update Bulk Sync Schemas</a> endpoint.</p>
         * </blockquote>
         */
        public V2BulkSyncResponseEnvelope update(String id, V2UpdateBulkSyncRequest request) {
          return update(id,request,null);
        }

        public V2ActivateSyncEnvelope activate(String id, V2ActivateSyncInput request,
            RequestOptions requestOptions) {
          HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

            .addPathSegments("api/bulk/syncs")
            .addPathSegment(id)
            .addPathSegments("activate")
            .build();
          RequestBody body;
          try {
            body = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaType.parse("application/json"));
          }
          catch(Exception e) {
            throw new RuntimeException(e);
          }
          Request okhttpRequest = new Request.Builder()
            .url(httpUrl)
            .method("POST", body)
            .headers(Headers.of(clientOptions.headers(requestOptions)))
            .addHeader("Content-Type", "application/json")
            .build();
          try {
            Response response = clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
              return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2ActivateSyncEnvelope.class);
            }
            throw new ApiError(response.code(), ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
          }
          catch (IOException e) {
            throw new RuntimeException(e);
          }
        }

        public V2ActivateSyncEnvelope activate(String id, V2ActivateSyncInput request) {
          return activate(id,request,null);
        }

        public V3BulkSyncStatusEnvelope getStatus(String id, RequestOptions requestOptions) {
          HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

            .addPathSegments("api/bulk/syncs")
            .addPathSegment(id)
            .addPathSegments("status")
            .build();
          Request okhttpRequest = new Request.Builder()
            .url(httpUrl)
            .method("GET", null)
            .headers(Headers.of(clientOptions.headers(requestOptions)))
            .addHeader("Content-Type", "application/json")
            .build();
          try {
            Response response = clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
              return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V3BulkSyncStatusEnvelope.class);
            }
            throw new ApiError(response.code(), ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
          }
          catch (IOException e) {
            throw new RuntimeException(e);
          }
        }

        public V3BulkSyncStatusEnvelope getStatus(String id) {
          return getStatus(id,null);
        }

        public ExecutionsClient executions() {
          return this.executionsClient.get();
        }

        public SchemasClient schemas() {
          return this.schemasClient.get();
        }
      }