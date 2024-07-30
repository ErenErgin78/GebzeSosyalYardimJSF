# Gebze Sosyal Yardım sitesinin yapılışı için kılavuz

<hr>

## 1- Kurulumlar:
- Git
- Github Desktop
- JAVA 8 UPDATE 421
- Eclipse Temurin JDK with hotspot 17.0.11
- Java(TM) SE Development Kit 17.0.11
- Apache Netbeans IDE 22
- Oracle Database 19c Enterprise Edition ([indirme linki](https://edelivery.oracle.com/osdc/faces/SoftwareDelivery)) (2. Maddedeki BTK akademi kursu ile birlikte kurmanız tavsiye edilir!)
<hr>

## 2- Video Kaynak:
JSF kullanımı ve website yapımı:
[YouTube](https://www.youtube.com/watch?v=R4glkRS_6rE&list=PL4XQdSx4Y7b7VFll7oLNp9a2Nqp0dMsoI)

Database ile ilgili kısımları geçebilirsiniz çünkü farklı bir database kullanıyor. Eğer database kurulumunda ve/veya kullanımında sorun yaşarsanız:
[BTK Akademi](https://www.btkakademi.gov.tr/portal/course/sifirdan-ileri-seviye-oracle-sql-19567)

<hr>

## 3- Netbeans'den proje oluşturmak:
1. Java Ant içinde Java Web'e gelin, "Web Application" seçeneğini seçin ve ilerleyin.
2. Server seçme kısmında GlassFish seçin ve orada 6.2.5 sürümünü seçerek indirin.
3. Firework seçme kısmında Java Faces seçin ve Server Libraries seçeneğinde 3.0 seçin.
4. Finish diyerek bitirin.

<hr>

## 4- Glassfish hatası:
Eğer projeyi başlatmaya çalıştığınızda undeployed hatası alıyorsanız veya proje sürekli olarak yükleniyor olarak gözüküyorsa:
1. Glassfish'in kurulu olduğu klasöre gidin (Netbeans'de soldaki alanda Services bölümünde servers kısmına tıklayın --> Glassfish yazısına sağ tıklayıp Properties ile yerini öğrenebilirsiniz).
2. Burada bin klasörünün içinde `asadadmin.bat` dosyasını çalıştırıp "start-domain" yazıp çalıştırın. Artık projenin başlatılabilmesi gerekiyor.
3. Hata aldığınız durumlarda ve arada projeye sağ tıklayıp önce "Clean", daha sonra ise "Deploy" çalıştırın ve projeyi sonra başlatın.

<hr>

5- Gerekli Kütüphaneeleri Kurmak:
1-Gerekli kütüphaneler:
orai18n-19.3.0.0,
ucp11,
ojdbc11

Eğer direkt olarak Github adresime erişiminiz varsa 


## 6- Projenin genel yapısı:
1- 
























