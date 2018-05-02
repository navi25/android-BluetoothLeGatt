package com.example.android.bluetoothlegatt.aws;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.List;
import java.util.Map;
import java.util.Set;

@DynamoDBTable(tableName = "blegatt-mobilehub-1627566919-Health-May02")

public class HealthMay02DO {
    private String _userId;
    private String _timestamp;
    private String _data;
    private Double _index;
    private String _sequenceNo;

    @DynamoDBHashKey(attributeName = "userId")
    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId() {
        return _userId;
    }

    public void setUserId(final String _userId) {
        this._userId = _userId;
    }
    @DynamoDBRangeKey(attributeName = "timestamp")
    @DynamoDBAttribute(attributeName = "timestamp")
    public String getTimestamp() {
        return _timestamp;
    }

    public void setTimestamp(final String _timestamp) {
        this._timestamp = _timestamp;
    }
    @DynamoDBAttribute(attributeName = "data")
    public String getData() {
        return _data;
    }

    public void setData(final String _data) {
        this._data = _data;
    }
    @DynamoDBAttribute(attributeName = "index")
    public Double getIndex() {
        return _index;
    }

    public void setIndex(final Double _index) {
        this._index = _index;
    }
    @DynamoDBAttribute(attributeName = "sequence-no")
    public String getSequenceNo() {
        return _sequenceNo;
    }

    public void setSequenceNo(final String _sequenceNo) {
        this._sequenceNo = _sequenceNo;
    }

}
