/**
 * Created by Ignas on 2017.03.14.
 */
import com.company.jar2.Keitimas;
public class Main {
    public static void main(String[] args) {


        Keitimas klase = new Keitimas();
        klase.pasisveikink();

        while (true) {

            klase.paklausk();
            klase.nuspresk();
        }
    }
}
