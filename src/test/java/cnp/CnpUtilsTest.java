package cnp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CnpUtilsTest {

    @org.junit.jupiter.api.Test
    void between() {
        String[] cnp = {"1930107189436", "9960229513249"};
        String[] sex = {String.valueOf(cnp[0].charAt(0)), String.valueOf(cnp[1].charAt(0))};
        assertTrue(CnpUtils.between(sex[0], 1, 8));
        assertFalse(CnpUtils.between(sex[1], 1, 8));

    }

    @org.junit.jupiter.api.Test
    void cnpDateValidation() {
        String[] cnp = {"1930107189436", "2960229513249", "2970229513249", "1961308409971"};
        String[] yymmdd = {cnp[0].substring(1, 7), cnp[1].substring(1, 7), cnp[2].substring(1, 7), cnp[3].substring(1, 7)};
        assertTrue(CnpUtils.cnpDateValidation(yymmdd[0]));
        assertTrue(CnpUtils.cnpDateValidation(yymmdd[1]));
        assertFalse(CnpUtils.cnpDateValidation(yymmdd[2]));
        assertFalse(CnpUtils.cnpDateValidation(yymmdd[3]));
    }

    @org.junit.jupiter.api.Test
    void structureValidation() {
        String[] cnp = {"  1930107189436  ", "9960229513249", "1930107189436", "2970229513249", "19613084099711"};
        assertTrue(CnpUtils.structureValidation(cnp[0]));
        assertFalse(CnpUtils.structureValidation(cnp[1]));
        assertTrue(CnpUtils.structureValidation(cnp[2]));
        assertFalse(CnpUtils.structureValidation(cnp[3]));
        assertFalse(CnpUtils.structureValidation(cnp[4]));

    }

    @org.junit.jupiter.api.Test
    void controlValidation() {
        String[] cnp = {" 1930107189436", "19301071894366", "2961022513249"};
        assertTrue(CnpUtils.controlValidation(cnp[0]));
        assertFalse(CnpUtils.controlValidation(cnp[1]));
        assertTrue(CnpUtils.controlValidation(cnp[2]));
    }

    @org.junit.jupiter.api.Test
    void isValid() {
        String[] cnp = {"  1930107189436  ", "2961022513249", "1961308409971"};
        assertTrue(CnpUtils.isValid(cnp[0]));
        assertFalse(CnpUtils.isValid(cnp[1]));
        assertFalse(CnpUtils.isValid(cnp[2]));

    }
}