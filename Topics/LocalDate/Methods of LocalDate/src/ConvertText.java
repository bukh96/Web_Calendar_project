// ConvertText 20 5.5
public class ConvertText {
  public static void main(String[] args) {
    //args values: 20 5.5
    String a = args[0]; // 20
    String b = args[1]; // 5.5

    int aInt = Integer.parseInt(a);     // 20 converted to int
    float bFloat = Float.parseFloat(b); // 5.5 converted to float

    float total = aInt * bFloat; //
    System.out.println("total " + total);
  }
}