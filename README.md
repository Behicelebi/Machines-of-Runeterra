# Machines of Runeterra

Bu proje, Kocaeli Üniversitesi Bilgisayar Mühendisliği Bölümü Programlama Laboratuvarı-I dersi kapsamında geliştirilmiş bir savaş araçları kart oyununu içermektedir. Oyun, nesne yönelimli programlama (NYP) prensiplerini kullanarak tasarlanmış ve öğrencilerin stratejik düşünme becerilerini geliştirmeyi amaçlamaktadır.

## Proje Hakkında
### Amaç
Bu projenin temel amacı, öğrencilere nesne yönelimli programlama (NYP) kavramlarını uygulamalı olarak öğretmektir. Soyut sınıflar, miras alma, kapsülleme ve çok biçimlilik gibi temel NYP prensipleri, oyunun yapısında kullanılmıştır.

### Oyunun Yapısı
Oyun, oyuncunun bilgisayara karşı hava, kara ve deniz araçlarını içeren kartlarla stratejik hamleler yaptığı bir yapıdadır. Her araç türü, saldırı avantajları ve dayanıklılık değerleri gibi farklı özelliklerle tasarlanmıştır. Oyunda, oyuncuların seçimlerine dayalı puanlama ve seviyelendirme mekanizmaları uygulanmış, oyunun ilerleyişi dinamik hale getirilmiştir.

### Sınıf Yapıları
Oyunun geliştirilmesinde nesne yönelimli programlama (NYP) prensipleri temel alınmıştır. Her sınıf, spesifik bir işlevi yerine getirmek üzere tasarlanmış ve bu sınıflar arasında açık bir hiyerarşi kurulmuştur.

### Savaş Araçları Sınıfı (Abstract):
Bu sınıf, oyundaki tüm araçların ortak özelliklerini ve davranışlarını tanımlar. Soyut bir sınıf olarak oluşturulmuş ve doğrudan örneklenemez.

### Özellikler:

dayanıklılık: Kartın oyundaki dayanıklılığını temsil eder.

seviyePuanı: Kartın kazanılan puanlara göre artan seviyesi.

vuruş: Kartın saldırı gücü.

### Metotlar:

KartPuaniGoster: Kartın puanını ve dayanıklılığını kullanıcıya gösterir.

DurumGuncelle: Kartın dayanıklılığını ve seviyesini günceller.

### Hava, Kara ve Deniz Sınıfları (Abstract):
Savaş Araçları sınıfından türetilen bu sınıflar, daha spesifik özellikler ve davranışlar içerir.

Hava Sınıfı: Uçak ve Siha kartlarını kapsar. Kara vuruş avantajına sahiptir.

Kara Sınıfı: Obüs ve KFS kartlarını kapsar. Deniz vuruş avantajına sahiptir.

Deniz Sınıfı: Fırkateyn ve Sida kartlarını kapsar. Hava vuruş avantajına sahiptir.

### Alt Sınıflar:
Her araç türü için ayrı sınıflar tanımlanmıştır. Örneğin, Uçak sınıfı Hava sınıfından türetilmiş ve belirli dayanıklılık ve saldırı gücü değerleriyle özelleştirilmiştir.

Uçak: Hava sınıfından türetilmiş, başlangıç dayanıklılığı 20.

Siha: Hava sınıfından türetilmiş, başlangıç dayanıklılığı 15 ve deniz vuruş avantajı vardır.

Obüs: Kara sınıfından türetilmiş, başlangıç dayanıklılığı 20.

KFS: Kara sınıfından türetilmiş, başlangıç dayanıklılığı 10 ve hava vuruş avantajı vardır.

Fırkateyn: Deniz sınıfından türetilmiş, başlangıç dayanıklılığı 25.

Sida: Deniz sınıfından türetilmiş, başlangıç dayanıklılığı 15 ve kara vuruş avantajı vardır.

### Oyuncu ve Oyun Sınıfları:

