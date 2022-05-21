package com.smartkid.utils;

import android.content.Context;

import com.smartkid.BuildConfig;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {
    public static void serialize(Object obj, String filename, Context context) throws IOException {
        ObjectOutputStream oos = null;
        try{
            FileOutputStream fos = context.openFileOutput(BuildConfig.SERIALIZATION_PATH+filename, Context.MODE_PRIVATE);
            oos =  new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
        finally {
            if(oos != null) oos.close();
        }
    }

    public static Object deserialize(String filename, Context context) throws IOException, ClassNotFoundException {
        Object value;
        ObjectInputStream ois = null;
        try{
            FileInputStream fis = context.openFileInput(BuildConfig.SERIALIZATION_PATH+filename);
            ois = new ObjectInputStream(fis);
            value = ois.readObject();
        }
        catch(Exception ex){
            ex.printStackTrace();
            throw ex;
        }
        finally{
            if(ois != null) ois.close();
        }
        return value;
    }
}
