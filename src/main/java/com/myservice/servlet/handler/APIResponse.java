package com.myservice.servlet.handler;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * базовая часть ответа
 * Created by Zloy on 04.02.2017.
 */

@JsonAutoDetect(
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE,

        fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface APIResponse {
    @JsonProperty("test")
    final Integer per = 1;

    @JsonProperty("error")
    default Integer isError(){return 0;}
    @JsonProperty("errMsg")
    default String getErrMsg(){return "";}
}
