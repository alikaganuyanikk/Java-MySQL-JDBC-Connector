package com.MySQLJdbc.Models;

public class Ogrenci {
	private int ID;
	private String no;
	private String kullaniciAdi;
	private String ad;
	private String soyad;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	
	public void bilgiVer() {
		String bilgi="ID: "+ ID +"\nÖğrenci Numarası: "+ no + "\nÖğrenci Username: "+ kullaniciAdi + "\nÖğrenci Adı: "+ ad + "\nÖğrenci Soyadı: "+ soyad;
		System.out.println(bilgi);
	}
}
