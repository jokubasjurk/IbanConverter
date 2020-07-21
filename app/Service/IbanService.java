package Service;

public class IbanService {

    private String countryCode;
    private String bankCode;

    public IbanService(String countryCode, String bankCode)
    {
        this.countryCode = countryCode;
        this.bankCode = bankCode;
    }

    public String getNormalizedIban()
    {
        int len = bankCode.length();
        int count = 0,prad=0,pab=0;

        char res = bankCode.charAt(0);
        for (int i=0; i<len; i++)
        {
            int cur_count = 1;
            for (int j=i+1; j<len; j++)
            {
                if (bankCode.charAt(i) != bankCode.charAt(j))
                    break;
                cur_count++;
            }

            if (cur_count > count)
            {
                count = cur_count;
                pab=i;
                res = bankCode.charAt(i);
            }
        }
        int pradzia = pab;
        int i = pab;
        while(i<len && bankCode.charAt(i)==res){
            i++;
        }
        pab=i;
        String rezult = bankCode;
        if(count>=2)
            rezult = bankCode.substring(0, pradzia) + '(' + bankCode.substring(pradzia,pab) + ')' + bankCode.substring(pab,len);
        String code = countryCode + ' ' + rezult;

        return code;
    }

}
