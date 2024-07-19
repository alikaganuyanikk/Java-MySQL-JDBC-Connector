package dao.DataAccessObject;

import java.sql.*;

import com.MySQLJdbc.Models.Ogrenci;



public class OgrenciDAO {
	
	private Connection conn =null;
	
	
	public OgrenciDAO() {
		veriTabaninaBaglan();
	
	}
	protected void finalize()throws Throwable{
		System.out.println("Veri Tabanı Bağlantısı Kapatıldı!.");
		conn.close();
	}

	private void veriTabaninaBaglan() {
		String url="jdbc:mysql://localhost:3306/okul";
		String username="root";
		String password="99icardi99";
		
		
		try {
			conn=DriverManager.getConnection(url, username, password);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}		
	public Ogrenci getOgrenci(String ogrenciNo) throws SQLException {
		
		
		Ogrenci o = new Ogrenci ();
		
		
		String query="select * from ogrenciler where ogrenciNo="+ogrenciNo;
		Statement st = conn.createStatement();
		ResultSet rs=  st.executeQuery(query);
		
		if(rs.next()) {
			o.setID(rs.getInt("ID"));
			o.setNo(ogrenciNo);
			o.setKullaniciAdi(rs.getString("username"));
			o.setAd(rs.getString("adi"));
			o.setSoyad(rs.getString("soyadi"));
		}
		else {
			o = null ;
		}
		return o;	
		
	}
	public void ogrenciEkle(Ogrenci o)throws SQLException {
		
		
		String query="INSERT INTO ogrenciler (ogrenciNo,username,adi,soyadi) VALUES(?,?,?,? )";
		PreparedStatement st= conn.prepareStatement(query);
		
		st.setString(1, o.getNo());
		st.setString(2, o.getKullaniciAdi());
		st.setString(3, o.getAd());
		st.setString(4, o.getSoyad());
		
		int count = st.executeUpdate();
		System.out.println("Öğrenci başarıyla eklendi.");
	}

	public void ogrenciSil(Ogrenci o) throws SQLException {
		
		String query="delete from ogrenciler where ogrenciNo="+o.getNo();
		
		Statement st = conn.createStatement();
		int count= st.executeUpdate(query);
		if(count==1) {
			System.out.println("Ogrenci basariyla silindi.");
		}
		else {
			System.out.println("Ogrenci bulunamadıgı icin silinemedi.");
		}
		
	}
	
	public void ogrenciGuncelle(Ogrenci o,String ogrenciNo) throws SQLException {
		
		String query = "update ogrenciler set ogrenciNo='" + o.getNo() +
	               "', username='" + o.getKullaniciAdi() +
	               "', adi='" + o.getAd() +
	               "', soyadi='" + o.getSoyad() +
	               "' where ogrenciNo=" + ogrenciNo;

		
		Statement st = conn.createStatement();
		int count= st.executeUpdate(query);
		if(count==1) {
			System.out.println("Ogrenci basariyla guncellendi.");
		}
		else {
			System.out.println("Ogrenci bulunamadıgı icin guncelleme yapılmadı.");
		}
	}
	
	}
	

