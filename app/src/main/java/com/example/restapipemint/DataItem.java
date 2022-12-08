package com.example.restapipemint;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("penulis")
	private String penulis;

	@SerializedName("penerbit")
	private String penerbit;

	@SerializedName("isbn")
	private String isbn;

	@SerializedName("judul")
	private String judul;

	public String getPenulis(){
		return penulis;
	}

	public String getPenerbit(){
		return penerbit;
	}

	public String getIsbn(){
		return isbn;
	}

	public String getJudul(){
		return judul;
	}
}