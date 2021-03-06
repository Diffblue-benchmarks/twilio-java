/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account;

import com.twilio.base.Creator;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

public class MessageCreator extends Creator<Message> {
    private String pathAccountSid;
    private final com.twilio.type.PhoneNumber to;
    private com.twilio.type.PhoneNumber from;
    private String messagingServiceSid;
    private String body;
    private List<URI> mediaUrl;
    private URI statusCallback;
    private String applicationSid;
    private BigDecimal maxPrice;
    private Boolean provideFeedback;
    private Integer validityPeriod;
    private String maxRate;
    private Boolean forceDelivery;
    private String providerSid;
    private Message.ContentRetention contentRetention;
    private Message.AddressRetention addressRetention;
    private Boolean smartEncoded;
    private String interactiveData;

    /**
     * Construct a new MessageCreator.
     * 
     * @param to The phone number to receive the message
     * @param from The phone number that initiated the message
     * @param body The text of the message you want to send, limited to 1600
     *             characters.
     */
    public MessageCreator(final com.twilio.type.PhoneNumber to, 
                          final com.twilio.type.PhoneNumber from, 
                          final String body) {
        this.to = to;
        this.from = from;
        this.body = body;
    }

    /**
     * Construct a new MessageCreator.
     * 
     * @param pathAccountSid The account_sid
     * @param to The phone number to receive the message
     * @param from The phone number that initiated the message
     * @param body The text of the message you want to send, limited to 1600
     *             characters.
     */
    public MessageCreator(final String pathAccountSid, 
                          final com.twilio.type.PhoneNumber to, 
                          final com.twilio.type.PhoneNumber from, 
                          final String body) {
        this.pathAccountSid = pathAccountSid;
        this.to = to;
        this.from = from;
        this.body = body;
    }

    /**
     * Construct a new MessageCreator.
     * 
     * @param to The phone number to receive the message
     * @param from The phone number that initiated the message
     * @param mediaUrl The URL of the media you wish to send out with the message.
     */
    public MessageCreator(final com.twilio.type.PhoneNumber to, 
                          final com.twilio.type.PhoneNumber from, 
                          final List<URI> mediaUrl) {
        this.to = to;
        this.from = from;
        this.mediaUrl = mediaUrl;
    }

    /**
     * Construct a new MessageCreator.
     * 
     * @param pathAccountSid The account_sid
     * @param to The phone number to receive the message
     * @param from The phone number that initiated the message
     * @param mediaUrl The URL of the media you wish to send out with the message.
     */
    public MessageCreator(final String pathAccountSid, 
                          final com.twilio.type.PhoneNumber to, 
                          final com.twilio.type.PhoneNumber from, 
                          final List<URI> mediaUrl) {
        this.pathAccountSid = pathAccountSid;
        this.to = to;
        this.from = from;
        this.mediaUrl = mediaUrl;
    }

    /**
     * Construct a new MessageCreator.
     * 
     * @param to The phone number to receive the message
     * @param messagingServiceSid The 34 character unique id of the Messaging
     *                            Service you want to associate with this Message.
     * @param body The text of the message you want to send, limited to 1600
     *             characters.
     */
    public MessageCreator(final com.twilio.type.PhoneNumber to, 
                          final String messagingServiceSid, 
                          final String body) {
        this.to = to;
        this.messagingServiceSid = messagingServiceSid;
        this.body = body;
    }

    /**
     * Construct a new MessageCreator.
     * 
     * @param pathAccountSid The account_sid
     * @param to The phone number to receive the message
     * @param messagingServiceSid The 34 character unique id of the Messaging
     *                            Service you want to associate with this Message.
     * @param body The text of the message you want to send, limited to 1600
     *             characters.
     */
    public MessageCreator(final String pathAccountSid, 
                          final com.twilio.type.PhoneNumber to, 
                          final String messagingServiceSid, 
                          final String body) {
        this.pathAccountSid = pathAccountSid;
        this.to = to;
        this.messagingServiceSid = messagingServiceSid;
        this.body = body;
    }

    /**
     * Construct a new MessageCreator.
     * 
     * @param to The phone number to receive the message
     * @param messagingServiceSid The 34 character unique id of the Messaging
     *                            Service you want to associate with this Message.
     * @param mediaUrl The URL of the media you wish to send out with the message.
     */
    public MessageCreator(final com.twilio.type.PhoneNumber to, 
                          final String messagingServiceSid, 
                          final List<URI> mediaUrl) {
        this.to = to;
        this.messagingServiceSid = messagingServiceSid;
        this.mediaUrl = mediaUrl;
    }

