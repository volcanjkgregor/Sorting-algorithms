
import java.util.Scanner;

public class DN2 {

    public static void main(String [] args){

        String delovanje = "";
        String urejanje = "";
        String smer = "";
        String vrstica;
        Scanner sc_v, sc_n;
        sc_v = new Scanner(System.in);
        vrstica = sc_v.nextLine();
        String[] podatki = vrstica.split(" ");
        vrstica = sc_v.nextLine();
        String[] stevila = vrstica.split(" +");



        odloci(podatki,stevila);

    }

    public static void odloci(String[] podatki, String[] stevila) {

        int[] zaporedje = new int[stevila.length];
        int drugi=0;
        for (int i = 0;i<zaporedje.length;i++) {zaporedje[i] = Integer.parseInt(stevila[i]);}


        switch (podatki[1]) {
            case "insert":
                Insert a = new Insert(podatki, zaporedje);
                if (podatki[0].equals("trace") && podatki[2].equals("up")){ a.sortirajUp(); }
                else if (podatki[0].equals("trace") && podatki[2].equals("down")) {a.sortirajDown();}
                else if (podatki[0].equals("count") && podatki[2].equals("down")) {
                    a.sortirajDown();
                    System.out.print(" | ");
                    a.sortirajDown();
                    System.out.print(" | ");
                    a.sortirajUp();
                }
                else if (podatki[0].equals("count") && podatki[2].equals("up")) {
                    a.sortirajUp();
                    System.out.print(" | ");
                    a.sortirajUp();
                    System.out.print(" | ");
                    a.sortirajDown();
                }
                break;

            case "select":
                Select b = new Select(podatki, zaporedje);
                if (podatki[0].equals("trace") && podatki[2].equals("up")){ b.sortirajUp(); }
                else if (podatki[0].equals("trace") && podatki[2].equals("down")){ b.sortirajDown(); }
                else if (podatki[0].equals("count") && podatki[2].equals("down")) {
                    b.sortirajDown();
                    System.out.print(" | ");
                    b.sortirajDown();
                    System.out.print(" | ");
                    b.sortirajUp();
                }
                else if (podatki[0].equals("count") && podatki[2].equals("up")) {
                    b.sortirajUp();
                    System.out.print(" | ");
                    b.sortirajUp();
                    System.out.print(" | ");
                    b.sortirajDown();
                }
                break;

            case "bubble":
                Bubble c = new Bubble(podatki, zaporedje);
                if (podatki[0].equals("trace") && podatki[2].equals("up")){ c.sortirajUp(); }
                else if (podatki[0].equals("trace") && podatki[2].equals("down")){ c.sortirajDown(); }
                else if (podatki[0].equals("count") && podatki[2].equals("down")) {
                    c.sortirajDown();
                    System.out.print(" | ");
                    c.sortirajDown();
                    System.out.print(" | ");
                    c.sortirajUp();
                    }
                else if (podatki[0].equals("count") && podatki[2].equals("up")) {
                    c.sortirajUp();
                    System.out.print(" | ");
                    c.sortirajUp();
                    System.out.print(" | ");
                    c.sortirajDown();
                    }
                break;

            case "heap":
                Heap d = new Heap(podatki,zaporedje);
                if (podatki[0].equals("trace") && podatki[2].equals("up")){ d.sortirajUp(); }
                else if (podatki[0].equals("trace") && podatki[2].equals("down")){ d.sortirajDown(); }
                break;
            case "merge":
                Merge e = new Merge(podatki,zaporedje);
                if (podatki[0].equals("trace") && podatki[2].equals("up")){ e.mergeUp(zaporedje); }
                else if (podatki[0].equals("trace") && podatki[2].equals("down")){ e.mergeUp(zaporedje); }
                else if (podatki[0].equals("count") && podatki[2].equals("up")){
                    e.mergeUp(zaporedje);e.info();
                    System.out.print(" | ");
                    e.mergeUp(e.getZaporedje());e.info();
                    System.out.print(" | ");
                    podatki[2]="down";e.setPodatki(podatki);
                    e.mergeUp(e.getZaporedje());e.info();
                }
                else if (podatki[0].equals("count") && podatki[2].equals("down")){
                    e.mergeUp(zaporedje);e.info();
                    System.out.print(" | ");
                    e.mergeUp(e.getZaporedje());e.info();
                    System.out.print(" | ");
                    podatki[2]="up";e.setPodatki(podatki);
                    e.mergeUp(e.getZaporedje());e.info();
                }
                break;

            case "quick":
                Quick f = new Quick(podatki,zaporedje);
                if (podatki[0].equals("trace") && podatki[2].equals("up")){ f.quicksort(zaporedje, 0, zaporedje.length-1);
                    System.out.println();
                for (int i=0;i<zaporedje.length;i++){
                    System.out.print(zaporedje[i]);
                }}
                else if (podatki[0].equals("trace") && podatki[2].equals("down")){ f.quicksort(zaporedje, 0, zaporedje.length-1);
                    System.out.println();
                    for (int i=0;i<zaporedje.length;i++){
                        System.out.print(zaporedje[i]+" ");
                    }
                }
                else if (podatki[0].equals("count") && podatki[2].equals("down")){
                    f.quicksort(zaporedje,0,zaporedje.length-1);f.info();
                    System.out.print(" | ");
                    f.quicksort(f.getZaporedje(),0,f.getZaporedje().length-1);f.info();
                    System.out.print(" | ");
                    podatki[2]="up";f.setPodatki(podatki);
                    f.quicksort(f.getZaporedje(),0,f.getZaporedje().length-1);f.info();
                }
                else if (podatki[0].equals("count") && podatki[2].equals("up")){
                    f.quicksort(zaporedje,0,zaporedje.length-1);f.info();
                    System.out.print(" | ");
                    f.quicksort(f.getZaporedje(),0,f.getZaporedje().length-1);f.info();
                    System.out.print(" | ");
                    podatki[2]="down";f.setPodatki(podatki);
                    f.quicksort(f.getZaporedje(),0,f.getZaporedje().length-1);f.info();
                }
                break;
        }

    }


}

