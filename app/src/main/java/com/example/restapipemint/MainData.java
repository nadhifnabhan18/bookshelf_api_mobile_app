package com.example.restapipemint;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MainData {

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("status")
	private String status;

	public List<DataItem> getData(){
		return data;
	}

	public String getStatus(){
		return status;
	}
}