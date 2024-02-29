import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _21010310010_Main {

    private List<String> line1List;
    private List<String> line2List;
    private List<String> line3List;
    private List<String> line4List;
    private List<List<List<String>>> table;
    private List<String> durumSirasi;
    private List<String> durumSirasi2;
    private List<String> cikti;
    private List<String> cikti2;


    public static void main(String[] args) {
        try {
            _21010310010_Main fsm = new _21010310010_Main("FST.txt");
            fsm.calistir();
            fsm.calistir2();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public _21010310010_Main(String dosyaAdi) throws FileNotFoundException {
        line1List = new ArrayList<>();
        line2List = new ArrayList<>();
        line3List = new ArrayList<>();
        line4List = new ArrayList<>();
        table = new ArrayList<>();
        durumSirasi = new ArrayList<>();
        durumSirasi2 = new ArrayList<>();
        cikti = new ArrayList<>();
        cikti2 = new ArrayList<>();

        File dosya = new File(dosyaAdi);
        Scanner input = new Scanner(dosya);

        elemanOkuma(input);

        tabloIsleme(input);

        input.close();
    }

    private void elemanOkuma(Scanner input) {
        line1List = makeArrayList(input.nextLine().replace("Q = ", "").replace("{", "").replace("}", "").replace(" ", "").split(","));
        line2List = makeArrayList(input.nextLine().replace("Σ = ", "").replace("{", "").replace("}", "").replace(" ", "").split(","));
        line3List = makeArrayList(input.nextLine().replace("Γ = ", "").replace("{", "").replace("}", "").replace(" ", "").split(","));
        line4List = makeArrayList(input.nextLine().replace("δ\t", "").replace("\t", ",").split(","));
    }

    private void tabloIsleme(Scanner input) {
        for (int k = 0; k < line1List.size(); k++) {
            List<String> A = new ArrayList<>();
            String[] lineXArray = input.nextLine().replace("\t", "-").split("-");

            for (String s : lineXArray) {
                A.add(s);
            }

            String tmpString = A.get(0);
            A.remove(0);

            List<List<String>> tmpArray = new ArrayList<>();
            for (String value : A) {
                List<String> tmpList = new ArrayList<>();
                tmpList.add(tmpString);
                tmpList.add(value);
                tmpArray.add(tmpList);
            }

            table.add(tmpArray);
        }

        String lineXString = input.nextLine().replace("q0 ", "").replace("=", "").replace(" ", "");
        durumSirasi.add(lineXString);
        durumSirasi2.add(lineXString);
    }

    private void girdiAlma1(int input) {
        List<Integer> girilenDeger = new ArrayList<>();

        while (input > 0) {
            int rakam = input % 10;
            girilenDeger.add(0, rakam);
            input = input / 10;
        }

        for (int k = 0; k < girilenDeger.size(); k++) {
            for (int i = 0; i < line1List.size(); i++) {
                if (durumSirasi.get(durumSirasi.size() - 1).equals(table.get(i).get(0).get(0))) {
                    List<String> sonList = new ArrayList<>();
                    sonList.add(table.get(i).get(girilenDeger.get(k)).get(1));

                    for (String eleman : sonList) {
                        String[] parcalanmis = eleman.replace("(", "").replace(")", "").split(",");
                        if (parcalanmis.length == 2) {
                            String q1 = parcalanmis[0];
                            String sifir = parcalanmis[1];
                            durumSirasi.add(q1);
                            cikti.add(sifir);
                        }
                    }
                    break;
                }
            }
        }
    }

    private void girdiAlma2(int input) {
        List<Integer> girilenDeger2 = new ArrayList<>();

        while (input > 0) {
            int rakam = input % 10;
            girilenDeger2.add(0, rakam);
            input = input / 10;
        }

        for (int k = 0; k < girilenDeger2.size(); k++) {

            for (int i = 0; i < line1List.size(); i++) {

                if (durumSirasi.get(durumSirasi.size() - 1).equals(table.get(i).get(0).get(0))) {
                    List<String> sonList2 = new ArrayList<>();
                    sonList2.add(table.get(i).get(girilenDeger2.get(k)).get(1));

                    for (String eleman : sonList2) {
                        String[] parcalanmis = eleman.replace("(", "").replace(")", "").replace(" ","").split(",");
                        if (parcalanmis.length == 2) {
                            String q1 = parcalanmis[0];
                            String sifir = parcalanmis[1];
                            durumSirasi2.add(q1);
                            cikti2.add(sifir);
                        }
                    }
                    break;
                }
            }
        }
    }
    
    public void calistir() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Lütfen birinci inputu giriniz: ");
        int sayi1 = sc.nextInt();
        girdiAlma1(sayi1);

        cıktıVer(durumSirasi, cikti);

    }
    public void calistir2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Lütfen ikinci inputu giriniz: ");
        int sayi2 = sc.nextInt();
        girdiAlma2(sayi2);

        cıktıVer2(durumSirasi2, cikti2);
    }

    private void cıktıVer(List<String> durumSirasi, List<String> cikti) {
        System.out.println("Durumların sırası: " + durumSirasi);
        System.out.print("Çıktı: ");
        for (String b : cikti) {
            System.out.print(b);
        }
        System.out.println();
    }
    private void cıktıVer2(List<String> durumSirasi2, List<String> cikti2) {
        System.out.println("Durumların sırası: " + durumSirasi2);
        System.out.print("Çıktı: ");
        for (String b : cikti2) {
            System.out.print(b);
        }
        System.out.println();
    }



    private List<String> makeArrayList(String[] array) {
        List<String> tmpArray = new ArrayList<>();
        for (String s : array) {
            tmpArray.add(s);
        }
        return tmpArray;
    }

}