class Insert {
    private int stPrimerjav = 0;
    private int stPremikov = 0;
    private int[] zaporedje;
    private String[] podatki;
    private int size = 0;

    public int[] getZaporedje() {
        return zaporedje;
    }

    public String[] getPodatki() {
        return podatki;
    }

    public void setZaporedje(int[] zaporedje) {
        this.zaporedje = zaporedje;
    }

    public Insert(String[] podatki, int[] zaporedje) {
        this.zaporedje = zaporedje;
        this.podatki = podatki;
        this.size = zaporedje.length;

    }

    public void sortirajUp() {
        int[] z = getZaporedje();
        int crta = 0;

        if (getPodatki()[0].equals("trace")){
            System.out.print(z[0]);
            for (int i=1;i<z.length;i++){
                System.out.print(" "+z[i]);
            }
            System.out.println();
            crta++;
        }


        for (int i=1;i<z.length;i++){
            int k = z[i];
            stPremikov++;
            int j = i;
            while (j>0 && compareTo(z[j-1],k)>0){
                z[j] = z[j-1];
                j = j - 1;
                stPremikov++;
            }
            z[j]=k;
            stPremikov++;

            if (getPodatki()[0].equals("trace")) {
                izpis(crta, z);
                crta++;
            }
        }

        if (getPodatki()[0].equals("count")) {
            System.out.print(stPremikov+" "+stPrimerjav);
        }

        setZaporedje(z);
        stPrimerjav=0;
        stPremikov=0;

    }


    public void sortirajDown() {
        int[] z = getZaporedje();
        int crta = 0;

        if (getPodatki()[0].equals("trace")){
            System.out.print(z[0]);
            for (int i=1;i<z.length;i++){
                System.out.print(" "+z[i]);
            }
            System.out.println();
            crta++;
        }


        for (int i=1;i<z.length;i++){
            int k = z[i];
            stPremikov++;
            int j = i;
            while (j>0 && compareTo(z[j-1],k)<0){
                z[j] = z[j-1];
                j = j - 1;
                stPremikov++;
            }
            z[j]=k;
            stPremikov++;

            if (getPodatki()[0].equals("trace")) {
                izpis(crta, z);
                crta++;
            }
        }

        if (getPodatki()[0].equals("count")) {
            System.out.print(stPremikov+" "+stPrimerjav);
        }

        setZaporedje(z);
        stPrimerjav=0;
        stPremikov=0;

    }