    /**
     * Construct a new MessageCreator.
     * 
     * @param pathAccountSid The account_sid
     * @param to The phone number to receive the message
     * @param messagingServiceSid The 34 character unique id of the Messaging
     *                            Service you want to associate with this Message.
     * @param mediaUrl The URL of the media you wish to send out with the message.
     */
    public MessageCreator(final String pathAccountSid, 
                          final com.twilio.type.PhoneNumber to, 
                          final String messagingServiceSid, 
                          final List<URI> mediaUrl) {
        this.pathAccountSid = pathAccountSid;
        this.to = to;
        this.messagingServiceSid = messagingServiceSid;
        this.mediaUrl = mediaUrl;
    }

    /**
     * A URL where Twilio will POST each time your message status changes to one of
     * the following: `queued`, `failed`, `sent`, `delivered`, or `undelivered`.
     * Twilio will POST its [standard request
     * parameters](https://www.twilio.com/docs/sms/twiml#request-parameters) as well
     * as some additional parameters including `MessageSid`, `MessageStatus`, and
     * `ErrorCode`(see more details [below](#statuscallback-request-parameters)). If
     * you include this parameter in addition to a `MessagingServiceSid`, Twilio
     * will override the Status Callback URL of the [Messaging
     * Service](https://www.twilio.com/docs/sms/services/api). URLs must contain a
     * valid hostname – underscores are not allowed..
     * 
     * @param statusCallback URL Twilio will request when the status changes
     * @return this
     */
    public MessageCreator setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * A URL where Twilio will POST each time your message status changes to one of
     * the following: `queued`, `failed`, `sent`, `delivered`, or `undelivered`.
     * Twilio will POST its [standard request
     * parameters](https://www.twilio.com/docs/sms/twiml#request-parameters) as well
     * as some additional parameters including `MessageSid`, `MessageStatus`, and
     * `ErrorCode`(see more details [below](#statuscallback-request-parameters)). If
     * you include this parameter in addition to a `MessagingServiceSid`, Twilio
     * will override the Status Callback URL of the [Messaging
     * Service](https://www.twilio.com/docs/sms/services/api). URLs must contain a
     * valid hostname – underscores are not allowed..
     * 
     * @param statusCallback URL Twilio will request when the status changes
     * @return this
     */
    public MessageCreator setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    /**
     * Twilio will POST a `MessageSid` as well as `MessageStatus=sent` or
     * `MessageStatus=failed` to the URL in the `MessageStatusCallback` property of
     * this [application](https://www.twilio.com/docs/usage/api/applications). If
     * the `StatusCallback` parameter is also passed, the application's
     * `MessageStatusCallback` parameter will take precedence..
     * 
     * @param applicationSid The application to use for callbacks
     * @return this
     */
    public MessageCreator setApplicationSid(final String applicationSid) {
        this.applicationSid = applicationSid;
        return this;
    }

    /**
     * The total maximum price up to the fourth decimal (0.0001) in US dollars
     * acceptable for the message to be delivered. *All messages will be queued for
     * delivery regardless of the price point.* A POST request will later be made to
     * your Status Callback URL with a status change of `Sent` or `Failed`. When the
     * price of the message is greater than this value, the message will fail and
     * not be sent. When `MaxPrice` is not set, all prices for the message are
     * accepted..
     * 
     * @param maxPrice The total maximum price up to the fourth decimal in US
     *                 dollars acceptable for the message to be delivered.
     * @return this
     */
    public MessageCreator setMaxPrice(final BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    /**
     * Set this value to `true` if you are sending messages that have a trackable
     * user action and you intend to confirm delivery of the message using the
     * [Message Feedback API](https://www.twilio.com/docs/sms/api/message-feedback).
     * This parameter is `false` by default..
     * 
     * @param provideFeedback Set this value to true if you are sending messages
     *                        that have a trackable user action and you intend to
     *                        confirm delivery of the message using the Message
     *                        Feedback API.
     * @return this
     */
    public MessageCreator setProvideFeedback(final Boolean provideFeedback) {
        this.provideFeedback = provideFeedback;
        return this;
    }

    /**
     * The number of seconds that the message can remain in a Twilio queue. After
     * exceeding this time limit, the message will fail and a POST request will
     * later be made to your Status Callback URL. Valid values are between 1 and
     * 14400 seconds (the default). Please note that Twilio cannot guarantee that a
     * message will not be queued by the carrier after they accept the message. We
     * do not recommend setting validity periods of less than 5 seconds..
     * 
     * @param validityPeriod The number of seconds that the message can remain in a
     *                       Twilio queue.
     * @return this
     */
    public MessageCreator setValidityPeriod(final Integer validityPeriod) {
        this.validityPeriod = validityPeriod;
        return this;
    }

    /**
     * The max_rate.
     * 
     * @param maxRate The max_rate
     * @return this
     */
    public MessageCreator setMaxRate(final String maxRate) {
        this.maxRate = maxRate;
        return this;
    }

    /**
     * The force_delivery.
     * 
     * @param forceDelivery The force_delivery
     * @return this
     */
    public MessageCreator setForceDelivery(final Boolean forceDelivery) {
        this.forceDelivery = forceDelivery;
        return this;
    }

    /**
     * The provider_sid.
     * 
     * @param providerSid The provider_sid
     * @return this
     */
    public MessageCreator setProviderSid(final String providerSid) {
        this.providerSid = providerSid;
        return this;
    }

    /**
     * The content_retention.
     * 
     * @param contentRetention The content_retention
     * @return this
     */
    public MessageCreator setContentRetention(final Message.ContentRetention contentRetention) {
        this.contentRetention = contentRetention;
        return this;
    }

    /**
     * The address_retention.
     * 
     * @param addressRetention The address_retention
     * @return this
     */
    public MessageCreator setAddressRetention(final Message.AddressRetention addressRetention) {
        this.addressRetention = addressRetention;
        return this;
    }

    /**
     * The smart_encoded.
     * 
     * @param smartEncoded The smart_encoded
     * @return this
     */
    public MessageCreator setSmartEncoded(final Boolean smartEncoded) {
        this.smartEncoded = smartEncoded;
        return this;
    }

    /**
     * A JSON string that represents interactive message which is a category of
     * messages including list picker, time picker, and an Apple Pay request..
     * 
     * @param interactiveData JSON string representing interactive data message.
     * @return this
     */
    public MessageCreator setInteractiveData(final String interactiveData) {
        this.interactiveData = interactiveData;
        return this;
    }

    /**
     * A Twilio phone number (in
     * [E.164](https://www.twilio.com/docs/glossary/what-e164) format), 
     * [alphanumeric sender
     * ID](https://www.twilio.com/docs/sms/send-messages#use-an-alphanumeric-sender-id) or a [Channel Endpoint address](https://www.twilio.com/docs/sms/channels#channel-addresses) enabled for the type of message you wish to send. Phone numbers or [short codes](https://www.twilio.com/docs/sms/api/short-codes) purchased from Twilio work here. You cannot (for example) spoof messages from your own cell phone number. *Do not use this parameter if you are using `MessagingServiceSid`.*.
     * 
     * @param from The phone number that initiated the message
     * @return this
     */
    public MessageCreator setFrom(final com.twilio.type.PhoneNumber from) {
        this.from = from;
        return this;
    }

    /**
     * A Twilio phone number (in
     * [E.164](https://www.twilio.com/docs/glossary/what-e164) format), 
     * [alphanumeric sender
     * ID](https://www.twilio.com/docs/sms/send-messages#use-an-alphanumeric-sender-id) or a [Channel Endpoint address](https://www.twilio.com/docs/sms/channels#channel-addresses) enabled for the type of message you wish to send. Phone numbers or [short codes](https://www.twilio.com/docs/sms/api/short-codes) purchased from Twilio work here. You cannot (for example) spoof messages from your own cell phone number. *Do not use this parameter if you are using `MessagingServiceSid`.*.
     * 
     * @param from The phone number that initiated the message
     * @return this
     */
    public MessageCreator setFrom(final String from) {
        return setFrom(Promoter.phoneNumberFromString(from));
    }

    /**
     * The 34-character unique ID of the [Messaging
     * Service](https://www.twilio.com/docs/sms/services#send-a-message-with-copilot) you want to associate with this Message. Set this parameter to use the [Messaging Service Settings and Copilot Features](https://www.twilio.com/console/sms/services) you have configured. When only this parameter is set, Twilio will use your enabled Copilot Features to select the `From` phone number for delivery. *Do not pass this value if you are using `From`.*.
     * 
     * @param messagingServiceSid The 34 character unique id of the Messaging
     *                            Service you want to associate with this Message.
     * @return this
     */
    public MessageCreator setMessagingServiceSid(final String messagingServiceSid) {
        this.messagingServiceSid = messagingServiceSid;
        return this;
    }

    /**
     * The text of the message you want to send, limited to 1600 characters..
     * 
     * @param body The text of the message you want to send, limited to 1600
     *             characters.
     * @return this
     */
    public MessageCreator setBody(final String body) {
        this.body = body;
        return this;
    }

    /**
     * The URL containing the media you wish to send with the message. `gif` , `png`
     * and `jpeg` content is currently supported and will be formatted correctly on
     * the recipient's device. [Other
     * types](https://www.twilio.com/docs/sms/accepted-mime-types) are also accepted
     * by the API. The media size limit is 5MB. If you wish to send more than one
     * image in the message body, please provide multiple `MediaUrl` values in the
     * POST request. You may include up to 10 MediaUrls per message. *Sending images
     * via SMS is currently only possible in the US and Canada*.
     * 
     * @param mediaUrl The URL of the media you wish to send out with the message.
     * @return this
     */
    public MessageCreator setMediaUrl(final List<URI> mediaUrl) {
        this.mediaUrl = mediaUrl;
        return this;
    }

    /**
     * The URL containing the media you wish to send with the message. `gif` , `png`
     * and `jpeg` content is currently supported and will be formatted correctly on
     * the recipient's device. [Other
     * types](https://www.twilio.com/docs/sms/accepted-mime-types) are also accepted
     * by the API. The media size limit is 5MB. If you wish to send more than one
     * image in the message body, please provide multiple `MediaUrl` values in the
     * POST request. You may include up to 10 MediaUrls per message. *Sending images
     * via SMS is currently only possible in the US and Canada*.
     * 
     * @param mediaUrl The URL of the media you wish to send out with the message.
     * @return this
     */
    public MessageCreator setMediaUrl(final URI mediaUrl) {
        return setMediaUrl(Promoter.listOfOne(mediaUrl));
    }

    /**
     * The URL containing the media you wish to send with the message. `gif` , `png`
     * and `jpeg` content is currently supported and will be formatted correctly on
     * the recipient's device. [Other
     * types](https://www.twilio.com/docs/sms/accepted-mime-types) are also accepted
     * by the API. The media size limit is 5MB. If you wish to send more than one
     * image in the message body, please provide multiple `MediaUrl` values in the
     * POST request. You may include up to 10 MediaUrls per message. *Sending images
     * via SMS is currently only possible in the US and Canada*.
     * 
     * @param mediaUrl The URL of the media you wish to send out with the message.
     * @return this
     */
    public MessageCreator setMediaUrl(final String mediaUrl) {
        return setMediaUrl(Promoter.uriFromString(mediaUrl));
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Message
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Message create(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Messages.json",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Message creation failed: Unable to connect to server");
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

        return Message.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (to != null) {
            request.addPostParam("To", to.toString());
        }

        if (from != null) {
            request.addPostParam("From", from.toString());
        }

        if (messagingServiceSid != null) {
            request.addPostParam("MessagingServiceSid", messagingServiceSid);
        }

        if (body != null) {
            request.addPostParam("Body", body);
        }

        if (mediaUrl != null) {
            for (URI prop : mediaUrl) {
                request.addPostParam("MediaUrl", prop.toString());
            }
        }

        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }

        if (applicationSid != null) {
            request.addPostParam("ApplicationSid", applicationSid);
        }

        if (maxPrice != null) {
            request.addPostParam("MaxPrice", maxPrice.toString());
        }

        if (provideFeedback != null) {
            request.addPostParam("ProvideFeedback", provideFeedback.toString());
        }

        if (validityPeriod != null) {
            request.addPostParam("ValidityPeriod", validityPeriod.toString());
        }

        if (maxRate != null) {
            request.addPostParam("MaxRate", maxRate);
        }

        if (forceDelivery != null) {
            request.addPostParam("ForceDelivery", forceDelivery.toString());
        }

        if (providerSid != null) {
            request.addPostParam("ProviderSid", providerSid);
        }

        if (contentRetention != null) {
            request.addPostParam("ContentRetention", contentRetention.toString());
        }

        if (addressRetention != null) {
            request.addPostParam("AddressRetention", addressRetention.toString());
        }

        if (smartEncoded != null) {
            request.addPostParam("SmartEncoded", smartEncoded.toString());
        }

        if (interactiveData != null) {
            request.addPostParam("InteractiveData", interactiveData);
        }
    }
}