package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
    public static void main(String[] args) {
        // Task : Functional Programming ile listin cift ,
        // elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz
        List<Integer> sayi = new ArrayList<>(Arrays.asList(2, 3, 5, 8, -2, 6, 11, 13,-8));

        tekKupBirFazlaPrint(sayi);
        System.out.println(" ****** ");
        ciftKareKokPrint(sayi);
        System.out.println(" ****** ");
        maxElemanBul(sayi);
        System.out.println(" ****** ");
        maxElemanBulKare(sayi);
    }

    public static void ciftkareprintet(List<Integer> sayi){
        sayi.stream().filter(Lambda01::ciftBul).map(t-> t*t).forEach(Lambda01::yazdir);
    }

    public static void tekKupBirFazlaPrint(List<Integer> sayi){
        sayi.stream().filter(t-> t%2==1).map(t-> (t*t*t)).forEach(Lambda01::yazdir);

    }
    // Task : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
// Task : Functional Programming ile listin cift
// elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKareKokPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).
                forEach(t-> System.out.print(t+" "));


    }
    // Task : list'in en buyuk elemanini yazdiriniz
    public static void maxElemanBul(List<Integer> sayi){

        Optional<Integer>maxSayi=sayi.stream().reduce(Math::max);

        System.out.println(maxSayi);
    }
    /*
 reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
 kullanımı yaygındır pratiktir.
 Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
 bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
 reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
 reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
 İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

 */
    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void maxElemanBulKare(List<Integer> sayi){

        System.out.println(sayi.stream().filter(Lambda01::ciftBul).map(t-> t*t).reduce(Math::max));
    }

}