    public void izpis(int crta, int[] z){
        if (crta==z.length) {
            for (int i=0;i<z.length;i++){
                System.out.print(z[i]+" ");
            }
            System.out.print("| konec");
        }
        else{
            for (int i = 0; i < z.length; i++) {
                if (i == z.length) System.out.print(z[i]);
                else {
                    if (i == crta) {
                        System.out.print(z[i] + " | ");
                    } else {
                        System.out.print(z[i] + " ");
                    }
                }
            }
        }

        System.out.println();
    }



    public int compareTo(int st1, int st2){
        int result = st1 - st2;
        stPrimerjav++;
        return result;
    }
}
class Select {
    private int stPrimerjav = 0;
    private int stPremikov = 0;
    private int[] zaporedje;
    private String[] podatki;
    private int size = 0;

    public int[] getZaporedje() {
        return zaporedje;
    }

    public String[] getPodatki() {
        return podatki;
    }

    public void setZaporedje(int[] zaporedje) {
        this.zaporedje = zaporedje;
    }

    public Select(String[] podatki, int[] zaporedje) {
        this.zaporedje = zaporedje;
        this.podatki = podatki;
        this.size = zaporedje.length;
    }


    public void sortirajUp() {
        int [] z = getZaporedje();
        int crta = 0;

        if (getPodatki()[0].equals("trace")){
            System.out.print(z[0]);
            for (int i=1;i<z.length;i++){
                System.out.print(" "+z[i]);
            }
            System.out.println();
        }

        for (int i=0;i<z.length-1;i++) {
            int m = i;
            for (int j=i+1;j<z.length;j++) {
                if (compareTo(z[j],z[m])<0) {m=j;}

            }
            swap(z, i, m);
            if (getPodatki()[0].equals("trace")) {
                risicrto(crta, z);
                crta++;
            }
        }

        if (getPodatki()[0].equals("count")) {
            System.out.print(stPremikov+" "+stPrimerjav);
        }

        setZaporedje(z);
        stPrimerjav=0;
        stPremikov=0;

    }

    public void sortirajDown() {
        int [] z = getZaporedje();
        int crta = 0;

        if (getPodatki()[0].equals("trace")){
            System.out.print(z[0]);
            for (int i=1;i<z.length;i++){
                System.out.print(" "+z[i]);
            }
            System.out.println();
        }

        for (int i=0;i<z.length-1;i++) {
            int m = i;
            for (int j=i+1;j<z.length;j++) {
                if (compareTo(z[j],z[m])>0) {m=j;}

            }
            swap(z, i, m);
            if (getPodatki()[0].equals("trace")) {
                risicrto(crta, z);
                crta++;
            }
        }

        if (getPodatki()[0].equals("count")) {
            System.out.print(stPremikov+" "+stPrimerjav);
        }
        setZaporedje(z);
        stPrimerjav=0;
        stPremikov=0;
    }

    public void risicrto(int crta, int[] z){

        for (int i=0;i<z.length;i++){
            if (i==z.length-1) System.out.print(z[i]);
            else {
                if (i == crta) {
                    System.out.print(z[i] + " | ");
                } else {
                    System.out.print(z[i] + " ");
                }
            }
        }

        System.out.println();
    }

    public int compareTo(int st1, int st2){
        int result = st1 - st2;
        stPrimerjav++;
        return result;
    }

    public void swap(int[] zaporedje, int prvo, int drugo) {
        int temp = zaporedje[prvo];
        zaporedje[prvo]=zaporedje[drugo];
        zaporedje[drugo]=temp;
        stPremikov+=3;
    }
}

class Bubble {
    private int stPrimerjav = 0;
    private int stPremikov = 0;
    private int[] zaporedje;
    private String[] podatki;
    private int size = 0;

    public int[] getZaporedje() {
        return zaporedje;
    }

    public String[] getPodatki() {
        return podatki;
    }

    public void setZaporedje(int[] zaporedje) {
        this.zaporedje = zaporedje;
    }

    public Bubble(String[] podatki, int[] zaporedje) {
        this.zaporedje = zaporedje;
        this.podatki = podatki;
        this.size = zaporedje.length;
    }


