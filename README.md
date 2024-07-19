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
    CREATE TABLE `ogrenciler` (
        `ID` int(11) NOT NULL AUTO_INCREMENT,
        `ogrenciNo` varchar(50) NOT NULL,
        `username` varchar(50) NOT NULL,
        `adi` varchar(50) NOT NULL,
        `soyadi` varchar(50) NOT NULL,
        PRIMARY KEY (`ID`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
