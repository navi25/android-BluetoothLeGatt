package com.example.android.bluetoothlegatt.aws;


/**
 * Created by navi on 4/6/18.
 */

import android.util.Log;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.example.android.bluetoothlegatt.DeviceScanActivity;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class DataManager {


    public  static String TAG = "DataManager";

    public static void addDummyData(){
        for(int i=0; i<5; i++){
            String random = "newDatattadanm,,dsc";
            DataModel dm = DataManager.parseDummyData(random);
            DataManager.insertData(dm);
        }
    }

    public static void sendDataToAWS(byte[] data){
        DataModel dm = DataManager.parseData(data);
        DataManager.insertData(dm);
    }

    public static DataModel parseDummyData(String rawData){
        DataModel dm = new DataModel();
        Long tsLong = System.currentTimeMillis()/1000;

        Date currentTime = Calendar.getInstance().getTime();


        String ts = currentTime.toString();
        dm.uid = UUID.randomUUID().toString();
        dm.timeStamp = ts;
        dm.deviceId = "IrSensor2";
        dm.dataD = rawData;

        return dm;
    }

    public static DataModel parseData(byte[] rawData){
        DataModel dm = new DataModel();
        Date currentTime = Calendar.getInstance().getTime();
        String ts = currentTime.toString();
        dm.uid = UUID.randomUUID().toString();
        dm.timeStamp = ts;

        dm.deviceId = "IrSensor2";
        dm.dataD = getFormattedData(rawData);
        Log.d(TAG, "parsingData " + dm.dataD);

        return dm;
    }

    public static String getFormattedData(byte[] rawData){
        StringBuffer sb = new StringBuffer("");
        for(int i=0; i<rawData.length; i++){
            int curr = rawData[i];
            sb.append(curr);
        }

        return sb.toString();
    }


    public static void insertOldData(DataModel dm){
        final HealthDataDO dataObject = new HealthDataDO();
        dataObject.setId(dm.uid);
        dataObject.setTimeStamp(dm.timeStamp);
        dataObject.setDeviceId(dm.deviceId);
        dataObject.setData(dm.dataD);
        final DynamoDBMapper mapper = DeviceScanActivity.dynamoDBMapper;
        try {
            Log.d(TAG, "Inserting users");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    mapper.save(dataObject);
                    // Item saved
                }
            }).start();

            Log.d(TAG, "Users inserted");

        } catch (AmazonServiceException ex) {
            Log.e(TAG, "Error inserting users");
        }
    }

    public static void insertData(DataModel dm){
        final HealthMay02DO dataObject = new HealthMay02DO();
        dataObject.setUserId(dm.uid);
        dataObject.setTimestamp(dm.timeStamp);
//        dataObject.setDeviceId(dm.deviceId);
        dataObject.setData(dm.dataD);
        dataObject.setIndex(dm.index);
        dataObject.setSequenceNo(dm.seqNo);

        final DynamoDBMapper mapper = DeviceScanActivity.dynamoDBMapper;
        try {
            Log.d(TAG, "Inserting users");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    mapper.save(dataObject);
                    // Item saved
                }
            }).start();

            Log.d(TAG, "Users inserted");

        } catch (AmazonServiceException ex) {
            Log.e(TAG, "Error inserting users");
        }
    }

}