### Oyuncu Sınıfı: Oyuncuların ID, isim ve skor bilgilerini tutar. Ayrıca, oyuncunun kart listesini ve kart seçme fonksiyonunu içerir.

### Oyun Sınıfı: Oyunun ana yapısını oluşturur. Kart dağıtımı, hamle yönetimi ve saldırı hesaplamalarını içerir.

## Oyun Algoritması
Oyun, belirli kurallara göre ilerleyen dinamik bir yapıya sahiptir. Temel adımlar şu şekildedir:

### Başlangıç Aşaması:

Oyuncu ve bilgisayara hava, kara ve deniz araçlarından toplam altı kart dağıtılır.

Oyuncu, başlangıçta yalnızca uçak, obüs ve fırkateyn kartlarını seçebilir. Diğer kartlar, oyuncunun seviye puanına ulaştığında açılır.

### Hamle Mekanizması:

Oyuncu, elindeki kartlardan üç tanesini seçer. Bilgisayar ise rastgele üç kart seçer.

Seçilen kartlar sırasıyla karşılaştırılır ve her bir eşleşme için saldırı değerleri hesaplanır.

Dayanıklılık değeri 0 veya altına düşen kartlar elenerek oyundan çıkarılır.

### Saldırı ve Seviye Hesaplama:

Saldırı hesaplaması sırasında kartın rakip kart karşısında bir avantajı varsa, saldırı değeri bu avantaj doğrultusunda artırılır.

Kart, rakip kartı elediğinde ek seviye puanı kazanır. Bu puan hem kartın seviyesine hem de oyuncunun toplam skoruna eklenir.

### Oyun Bitişi:

Tüm kartlar tükenir ya da belirlenen hamle sayısı tamamlanır.

Skorlar karşılaştırılır ve yüksek skora sahip oyuncu kazanan olarak ilan edilir.

## UML Diyagramı ve Tablo
Sınıflar ve ilişkiler, UML diyagramında gösterilmiştir. Bu diyagram, sınıfların birbirleriyle olan miras ilişkilerini ve oyundaki rolünü detaylandırmaktadır.

Savaş araçlarına ait dayanıklılık, saldırı avantajı ve seviye puanı bilgileri ise tablo olarak sunulmuştur. Bu bilgiler, her kart türünün oyundaki etkisini anlamayı kolaylaştırmaktadır.

### Kullanılan Teknolojiler ve Araçlar
Programlama Dili: Java, C++ veya C#.

Nesneye Yönelik Yapılar: Soyut sınıflar, miras alma, çok biçimlilik, kapsülleme.

Test Süreci: Oyun algoritmaları ve kart seçimi rastgelelik üzerinden birçok senaryoda test edilmiştir.

## Katkıda Bulunanlar
Murat Emre Biçici: Savaş mekaniklerinin matematiksel modellemesini ve algoritmalarını geliştirmiş, birimlerin saldırı, dayanıklılık ve seviye puanı hesaplamalarının doğruluğunu sağlamak amacıyla gerekli fonksiyonları yazmıştır.

Behiç Çelebi: Java Swing kullanarak simülasyonun görselleştirilmesi, savaşın bütün adımlarının kullanıcıya sunulması ve kartların sağlık durumlarının grafiksel gösterimi konularında çalışmıştır.

Kaynakça
[1] Kocaeli Üniversitesi Proje Dökümanı

[2] Java Documentation https://docs.oracle.com/javase/

[3] Design Patterns Explained https://refactoring.guru/design-patterns

## Screenshots
<table>
 <tr>
  <td>demo1</td>
  <td>demo2</td>
  <td>demo3</td>
 </tr>
 <tr>
  <td><img src="https://github.com/Behicelebi/Machines-of-Runeterra/blob/master/screenshots/demo1.jpg"></td>
  <td><img src="https://github.com/Behicelebi/Machines-of-Runeterra/blob/master/screenshots/demo2.jpg"></td>
  <td><img src="https://github.com/Behicelebi/Machines-of-Runeterra/blob/master/screenshots/demo3.jpg"></td>
 </tr>
</table>
