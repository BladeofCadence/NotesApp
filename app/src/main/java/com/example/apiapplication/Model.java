package com.example.apiapplication;

import com.google.gson.annotations.SerializedName;

public class Model {
    @SerializedName("id")
    private String id;
    @SerializedName("palette")
    private String[] palette;

    public Model(final String idNum, final String[] paletteName) {
        this.id = idNum;
        this.palette = paletteName;
    }

    public String getName() {return id;}

    public String[] getPalette() {return palette;}

    public void setName(final String id) {this.id = id;}

    public void setPalette(final String[] palette) {this.palette = palette;}

}
