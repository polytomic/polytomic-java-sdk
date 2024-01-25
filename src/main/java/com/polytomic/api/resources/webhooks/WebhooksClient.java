
package com.polytomic.api.resources.webhooks;

import com.polytomic.api.core.ApiError;
import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.ObjectMappers;
import com.polytomic.api.core.RequestOptions;
import com.polytomic.api.resources.webhooks.requests.V2CreateWebhooksSchema;
import com.polytomic.api.resources.webhooks.requests.V2UpdateWebhooksSchema;
import com.polytomic.api.types.V2WebhookEnvelope;
import com.polytomic.api.types.V2WebhookListEnvelope;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WebhooksClient {
    protected final ClientOptions clientOptions;

    public WebhooksClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Webooks can be set up using the webhook API endpoints. Currently, only one
     * webhook may be created per organization. The webhook will be called for events
     * in that organization.
     * <p>Consult the <a href="https://docs.polytomic.com/reference/events">Events documentation</a> for more information.</p>
     */
    public V2WebhookListEnvelope list(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/webhooks")
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2WebhookListEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Webooks can be set up using the webhook API endpoints. Currently, only one
     * webhook may be created per organization. The webhook will be called for events
     * in that organization.
     * <p>Consult the <a href="https://docs.polytomic.com/reference/events">Events documentation</a> for more information.</p>
     */
    public V2WebhookListEnvelope list() {
        return list(null);
    }

    /**
     * Webooks can be set up using the webhook API endpoints. Currently, only one
     * webhook may be created per organization. The webhook will be called for events
     * in that organization.
     * <p>Consult the <a href="https://docs.polytomic.com/reference/events">Events documentation</a> for more information.</p>
     */
    public V2WebhookEnvelope create(V2CreateWebhooksSchema request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/webhooks")
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
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2WebhookEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Webooks can be set up using the webhook API endpoints. Currently, only one
     * webhook may be created per organization. The webhook will be called for events
     * in that organization.
     * <p>Consult the <a href="https://docs.polytomic.com/reference/events">Events documentation</a> for more information.</p>
     */
    public V2WebhookEnvelope create(V2CreateWebhooksSchema request) {
        return create(request, null);
    }

    /**
     * Webooks can be set up using the webhook API endpoints. Currently, only one
     * webhook may be created per organization. The webhook will be called for events
     * in that organization.
     * <p>Consult the <a href="https://docs.polytomic.com/reference/events">Events documentation</a> for more information.</p>
     */
    public V2WebhookEnvelope get(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/webhooks")
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2WebhookEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Webooks can be set up using the webhook API endpoints. Currently, only one
     * webhook may be created per organization. The webhook will be called for events
     * in that organization.
     * <p>Consult the <a href="https://docs.polytomic.com/reference/events">Events documentation</a> for more information.</p>
     */
    public V2WebhookEnvelope get(String id) {
        return get(id, null);
    }

    public void delete(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/webhooks")
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

    public void delete(String id) {
        delete(id, null);
    }

    /**
     * Webooks can be set up using the webhook API endpoints. Currently, only one
     * webhook may be created per organization. The webhook will be called for events
     * in that organization.
     * <p>Consult the <a href="https://docs.polytomic.com/reference/events">Events documentation</a> for more information.</p>
     */
    public V2WebhookEnvelope update(String id, V2UpdateWebhooksSchema request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("api/webhooks")
                .addPathSegment(id)
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), V2WebhookEnvelope.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Webooks can be set up using the webhook API endpoints. Currently, only one
     * webhook may be created per organization. The webhook will be called for events
     * in that organization.
     * <p>Consult the <a href="https://docs.polytomic.com/reference/events">Events documentation</a> for more information.</p>
     */
    public V2WebhookEnvelope update(String id, V2UpdateWebhooksSchema request) {
        return update(id, request, null);
    }
}
