package my.web.app.shop.models;

public class CalcModel {
    public static double getResult(int n1,int n2,String sign){
        switch (sign){
            case "plus":
                return n1 + n2;
            case "umn":
                return n1 * n2;
            case "div":
                return (double) n1 / n2;
            case "dif":
                return n1 - n2;
        }
        return 0;
    }
}