    public void sortirajUp(){
        int [] z = getZaporedje();
        int crta = 0;

        if (getPodatki()[0].equals("trace")){
            System.out.print(z[0]);
            for (int i=1;i<z.length;i++){
                System.out.print(" "+z[i]);
            }
            System.out.println();
        }

        int lastSwap=0;
        for (int i=0;i<z.length-2;i=lastSwap){
            lastSwap=z.length-2;
            for (int j=z.length-2;j>=i;j--){
                if (compareTo(z[j],z[j+1])>0){
                    swap(z,j,j+1);
                    lastSwap=j;
                }
            }

            if (getPodatki()[0].equals("trace")) {
                risicrto(lastSwap, z);
            }
            stPrimerjav--;

        }

        if (getPodatki()[0].equals("count")) {
            System.out.print(stPremikov+" "+(stPrimerjav+1));

        }
        setZaporedje(z);
        stPrimerjav=0;
        stPremikov=0;


    }



    /*
    public void sortirajUp(){
        int [] z = getZaporedje();
        int crta = 0;

        if (getPodatki()[0].equals("trace")){
            System.out.print(z[0]);
            for (int i=1;i<z.length;i++){
                System.out.print(" "+z[i]);
            }
            System.out.println();
        }

        int lastSwap=0;
        for (int i=0;i<z.length-1;i=lastSwap){
            int c=0;
            lastSwap=z.length-1;
            for (int j=z.length-2;j>=i;j--){
                if (compareTo(z[j],z[j+1])>0){
                    swap(z,j,j+1);
                    lastSwap=j;
                    c++;
                }
                System.out.println(c);
            }

            if (getPodatki()[0].equals("trace")) {
                if (c>1){crta+=c-1;}
                risicrto(crta, z);
                crta++;
            }

        }

        if (getPodatki()[0].equals("count")) {
            System.out.print(stPremikov+" "+stPrimerjav);
        }
        setZaporedje(z);
        stPrimerjav=0;
        stPremikov=0;

    }
    */

    public void sortirajDown(){
        int [] z = getZaporedje();
        int crta = 0;

        if (getPodatki()[0].equals("trace")){
            System.out.print(z[0]);
            for (int i=1;i<z.length;i++){
                System.out.print(" "+z[i]);
            }
            System.out.println();
        }

        int lastSwap=0;
        for (int i=0;i<z.length-2;i=lastSwap){
            int c=0;
            lastSwap=z.length-2;
            for (int j=z.length-2;j>=i;j--){
                if (compareTo(z[j],z[j+1])<0){
                    swap(z,j,j+1);
                    lastSwap=j;
                }
                else {c++;}
            }

            if (getPodatki()[0].equals("trace")) {
                risicrto(lastSwap, z);
            }
            stPrimerjav--;

        }

        if (getPodatki()[0].equals("count")) {
            System.out.print(stPremikov+" "+(stPrimerjav+1));
        }
        setZaporedje(z);
        stPrimerjav=0;
        stPremikov=0;


    }

