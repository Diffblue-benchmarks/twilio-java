/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.pricing.v1.voice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import com.twilio.type.InboundCallPrice;
import com.twilio.type.OutboundPrefixPrice;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country extends Resource {
    private static final long serialVersionUID = 270847470775437L;

    /**
     * Create a CountryReader to execute read.
     * 
     * @return CountryReader capable of executing the read
     */
    public static CountryReader reader() {
        return new CountryReader();
    }

    /**
     * Create a CountryFetcher to execute fetch.
     * 
     * @param pathIsoCountry The iso_country
     * @return CountryFetcher capable of executing the fetch
     */
    public static CountryFetcher fetcher(final String pathIsoCountry) {
        return new CountryFetcher(pathIsoCountry);
    }

    /**
     * Converts a JSON String into a Country object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Country object represented by the provided JSON
     */
    public static Country fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Country.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Country object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Country object represented by the provided JSON
     */
    public static Country fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Country.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String country;
    private final String isoCountry;
    private final List<OutboundPrefixPrice> outboundPrefixPrices;
    private final List<InboundCallPrice> inboundCallPrices;
    private final Currency priceUnit;
    private final URI url;

    @JsonCreator
    private Country(@JsonProperty("country")
                    final String country, 
                    @JsonProperty("iso_country")
                    final String isoCountry, 
                    @JsonProperty("outbound_prefix_prices")
                    final List<OutboundPrefixPrice> outboundPrefixPrices, 
                    @JsonProperty("inbound_call_prices")
                    final List<InboundCallPrice> inboundCallPrices, 
                    @JsonProperty("price_unit")
                    @JsonDeserialize(using = com.twilio.converter.CurrencyDeserializer.class)
                    final Currency priceUnit, 
                    @JsonProperty("url")
                    final URI url) {
        this.country = country;
        this.isoCountry = isoCountry;
        this.outboundPrefixPrices = outboundPrefixPrices;
        this.inboundCallPrices = inboundCallPrices;
        this.priceUnit = priceUnit;
        this.url = url;
    }

    /**
     * Returns The Name of the country.
     * 
     * @return Name of the country
     */
    public final String getCountry() {
        return this.country;
    }

    /**
     * Returns The The ISO country code.
     * 
     * @return The ISO country code
     */
    public final String getIsoCountry() {
        return this.isoCountry;
    }

    /**
     * Returns The The outbound_prefix_prices.
     * 
     * @return The outbound_prefix_prices
     */
    public final List<OutboundPrefixPrice> getOutboundPrefixPrices() {
        return this.outboundPrefixPrices;
    }

    /**
     * Returns The The inbound_call_prices.
     * 
     * @return The inbound_call_prices
     */
    public final List<InboundCallPrice> getInboundCallPrices() {
        return this.inboundCallPrices;
    }

    /**
     * Returns The The currency in which prices are measured, in ISO 4127 format
     * (e.g. usd, eur, jpy)..
     * 
     * @return The currency in which prices are measured, in ISO 4127 format (e.g.
     *         usd, eur, jpy).
     */
    public final Currency getPriceUnit() {
        return this.priceUnit;
    }

    /**
     * Returns The The url.
     * 
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Country other = (Country) o;

        return Objects.equals(country, other.country) && 
               Objects.equals(isoCountry, other.isoCountry) && 
               Objects.equals(outboundPrefixPrices, other.outboundPrefixPrices) && 
               Objects.equals(inboundCallPrices, other.inboundCallPrices) && 
               Objects.equals(priceUnit, other.priceUnit) && 
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country,
                            isoCountry,
                            outboundPrefixPrices,
                            inboundCallPrices,
                            priceUnit,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("country", country)
                          .add("isoCountry", isoCountry)
                          .add("outboundPrefixPrices", outboundPrefixPrices)
                          .add("inboundCallPrices", inboundCallPrices)
                          .add("priceUnit", priceUnit)
                          .add("url", url)
                          .toString();
    }
}