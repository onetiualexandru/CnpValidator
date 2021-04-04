import cnp.CnpException;
import cnp.CnpValidationUtils;
import cnp.CnpValidatorImpl;

public class ApplicationStart {

    public static void main(String[] args) {

        String[] cnp = {" 1930107189436", "2960229513249", "6970221513249", "1961308409971"};
        String[] yymmdd = {cnp[0].substring(1, 7), cnp[1].substring(1, 7), cnp[2].substring(1, 7), cnp[3].substring(1, 7)};

        CnpValidatorImpl cnpValidator=new CnpValidatorImpl();

        for (int i = 0; i < cnp.length; i++) {
            try {
                System.out.println(cnpValidator.validateCnp(cnp[i]).sex());
                System.out.println( cnpValidator.validateCnp(cnp[i]).birthDate().year());
                System.out.println( cnpValidator.validateCnp(cnp[i]).county());
            } catch (CnpException e) {
                e.printStackTrace();
            }
        }


        System.out.println(CnpValidationUtils.controlValidation(cnp[0]));

    }
}
