import cnp.CnpException;
import cnp.CnpValidatorImpl;

public class ApplicationStart {

    public static void main(String[] args) {

        String[] cnp = {"  1930107189436  ", "2961022513249", "1961308409971"};

        CnpValidatorImpl cnpValidator = new CnpValidatorImpl();

        for (int i = 0; i < cnp.length; i++) {
            try {
                cnpValidator.validateCnp(cnp[i]);
            } catch (CnpException e) {
                e.printStackTrace();
            }
        }


    }
}
