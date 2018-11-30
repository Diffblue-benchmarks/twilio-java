/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.sync.v1.service.synclist;

import com.twilio.base.Creator;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.Map;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class SyncListItemCreator extends Creator<SyncListItem> {
    private final String pathServiceSid;
    private final String pathListSid;
    private final Map<String, Object> data;
    private Integer ttl;
    private Integer itemTtl;
    private Integer collectionTtl;

    /**
     * Construct a new SyncListItemCreator.
     * 
     * @param pathServiceSid The service_sid
     * @param pathListSid The list_sid
     * @param data Contains arbitrary user-defined, schema-less data that this List
     *             Item stores, represented by a JSON object, up to 16KB.
     */
    public SyncListItemCreator(final String pathServiceSid, 
                               final String pathListSid, 
                               final Map<String, Object> data) {
        this.pathServiceSid = pathServiceSid;
        this.pathListSid = pathListSid;
        this.data = data;
    }

    /**
     * Alias for item_ttl. If both are provided, this value is ignored..
     * 
     * @param ttl Alias for item_ttl
     * @return this
     */
    public SyncListItemCreator setTtl(final Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    /**
     * Time-to-live of this item in seconds, defaults to no expiration. In the range
     * [1, 31 536 000 (1 year)], or 0 for infinity. Upon expiry, the list item will
     * be cleaned up at least in a matter of hours, and often within seconds, making
     * this a good tool for garbage management..
     * 
     * @param itemTtl Time-to-live of this item in seconds, defaults to no
     *                expiration.
     * @return this
     */
    public SyncListItemCreator setItemTtl(final Integer itemTtl) {
        this.itemTtl = itemTtl;
        return this;
    }

    /**
     * Time-to-live of this item's parent List in seconds, defaults to no
     * expiration. In the range [1, 31 536 000 (1 year)], or 0 for infinity. This
     * parameter can only be used when the list item's data or ttl is updated in the
     * same request..
     * 
     * @param collectionTtl Time-to-live of this item's parent List in seconds,
     *                      defaults to no expiration.
     * @return this
     */
    public SyncListItemCreator setCollectionTtl(final Integer collectionTtl) {
        this.collectionTtl = collectionTtl;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created SyncListItem
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public SyncListItem create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.SYNC.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Lists/" + this.pathListSid + "/Items",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SyncListItem creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return SyncListItem.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (data != null) {
            request.addPostParam("Data", Converter.mapToJson(data));
        }

        if (ttl != null) {
            request.addPostParam("Ttl", ttl.toString());
        }

        if (itemTtl != null) {
            request.addPostParam("ItemTtl", itemTtl.toString());
        }

        if (collectionTtl != null) {
            request.addPostParam("CollectionTtl", collectionTtl.toString());
        }
    }
}