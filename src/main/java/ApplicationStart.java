import cnp.CnpUtils;

public class ApplicationStart {

    public static void main(String[] args) {

        String[] cnp = {" 1930107189436", "2960229513249", "2970229513249", "1961308409971"};
        String[] yymmdd = {cnp[0].substring(1, 7), cnp[1].substring(1, 7), cnp[2].substring(1, 7), cnp[3].substring(1, 7)};

        System.out.println(CnpUtils.controlValidation(cnp[0]));

    }
}
