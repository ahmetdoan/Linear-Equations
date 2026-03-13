# 3x3 Doğrusal Denklem Çözücü

Java ile yazılmış, 2x2 ve 3x3 linear denklem sistemlerini **Cramer** ve **Gauss** yöntemleriyle çözen bir uygulama.

---

## Ne Yapıyor?

* 2x2 doğrusal denklem sistemi Cramer yöntemi ile çözülür.
* 3x3 doğrusal denklem sistemlerini hem Cramer hem de Gauss yöntemiyle çözer ve iki yöntemi kıyaslanır.
* İki doğrunun kesişim noktasını hem konsoldan hem de GUI ile hesaplar.
* Çözümü olmayan matrixleri tespit edip, çözüm yok uyarısı verir.

---

## Kullanılan Yöntemler

### Cramer
Her bilinmeyeni determinant hesaplamasıyla bulur. Katsayı matrisinin determinantı sıfırsa sistem çözümsüzdür.


Küçük matrisler için hızlı ve anlaşılırdır ancak matris boyutu büyüdükçe çözüm zamanı çok artar bu yüzden büyük sistemlerde Gauss tercih edilir.

### Gauss Eliminasyonu (Partial Pivoting)
Matris üst üçgen forma getirilir, ardından back substitution ile çözüm bulunur. Her adımda sütundaki en büyük eleman pivot olarak seçilir
buna *partial pivoting* denir. 
Küçük katsayıların olduğu sistemlerde Cramer'a göre daha iyi sonuç verir.

---

## Sınıflar

```
linearEquationProject/
│
├── LinearEquation.java                  - 2x2 denklem (Cramer)
├── LinearEquation3x3Cramer.java         - 3x3 Cramer çözüm
├── LinearEquation3x3Gauss.java          - 3x3 Gauss çözüm (partial pivoting)
│
├── P2aConsoleTest.java                  - 2x2
├── P2bIntersectionConsole.java          - Doğru kesişimi 
├── P2cGUI.java                          - Doğru kesişimi GUI
│
├── LinearEquationGaussVsCramer.java     - Cramer vs Gauss zaman karşılaştırması
├── SolverTest.java                      - Test sınıfı (4 örnek denklem)
```
---
## GUI Görüntüsü
![alt text](<GUI SS-1.png>)
---

## Test Sınıfı

`SolverTest.java` çalıştırılarak 4 farklı denklemin iki yöntem ile çözümü gözlemlenlenebilir:

* Test 1 -> Tam sayılı çözüm
* Test 2 -> Kesirli çözüm
* Test 3 -> Çözüm yok
* Test 4 -> Epsilon kontrolü



## Teknik Notlar

- Determinant sıfır kontrolü, ufak sayıların binary'ye çevrilirken basamak kaybı olup cevabı hatalı hale getirmemesi için, != 0 yerine `Math.abs(det) > 1e-10` ile yapılmıştır.
- Gauss çözümü orijinal matrisi değiştirmek yerine kopyası üzerinde işlem yapar.
- Saf Java ile yazılmıştır.

