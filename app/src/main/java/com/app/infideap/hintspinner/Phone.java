
package com.app.infideap.hintspinner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Phone {

    @SerializedName("age")
    @Expose
    public long age;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("imageUrl")
    @Expose
    public String imageUrl;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("snippet")
    @Expose
    public String snippet;
    @SerializedName("carrier")
    @Expose
    public String carrier;

    @Override
    public String toString() {
        return name;
    }
}
