package com.example.aziz.azizassignment.utill;

import android.text.TextUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.json.JSONObject;

import java.io.File;
import java.io.InputStream;
/**
 * Created by Aziz on 2/3/2017.
 */
public final class JsonMapper {

    private JsonMapper() {

    }

    public static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
        return objectMapper;
    }

    public static JSONObject toJsonObj(String jsonText) {
        try {
            if (!TextUtils.isEmpty(jsonText)) {
                return new JSONObject(jsonText);
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    public static <T> T readData(JSONObject json, TypeReference<T> typeReference) {
        try {
            return readData(json.toString(), typeReference);
        } catch (Exception ignored) {
        }
        return null;
    }

    public static <T> T readData(String jsonText, TypeReference<T> typeReference) {
        try {
            return getObjectMapper().readValue(jsonText, typeReference);
        } catch (Exception ignored) {
        }
        return null;
    }

    public static <T> T readData(File file, TypeReference<T> typeReference) {
        try {
            return getObjectMapper().readValue(file, typeReference);
        } catch (Exception ignored) {
        }
        return null;
    }

    public static <T> T readData(InputStream stream, TypeReference<T> typeReference) {
        try {
            return getObjectMapper().readValue(stream, typeReference);
        } catch (Exception ignored) {
        }
        return null;
    }
}
