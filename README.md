# Öğrenci Yönetim Sistemi
Bu proje, MySQL veritabanı ile etkileşim kurarak öğrenci bilgilerini yönetmeyi amaçlayan bir Java uygulamasıdır. Proje, öğrenci ekleme, silme, güncelleme ve sorgulama gibi temel veritabanı işlemlerini gerçekleştirmektedir.
## Gereksinimler
- Java Development Kit (JDK) 8 veya üzeri
- MySQL Veritabanı
- MySQL JDBC Bağlayıcısı (`mysql-connector-java-8.0.28.jar`)
## Kurulum

1. Proje dosyalarını klonlayın veya indirin.
2. MySQL sunucunuzda `okul` adında bir veritabanı oluşturun.
3. Aşağıdaki SQL sorgusunu kullanarak `ogrenciler` adında bir tablo oluşturun:

    ```sql
    CREATE TABLE `okul`.`ogrenciler` (
        `ID` int NOT NULL AUTO_INCREMENT,
        `ogrenciNo` varchar(8) NOT NULL DEFAULT '00000000',
        `username` varchar(45) NOT NULL DEFAULT 'kullaniciAdiYok',
        `adi` varchar(45) NOT NULL DEFAULT 'adiYok',
        `soyadi` varchar(45) NOT NULL DEFAULT 'soyadiYok',
        PRIMARY KEY (`ID`, `ogrenciNo`),
        UNIQUE INDEX 'ID_UNIQUE' (`ID`ASC)VISIBLE,
        UNIQUE INDEX 'ogrenciNo_UNIQUE' (`ID`ASC)VISIBLE,
        UNIQUE INDEX 'username_UNIQUE' (`ID`ASC)VISIBLE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
4. `OgrenciDAO.java` dosyasındaki `url`, `username` ve `password` değişkenlerini kendi MySQL sunucunuzun bilgileri ile güncelleyin.
5. Proje dizininde terminal açarak aşağıdaki komutu çalıştırın:

    ```sh
    javac -d bin -sourcepath src src/dao/DataAccessObject/StartUp.java
    ```

6. Derlenen dosyayı çalıştırın:

    ```sh
    java -cp bin dao.DataAccessObject.StartUp
    ```
## Kullanım

### Öğrenci Sorgulama

Belirli bir öğrenci numarasına sahip öğrenciyi sorgulamak için:

```java
Ogrenci arananOgrenci1 = ogrenciDao.getOgrenci("21181211");
if(arananOgrenci1 != null) {
    arananOgrenci1.bilgiVer();
} else {
    System.out.println("Öğrenci bulunamadı");
}
```
### Öğrenci Ekleme
Yeni bir öğrenci eklemek için:
```java
Ogrenci eklenecekOgrenci = new Ogrenci();
eklenecekOgrenci.setNo("2132132");
eklenecekOgrenci.setAd("Ali Kağan");
eklenecekOgrenci.setSoyad("Uyanık");
eklenecekOgrenci.setKullaniciAdi("AllyKhan");

ogrenciDao.ogrenciEkle(eklenecekOgrenci);
```
### Öğrenci Silme
Belirli bir öğrenci numarasına sahip öğrenciyi silmek için:
```java
ogrenciDao.ogrenciSil(eklenecekOgrenci);
```
### Öğrenci Güncelleme
Belirli bir öğrenci numarasına sahip öğrenciyi güncellemek için:
```java
ogrenciDao.ogrenciGuncelle(eklenecekOgrenci, eklenecekOgrenci.getNo());
```
## Proje Yapısı

- `dao.DataAccessObject.StartUp` : Uygulamanın giriş noktası.
- `dao.DataAccessObject.OgrenciDAO` : Veritabanı işlemlerini gerçekleştiren sınıf.
- `com.MySQLJdbc.Models.Ogrenci` : Öğrenci modelini temsil eden sınıf.

## Projeden Görüntüler

<div align="center">
  <img src="images/list.png" alt="Imitation Learning">
  <p><em>Imitation Learning</em></p>
</div>
  <img src="https://github.com/alikaganuyanikk/Java-MySQL-JDBC-OgrenciYonetimSistemi
/tree/main/photos/output.png" width="200" /> 
</p>




