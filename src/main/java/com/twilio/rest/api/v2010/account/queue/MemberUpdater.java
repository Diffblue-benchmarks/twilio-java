/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.queue;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;

public class MemberUpdater extends Updater<Member> {
    private String pathAccountSid;
    private final String pathQueueSid;
    private final String pathCallSid;
    private final URI url;
    private final HttpMethod method;

    /**
     * Construct a new MemberUpdater.
     * 
     * @param pathQueueSid The Queue in which to find the members
     * @param pathCallSid The Call SID of the resource(s) to update
     * @param url The absolute URL of this Queue resource
     * @param method How to pass the update request data
     */
    public MemberUpdater(final String pathQueueSid, 
                         final String pathCallSid, 
                         final URI url, 
                         final HttpMethod method) {
        this.pathQueueSid = pathQueueSid;
        this.pathCallSid = pathCallSid;
        this.url = url;
        this.method = method;
    }

    /**
     * Construct a new MemberUpdater.
     * 
     * @param pathAccountSid The SID of the Account that created the resource(s) to
     *                       update
     * @param pathQueueSid The Queue in which to find the members
     * @param pathCallSid The Call SID of the resource(s) to update
     * @param url The absolute URL of this Queue resource
     * @param method How to pass the update request data
     */
    public MemberUpdater(final String pathAccountSid, 
                         final String pathQueueSid, 
                         final String pathCallSid, 
                         final URI url, 
                         final HttpMethod method) {
        this.pathAccountSid = pathAccountSid;
        this.pathQueueSid = pathQueueSid;
        this.pathCallSid = pathCallSid;
        this.url = url;
        this.method = method;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Member
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Member update(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Queues/" + this.pathQueueSid + "/Members/" + this.pathCallSid + ".json",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Member update failed: Unable to connect to server");
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

        return Member.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (url != null) {
            request.addPostParam("Url", url.toString());
        }

        if (method != null) {
            request.addPostParam("Method", method.toString());
        }
    }
}