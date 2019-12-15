package formating;

import java.text.DecimalFormat;

public class DFormat {

    public String dfFormat(int casas, double valor) {

        String valorFormatado = "";
        
        switch (casas) {

            case 2:
                DecimalFormat df2 = new DecimalFormat("#,##0.00");
                valorFormatado = df2.format(valor);
                break;

            case 3:
                DecimalFormat df3 = new DecimalFormat("#,##0.000");
                valorFormatado = df3.format(valor);
                break;

            default:
                DecimalFormat df4 = new DecimalFormat("#,##0.0000");
                valorFormatado = df4.format(valor);
                break;

        }
        
        return valorFormatado.replaceAll(",", ".");

    }

}
