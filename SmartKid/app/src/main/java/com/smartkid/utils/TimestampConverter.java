package com.smartkid.utils;

import androidx.room.ProvidedTypeConverter;
import androidx.room.TypeConverter;

import java.sql.Timestamp;

@ProvidedTypeConverter
public class TimestampConverter {
    @TypeConverter
    public static Timestamp fromTimestamp(Long value) {
        return value == null ? null : new Timestamp(value);
    }

    @TypeConverter
    public static Long timestampToLong(Timestamp date) {
        return date == null ? null : date.getTime();
    }
}