    public void risicrto(int crta, int[] z) {
        if (crta < z.length - 1) {
            for (int i = 0; i < z.length; i++) {
                if (i == z.length - 1) System.out.print(z[i]);
                else {
                    if (i == crta) {
                        System.out.print(z[i] + " | ");
                    } else {
                        System.out.print(z[i] + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    public int compareTo(int st1, int st2){
        int result = st1 - st2;
        stPrimerjav++;
        return result;
    }

    public void swap(int[] zaporedje, int prvo, int drugo) {
        int temp = zaporedje[prvo];
        zaporedje[prvo]=zaporedje[drugo];
        zaporedje[drugo]=temp;
        stPremikov+=3;
    }

}

class Heap {
    private int stPrimerjav = 0;
    private int stPremikov = 0;
    private int[] zaporedje;
    private String[] podatki;
    private int size = 0;

    public int[] getZaporedje() {
        return zaporedje;
    }

    public String[] getPodatki() {
        return podatki;
    }

    public void setZaporedje(int[] zaporedje) {
        this.zaporedje = zaporedje;
    }

    public Heap(String[] podatki, int[] zaporedje) {
        this.zaporedje = zaporedje;
        this.podatki = podatki;
        this.size = zaporedje.length;
    }

    public void sortirajUp(){
        int [] z = getZaporedje();
        int crta = 0;

        if (getPodatki()[0].equals("trace")){
            System.out.print(z[0]);
            for (int i=1;i<z.length;i++){
                System.out.print(" "+z[i]);
            }
            System.out.println();
        }

        //algoritem



        if (getPodatki()[0].equals("count")) {
            System.out.print(stPremikov+" "+stPrimerjav);
        }
        setZaporedje(z);
        stPrimerjav=0;
        stPremikov=0;
    }

    public void sortirajDown(){
        int [] z = getZaporedje();
        int crta = 0;
        int last = z.length-1;
        int items = z.length;
        int parentLast = (z.length-1)/2;


        if (getPodatki()[0].equals("trace")){
            System.out.print(z[0]);
            for (int i=1;i<z.length;i++){
                System.out.print(" "+z[i]);
            }
            System.out.println();
        }

        for (int i = parentLast; i>= 0; i--){
            int trenutno = z[i];

            int parent  = i;
            int child = 2*parent+1;

            while (child < items){
                if (child <= last-1 && compareTo(z[child],z[child+1]) <0){
                    child++;
                }
                if (compareTo(trenutno,z[child]) <0){
                    swap(z,parent,child);
                    parent=child;
                    child= 2*parent+1;
                }
            }
        }





        if (getPodatki()[0].equals("count")) {
            System.out.print(stPremikov+" "+stPrimerjav);
        }
        setZaporedje(z);
        stPrimerjav=0;
        stPremikov=0;
    }

    public void siftDown(int[] z, int i){}


    public void risicrto(int crta, int[] z){

        for (int i=0;i<z.length;i++){
            if (i==z.length-1) System.out.print(z[i]);
            else {
                if (i == crta) {
                    System.out.print(z[i] + " | ");
                } else {
                    System.out.print(z[i] + " ");
                }
            }
        }

        System.out.println();
    }

    public int compareTo(int st1, int st2){
        int result = st1 - st2;
        stPrimerjav++;
        return result;
    }

    public void swap(int[] zaporedje, int prvo, int drugo) {
        int temp = zaporedje[prvo];
        zaporedje[prvo]=zaporedje[drugo];
        zaporedje[drugo]=temp;
        stPremikov+=3;
    }

}

class Merge {
    private int stPrimerjav = 0;
    private int stPremikov = 0;
    private int[] zaporedje;
    private String[] podatki;
    private int size = 0;

    public int[] getZaporedje() {
        return zaporedje;
    }

    public String[] getPodatki() {
        return podatki;
    }

    public void setPodatki(String[] podatki) {
        this.podatki = podatki;
    }

    public void setZaporedje(int[] zaporedje) {
        this.zaporedje = zaporedje;
    }

    public Merge(String[] podatki, int[] zaporedje) {
        this.zaporedje = zaporedje;
        this.podatki = podatki;
        this.size = zaporedje.length;

        if (getPodatki()[0].equals("trace")){
            System.out.print(zaporedje[0]);
            for (int i=1;i<zaporedje.length;i++){
                System.out.print(" "+zaporedje[i]);
            }
        }
    }



    public void mergeUp(int[] z){
        int middle=0;
        if (z.length%2==1) {middle = (z.length) / 2 +1;}
        else {middle = (z.length) / 2;}



        int[] left = new int[middle];
        int[] right = new int[z.length - middle];
        if (z.length <= 1) {return;}
        else {
            if (getPodatki()[0].equals("trace")) {
                System.out.println();
            }
            for (int i = 0; i < middle; i++) {
                left[i] = z[i];
                stPremikov++;
                if (getPodatki()[0].equals("trace")) {
                    System.out.print(z[i] + " ");
                }
            }
            if (getPodatki()[0].equals("trace")) {
                System.out.print("|");
            }
            int ccccc = 0;
            for (int i = middle; i < z.length; i++) {
                right[ccccc] = z[i];
                stPremikov++;
                ccccc++;
                if (getPodatki()[0].equals("trace")) {
                    System.out.print(" " + z[i]);
                }
            }
            mergeUp(left);
            mergeUp(right);

            merge(z,left,right);
        }


        return;
    }

    public void merge(int[] temp,int[] left, int[] right){
        int k = left.length;
        int l = right.length;
        int i = 0;
        int j = 0;
        int t = 0;
        //System.out.println();
        //for (int a=0;a<left.length;a++) System.out.print(left[a]+ " ");
        //System.out.println();
        //for (int a=0;a<right.length;a++) System.out.print(right[a]+ " ");

        while(i<k && j<l){
            if (getPodatki()[2].equals("up")) {
                if (compareTo(left[i], right[j]) <= 0) {
                    temp[t] = left[i];
                    stPremikov++;

                    i++;
                } else {
                    temp[t] = right[j];
                    stPremikov++;
                    //stPrimerjav++;
                    j++;
                }
            }
            else {
                if (compareTo(left[i], right[j]) >= 0) {
                    temp[t] = left[i];
                    stPremikov++;

                    i++;
                } else {
                    temp[t] = right[j];
                    stPremikov++;
                    //stPrimerjav++;
                    j++;
                }
            }

            t++;
        }
        while (i<k) {
            temp[t]=left[i];
            stPremikov++;
            ////stPrimerjav++;
            t++;
            i++;
        }
        while (j<l) {
            temp[t]=right[j];
            stPremikov++;
            ////stPrimerjav++;
            t++;
            j++;
        }
        if (getPodatki()[0].equals("trace")) {
            System.out.println();
            for (int a = 0; a < temp.length; a++) System.out.print(temp[a] + " ");
        }
    }



    public void info(){
        System.out.print(stPremikov+" "+stPrimerjav);
        stPremikov=0;
        stPrimerjav=0;
    }

    public int compareTo(int st1, int st2){
        int result = st1 - st2;
        stPrimerjav++;
        return result;
    }

    public void swap(int[] zaporedje, int prvo, int drugo) {
        int temp = zaporedje[prvo];
        zaporedje[prvo]=zaporedje[drugo];
        zaporedje[drugo]=temp;
        stPremikov+=3;
    }
}

class Quick {
    private int stPrimerjav = 0;
    private int stPremikov = 0;
    private int[] zaporedje;
    private String[] podatki;
    private int size = 0;

    public int[] getZaporedje() {
        return zaporedje;
    }

    public String[] getPodatki() {
        return podatki;
    }

    public void setPodatki(String[] podatki) {
        this.podatki = podatki;
    }

    public void setZaporedje(int[] zaporedje) {
        this.zaporedje = zaporedje;
    }

    public Quick(String[] podatki, int[] zaporedje) {
        this.zaporedje = zaporedje;
        this.podatki = podatki;
        this.size = zaporedje.length;

        if (getPodatki()[0].equals("trace")){
            System.out.print(zaporedje[0]);
            for (int i=1;i<zaporedje.length;i++){
                System.out.print(" "+zaporedje[i]);
            }
        }
    }

    //algorithm
    public int partition(int[] z, int left, int right) {
        int p = z[left];
        int l = left; int r = right + 1;


        while (true) {
            if (getPodatki()[2].equals("up")) {
                do {
                    l++;
                } while (compareTo(z[l], p) < 0 && compareTo(l, right) < 0);
                do {
                    r--;
                } while (compareTo(z[r], p) > 0);
                if (compareTo(l, r) >= 0) {
                    break;
                }
                swap(z, l, r);
            }
            if (getPodatki()[2].equals("down")) {
                do {
                    l++;
                } while (compareTo(z[l], p) > 0 && compareTo(l, right) < 0);
                do {
                    r--;
                } while (compareTo(z[r], p) < 0);
                if (compareTo(l, r) >= 0) {
                    break;
                }
                swap(z, l, r);
            }
        }

        swap(z,left,r);


        return r;
    }

    public void quicksort(int[] z, int left, int right) {
        if (compareTo(left,right)>=0){return;}
        int r = partition(z,left,right);
        quicksort(z,left,r-1);
        quicksort(z, r+1,right);
    }

    public void info(){
        System.out.print(stPremikov+" "+stPrimerjav);
        stPremikov=0;
        stPrimerjav=0;
    }

    public int compareTo(int st1, int st2){
        int result = st1 - st2;
        stPrimerjav++;
        return result;
    }

    public void swap(int[] zaporedje, int prvo, int drugo) {
        int temp = zaporedje[prvo];
        zaporedje[prvo]=zaporedje[drugo];
        zaporedje[drugo]=temp;
        stPremikov+=3;
    }

}
