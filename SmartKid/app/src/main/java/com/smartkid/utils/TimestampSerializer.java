package com.smartkid.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.sql.Timestamp;

public class TimestampSerializer implements JsonDeserializer<Timestamp> {
    @Override
    public Timestamp deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String timestampString = json.getAsString();
        if(timestampString == null) return null;
        String[] elements = timestampString.substring(0,timestampString.length()-1).split("T");
        if(elements.length < 2) return null;
        return Timestamp.valueOf(elements[0]+" "+elements[1]);
    }
}