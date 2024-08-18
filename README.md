# Gebze Sosyal Yardım sitesinin yapılışı için kılavuz

<hr>

## 1- Kurulumlar:
- Git  
- Github Desktop  
- JAVA 8 UPDATE 421  
- Eclipse Temurin JDK with hotspot 17.0.11  
- Java(TM) SE Development Kit 17.0.11  
- Apache Netbeans IDE 22  
- Oracle Database 19c Enterprise Edition ([indirme linki](https://edelivery.oracle.com/osdc/faces/SoftwareDelivery))  
(2. Maddedeki BTK akademi kursu ile birlikte kurmanız tavsiye edilir!)

<hr>

## 2- Video Kaynak:
JSF kullanımı ve website yapımı:  
[YouTube](https://www.youtube.com/watch?v=R4glkRS_6rE&list=PL4XQdSx4Y7b7VFll7oLNp9a2Nqp0dMsoI)

Database ile ilgili kısımları geçebilirsiniz çünkü farklı bir database kullanıyor.  
Eğer database kurulumunda ve/veya kullanımında sorun yaşarsanız:  
[BTK Akademi](https://www.btkakademi.gov.tr/portal/course/sifirdan-ileri-seviye-oracle-sql-19567)

SQL Developer kurduğunuzda butonlar çalışmıyorsa, eksikse ve uygulama penceresi bozuksa bu video ile halledebilirsiniz:  
[Oracle Çözüm](https://www.youtube.com/watch?v=xzBZ2eWss6k&t=1s)

<hr>

## 3- Netbeans'den proje oluşturmak:
1. Java Ant içinde Java Web'e gelin, "Web Application" seçeneğini seçin ve ilerleyin.  
2. Server seçme kısmında GlassFish seçin ve orada 6.2.5 sürümünü seçerek indirin.  
3. Firework seçme kısmında Java Faces seçin ve Server Libraries seçeneğinde 3.0 seçin.  
4. Finish diyerek bitirin.

<hr>

## 3.5- Otomatik tamamlamayı açmak:
Tools --> Options --> Editor --> Code Completion --> Language: Java --> ilk 3 seçenek tikli olmalı

<hr>

## 4- Glassfish hatası:
Eğer projeyi başlatmaya çalıştığınızda undeployed hatası alıyorsanız veya proje sürekli olarak yükleniyor olarak gözüküyorsa:  
1. Glassfish'in kurulu olduğu klasöre gidin (Netbeans'de soldaki alanda Services bölümünde servers kısmına tıklayın -->  
Glassfish yazısına sağ tıklayıp Properties ile yerini öğrenebilirsiniz).  
2. Burada bin klasörünün içinde `asadadmin.bat` dosyasını çalıştırıp "start-domain" yazıp çalıştırın. Artık projenin başlatılabilmesi gerekiyor.  
3. Hata aldığınız durumlarda ve arada projeye sağ tıklayıp önce "Clean", daha sonra ise "Deploy" çalıştırın ve projeyi sonra başlatın.

<hr>

## 5- Gerekli Kütüphaneeleri Kurmak:
1-Gerekli kütüphaneler:  
orai18n-19.3.0.0,  
ucp11,  
ojdbc11

!(Staj Görevlinize HIBERNATE mi yoksa JDBS mi kullanılacağını sorun --> Hibernate ise sadece orai18n'yi kurun)!  
Verdiğim kaynak hibernate kullanmıyor o yüzden kurulumunu ve kullanımını kendiniz araştırıp bulmalısınız.  
Eğer direkt olarak Github adresime erişiminiz varsa bu dosyaları src --> java --> ExternalLib klasörünün içinde bulabilirsiniz.  
Eğer bir hata sonucu projeye tekrar eklemeniz gerekmesi durumda kullanmanız için benim gibi Source Packages içine bir klasör oluşturup  
kütüphaneleri buraya atın. Attıktan sonra NetBeans içinde Libraries klasörüne sağ tıklayın ve Add JAR/Folder seçeneği ile kütüphaneleri buraya ekleyin.

<hr>

## 6- Projenin genel yapısı:
Öncelikle Source Packages kısmına 4 adet klasör oluşturun:

util --> içinde sadece DBConnection isimli bir sınıf bulunan ve veritabanı bağlantımızı sağlayan klasörümüzdür.  
Bu bir abstract sınıf olacak ve içinde sadece connect isimli bir method yazılacak(Connection return etmeli)  
java.sql.Connection,  java.sql.DriverManager;  --> Bu iki kütüphaneyi import etmeyi unutmayın  
Kaynak videosunda bu methodun nasıl yapılacağı anlatılıyor

--  
Entity --> İçinde veritabanındaki ilgili tablonun değişkenlerini tutan java sınıflarını barındıracak  
Örnek olarak: Veritabanında Mahalle isimli bir tablo var ve içinde mahalle_id ve mahalle_isim sütunları var  
--> Entity içinde Mahalle isimli bir java sınıfı oluşturuyoruz  
--> içine private Integer mahalle_id ve private String mahale_isim şeklinde 2 değişken tanımlıyoruz  
-->ALT + INSERT yaparak hızlıca Getter Setter metodlarını oluşturun. Sonra aynı şekilde Constructor seçeneği ile boş ve dolu yapıcı metodlar oluşturun  
(Eğer mahalle_id otomatik veriliyorsa sadece mahalle_isim bulunduran bir yapıcı metod da oluşturun. Girmeniz gerekmeyen her değişken için bunu yapmanız sağlıklı olur)

--  
dao --> Entity içindeki değişkenleri kullanarak veritabanına satır eklemek, veri çekmek, listelemek, satır silmek gibi işlemler için kullanacağımız metodları buraya yazıyoruz.  
Öncelikle bağlantımızı almak için sınıf isminin yanına extends DBConnection ekliyoruz. "private Connection dbé isimli bir değişken tanımlıyoruz. Getter metoduna eğer null ise  
this.db = this.connect(); ile bağlantımızı sağlıyoruz.  
Ben şahsen gerekli metodlarımız için "CallableStatement" kullanmaya çalışıyorum --> Mantığı basit: veritabanında işlemi yerine getirecek ve gerekli parametreleri alacak bir stored procedure oluşturuyoruz  
ve kodumuzda bunu çağırıyoruz.  
Daha akla yatkın ama güvenlik sorunlarına neden olabilecek diğer yöntem ise "Statement" --> Temel mantığı string olarak yazdığımız veritabanı sql komutlarını Entity değişkenlerimizi vererek veritabanına göndermek olarak düşünebiliriz.  
Ayrıca ona çok benzeyen ve daha güvenli olan "PreparedStatement" kütüphanesini de araştırın.

Sınıf isimlendirmeleri genel olarak EntityDAO şeklinde yapılır. (örn:MahalleDAO)

--  
Controller --> Diğer Klasörlerin aksine burada CDI Bean dosyalarımız bulunacak ve websitemize buradan değişken atayabileceğiz ve değişkenimize ziyaretçi tarafından değer atanabilecek  
(Lütfen CDI Bean "Scope" türlerini araştırın ve uygun olanı seçin)  
Entity ve dao klasörlerimizdeki bağlantılı sınıfları burada aynı çuvala koyuyoruz. Temel olarak içinde 3 değişkenimiz var:  
Entity(Entity klasöründeki sınıfın ismi) entity;  
Dao(dao klasöründeki sınıfın ismi) dao;  
List<Entity> list; --> Bir tablonun içindeki verileri Entity nesneleri olarak depolayacak ve websitede liste olarak göstermemizi sağlayacak.

İsimlendirilmesi genel olarak EntityBean şeklinde yapılır  
Getter ve Setter kurduktan sonra Getter kısımlarına dao'da db değişkenine yaptığımız gibi eğer null ise yeni nesne üretmesini sağlayacağız

--  
Frontend kısmında Getter ve Setter yapılmayan değişkenler gözükmez!  
xhtml dosyamızda bu değişkenleri mesela inputtext oluştururken value = "#{mahalleBean.entity.mahalle_isim}" ile ziyaretçiden alınan yazının bu değişkene atanmasını sağlayabiliriz.  
(Burada mahalleBean.entity yazmış olabiliriz ama sistem otomatik olarak bu değişkene değil getter ve setter ile oluşturduğumuz getEntity() ve setEntity() metodlarına gider)  
Eğer bu değişkenlere atanan değerler ile bir insert veya silme işlemi yapmak isterseniz buton yaparken "value" yerine "action" kullanın.

<hr>

## 7- CSS değişiklikleri gözükmüyor:
Uzun süre css veya js dosyalarıyla oynadıktan sonra yaptığınız değişikliklerin siteye eklenmemesini yaşayabilirsiniz.  
Bunun nedeni sürekli projenizi tarayıcınızda açtığınızda tarayıcının bu proje için bir önbellek oluşturmasıdır.  
Bu sorunla karşılaştığınız zaman tarayıcınızın 1 veya 24 saatlik geçmişini silin

<hr>

## 8- Veritabanı:
Veritabanının nasıl olması gerektiğinden biraz bahsedelim.  
İlk önce her tablo için zorunlu olarak kullanacağımız sütunlar olacak. Bunlar: ABC_ID, AKTIF, KAYIT_TARIHI, EKLEYEN_KULLANICI_ID

ABC_ID --> Primary key olacak olan ilk sütunumuzdur, tabloyu oluştururken şu şekilde oluşturarak otomatik olarak artmasını sağlayabilirsiniz:  
ABC_ID NUMBER GENERATED by default on null as IDENTITY  
AKTIF --> Bu sütun o satırın aktif veya pasif olduğunu belirtir. Kolaylık açısından "number" ile oluşturup satırın durumuna göre 1 veya 0 atıyorum.  
KAYIT_TARIHI --> DATE türünde olan bu sütun kayıt yapıldığında o anki tarihi kayıt eder. Bunun için default değerini CURRENT_TIMESTAMP olarak ayarlayın.

<hr>

##Backend1 - Entity:  
Örnek olması amacıyla kisiAdres dosyalarını oluşturalım ve kullanalım.

İlk olarak kisiAdres.java dosyamızı entity klasöründe oluşturduk.
