package app_utilities;


import java.util.Calendar;

public class TimeData {

    public static String numberToTime (Integer numero) {

        String text_value = Integer.toString(numero.intValue());

        if ( text_value.length() == 2) {

            return text_value;

        } else {

            return "0" + text_value;

        }

    }


    public static String intToTime (int numero) {

        String text_value = Integer.toString(numero);

        if ( text_value.length() == 2) {

            return text_value;

        } else {

            return "0" + text_value;

        }

    }

    public static String openedUntil(int ora, int minuto) {

        int hclose = ora;
        int mclose = minuto;

        int ore_rimanenti = 12 - ora + 1;
        int minuti_rim = 60 - minuto;

        return "Chiude tra " + ore_rimanenti + " ore e " + minuti_rim +  " minuti";

        /*Calendar hour = Calendar.getInstance();

        Calendar closeat = Calendar.getInstance();
        closeat.set(Calendar.HOUR_OF_DAY,hclose);



        closeat.set(Calendar.MINUTE,mclose);

        Long distance = closeat.getTimeInMillis() - hour.getTimeInMillis();
        Calendar result = Calendar.getInstance();
        result.setTimeInMillis(distance);

        int huntil = result.get(Calendar.HOUR) - 1;
        int muntil = result.get(Calendar.MINUTE);


        if (huntil>=0) {
            return "Chiude tra " + huntil + " ore e " + muntil + " minuti";

        } else {
            return "";
        }
            */


    };



}
