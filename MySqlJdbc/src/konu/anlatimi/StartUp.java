package konu.anlatimi;
import java.sql.*;
import java.util.Scanner;

public class StartUp {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306/okul";
		String username="root";
		String password="99icardi99";
		//sql sorgusu
		String query= "select * from ogrenciler";
		
		Connection conn = null;	
		
		//Connection Database
		conn=DriverManager.getConnection(url, username, password);
	
		
		//SQL Komutlarının Kategorileri (DDL,DML,DQL,TCL,DCL)
		//DDL (CREATE,DROP,ALTER,TRUNCATE)
		//DML (INSERT,UPDATE,DELETE,CALL,EXPLAIN CALL,LOCK)
		//DQL (SELECT)
		
		//Statement st = conn.prepareStatement(query);
		PreparedStatement st = conn.prepareStatement(query);// SQL sorgularını çalıştırmak
		ResultSet rs = st.executeQuery(query);//SQL sorguları sonucunda dönen veri
		
		while(rs.next()) {
			//ID
			int ogrenciID=rs.getInt("ID");
			//ogrenciNo
			String ogrenciNo=rs.getString("ogrenciNo");
			//username
			String ogrenciUsername=rs.getString("username");
			//adi
			String ogrenciAdi = rs.getString("adi");
			//soyadi
			String ogrenciSoyadi= rs.getString("soyadi");
			System.out.println("ID: "+ ogrenciID +"\nÖğrenci Numarası: "+ ogrenciNo + "\nÖğrenci Username: "+ ogrenciUsername + "\nÖğrenci Adı: "+ ogrenciAdi + "\nÖğrenci Soyadı: "+ ogrenciSoyadi);
			
		}
		/*
		Ekleme Id vererek:(Güvenilir değil) Doğrudan değerleri vermek yerine dolaylı yoldan vermeliyiz.
				query="INSERT INTO ogrenciler VALUES(5,'21181214','Patron','Davinson','Sanchez')";
				int count = st.executeUpdate(query);
				System.out.println("\n"+count + " satır eklendi.");
				
				*/
		/*
		query="INSERT INTO ogrenciler(ogrenciNo,username,adi,soyadi) VALUES('21181216','Dayı','Kerem','Demirbay')";
		int count = st.executeUpdate(query);
		System.out.println("\n"+count + " satır eklendi.");
		*/
		
		//query="INSERT INTO ogrenciler(ogrenciNo,username,adi,soyadi) VALUES(?,?,?,?)";
		//st=conn.prepareStatement(query);
		/*
		st.setString(1, "1210209");
		st.setString(2, "Kerem Potter");
		st.setString(3, "Kerem");
		st.setString(4, "Aktürkoğlu");
		*/
		//int count = st.executeUpdate();
		//System.out.println("\n"+count + " satır eklendi.");
		
		//Kullanıcıdan veri alma
		String okulNo, kullaniciAdi,ad,soyad;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Okul no giriniz:");
		okulNo= sc.nextLine();
		System.out.print("Kullanıcı adı giriniz:");
		kullaniciAdi= sc.nextLine();
		System.out.print("Adınızı giriniz:");
		ad= sc.nextLine();
		System.out.print("Soyadınızı giriniz:");
		soyad= sc.nextLine();
		
		// Yeni kayıt ekleme sorgusu
		query = "INSERT INTO ogrenciler (ogrenciNo, username, adi, soyadi) VALUES (?, ?, ?, ?)";
		st=conn.prepareStatement(query);
		st.setString(1, okulNo);
		st.setString(2, kullaniciAdi);
		st.setString(3, ad);
		st.setString(4, soyad);
		
		int count = st.executeUpdate();
		System.out.println("\n"+count + " satır eklendi.");
		
		st.close();
		conn.close();
		
		
		
	}

}
