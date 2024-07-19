package dao.DataAccessObject;

import java.sql.SQLException;

import com.MySQLJdbc.Models.Ogrenci;

public class StartUp {

	public static void main(String[] args) throws SQLException {
		OgrenciDAO ogrenciDao = new OgrenciDAO();
		
		//21181211
		Ogrenci arananOgrenci1 = ogrenciDao.getOgrenci("21181211");
		if(arananOgrenci1!=null) {
			arananOgrenci1.bilgiVer();
		}
		else {
			System.out.println("Ogrenci bulunamadi");
		}
		
		//*********************************************************************//
		
		Ogrenci eklenecekOgrenci= new Ogrenci();
		
		eklenecekOgrenci.setNo("2132132");
		eklenecekOgrenci.setAd("Ahmet");
		eklenecekOgrenci.setSoyad("Ali");
		eklenecekOgrenci.setKullaniciAdi("Kağan");
		
		

		//ogrenciDao.ogrenciEkle(eklenecekOgrenci);
		ogrenciDao.ogrenciSil(eklenecekOgrenci);
		
		try {
			ogrenciDao.ogrenciEkle(eklenecekOgrenci);
		}
		catch(SQLException e){
			System.out.println("Ekleme islemi gerceklesmedi.");
		}
		
		//eklenecekOgrenci.setKullaniciAdi("Transfer iptal");
		ogrenciDao.ogrenciGuncelle(eklenecekOgrenci, eklenecekOgrenci.getNo());
		
		ogrenciDao=null;
		System.gc();
	}

}
