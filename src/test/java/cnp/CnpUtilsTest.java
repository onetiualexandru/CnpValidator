package cnp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CnpUtilsTest {

    @org.junit.jupiter.api.Test
    void cnpSexValidation() {
        String[] cnp = {"1930107189436", "9960229513249"};
        String[] sex = {String.valueOf(cnp[0].charAt(0)), String.valueOf(cnp[1].charAt(0))};
        assertTrue(CnpValidationUtils.cnpSexValidation(sex[0]));
        assertFalse(CnpValidationUtils.cnpSexValidation(sex[1]));

    }

    @org.junit.jupiter.api.Test
    void cnpCountyValidation() {
        String[] cnp = {"1930107189436", "2960229483249"};
        //county[0]=18, county[1]=48
        String[] county = {cnp[0].substring(7, 9), cnp[1].substring(7, 9)};
        assertTrue(CnpValidationUtils.cnpCountyValidation(county[0]));
        assertFalse(CnpValidationUtils.cnpCountyValidation(county[1]));

    }


    @org.junit.jupiter.api.Test
    void cnpDateValidation() throws CnpException {
        String[] cnp = {"1930107189436", "2960229513249", "2970229513249", "1961308409971"};
        String[] yymmdd = {cnp[0].substring(1, 7), cnp[1].substring(1, 7), cnp[2].substring(1, 7), cnp[3].substring(1, 7)};
        
        assertTrue(CnpValidationUtils.cnpDateValidation(yymmdd[0]));
        assertTrue(CnpValidationUtils.cnpDateValidation(yymmdd[1]));
        assertFalse(CnpValidationUtils.cnpDateValidation(yymmdd[2]));
        assertFalse(CnpValidationUtils.cnpDateValidation(yymmdd[3]));


    }

    @org.junit.jupiter.api.Test
    void structureValidation() {
        String[] cnp = {"  1930107189436  ", "9960229513249", "1930107189436", "2970229513249", "19613084099711"};

        assertTrue(CnpValidationUtils.structureValidation(cnp[0]));
        assertFalse(CnpValidationUtils.structureValidation(cnp[1]));
        assertTrue(CnpValidationUtils.structureValidation(cnp[2]));
        assertFalse(CnpValidationUtils.structureValidation(cnp[3]));
        assertFalse(CnpValidationUtils.structureValidation(cnp[4]));


    }

    @org.junit.jupiter.api.Test
    void controlValidation() {
        String[] cnp = {" 1930107189436", "19301071894366", "2961022513249"};

        assertTrue(CnpValidationUtils.controlValidation(cnp[0]));
        assertFalse(CnpValidationUtils.controlValidation(cnp[1]));
        assertTrue(CnpValidationUtils.controlValidation(cnp[2]));
    }

    @org.junit.jupiter.api.Test
    void isValid() {
        String[] cnp = {"  1930107189436  ", "2961022513249", "1961308409971"};

        assertTrue(CnpValidationUtils.isValid(cnp[0]));
        assertTrue(CnpValidationUtils.isValid(cnp[1]));
        assertFalse(CnpValidationUtils.isValid(cnp[2]));

    }
}