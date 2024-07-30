Gebze Sosyal Yardım sitesinin yapılışı için kılavuz.
-------------------------------------------------------------------------------------------------------------------------------------------------------

1-Kurulumlar:

Git
Github Desktop

JAVA 8 UPDATE 421

Eclipse Temurin JDK with hotspot 17.0.11

Java(TM) SE Development Kit 17.0.11

Apache Netbeans IDE 22

Oracle Database 19c Enterprise Edition (https://edelivery.oracle.com/osdc/faces/SoftwareDelivery)
(https://www.btkakademi.gov.tr/portal/course/player/deliver/sifirdan-ileri-seviye-oracle-sql-19567)
-------------------------------------------------------------------------------------------------------------------------------------------------------


2- Video Kaynak:
https://www.youtube.com/watch?v=R4glkRS_6rE&list=PL4XQdSx4Y7b7VFll7oLNp9a2Nqp0dMsoI

Database ile ilgili kısımları geçebilirsiniz çünkü farklı bir database kullanıyor.
Eğer database kurulumunda ve/veya kullanımında sorun yaşarsanız:
https://www.btkakademi.gov.tr/portal/course/sifirdan-ileri-seviye-oracle-sql-19567
-------------------------------------------------------------------------------------------------------------------------------------------------------


3-Netbeans'den proje oluşturmak:
Java Ant içinde Java Web'e gelin, "Web Application" seçeneğini seçin ve ilerleyin
Server seçme kısmında GlassFish seçin ve orada 6.2.5 sürümünü seçerek indirin
Firework seçme kısmında Java Faces seçin ve Server Libraries seçeneğinde 3.0 seçin
Finish diyerek bitirin
-------------------------------------------------------------------------------------------------------------------------------------------------------

4-Glassfish hatası:
Eğer projeyi başlatmaya çalıştığınızda undeployed hatası alıyorsanız veya proje sürekli olarak yükleniyor olarak gözüküyorsa:
Glassfish'in kurulu olduğu klasöre gidin (Netbeans'de soldaki alanda Services bölümünde servers kısmına tıklayın --> Glassfish yazısına sağ tıklayıp Properties ile yerini öğrenebilirsiniz)
Burada bin klasörünün içinde asadadmin.bat dosyasını çalıştırıp "start-domain" yazıp çalıştırın. Artık projenin başlatılabilmesi gerekiyor.
Hata aldığınız durumlarda ve arada projeye sağ tıklayıp önce "Clean", daha sonra ise "Deploy" çalıştırın ve projeyi sonra başlatın.

-------------------------------------------------------------------------------------------------------------------------------------------------------

