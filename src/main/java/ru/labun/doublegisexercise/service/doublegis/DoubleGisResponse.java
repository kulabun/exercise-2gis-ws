package ru.labun.doublegisexercise.service.doublegis;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by constantine on 06/02/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class DoubleGisResponse {
    public static final String OK_CODE = "200";

    @JsonProperty("response_code")
    private String responseCode;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("error_code")
    private String errorCode;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isError(){
        return !OK_CODE.equals(getResponseCode());
    }
}
