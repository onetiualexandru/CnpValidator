package cnp;

public class CnpValidatorImpl implements CnpValidator {

    private Sex sex;


    @Override
    public CnpParts validateCnp(String cnp) throws CnpException {

        setCnpParts(cnp);

        CnpParts cnpParts = new CnpParts() {
            @Override
            public Sex sex() {
                return sex;
            }

            @Override
            public Boolean foreigner() {
                return null;
            }

            @Override
            public CalDate birthDate() {
                return CnpUtils.getCalDate();
            }

            @Override
            public County county() {
                return null;
            }

            @Override
            public Integer orderNumber() {
                return null;
            }
        };

        return cnpParts;
    }

    private void setCnpParts(String cnpParts) {

        final Sex sex = CnpUtils.getSex();
    }


}



