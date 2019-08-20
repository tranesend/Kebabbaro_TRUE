package data_repository;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Luoghi {

   public ArrayList<Place> Labels;

    public Luoghi() {

        initialize();

    }

    void initialize(){

        Labels = new ArrayList<Place>();
        this.Labels.addAll(Arrays.asList(setContent()));

    }




    public static Place[] setContent() {

        /* Repository di tutti i marker*/

        Place[] vector = new Place[] {

                new Place (1,"Via Francesco Selmi, 41","Via Francesco Selmi, 41, 00156 Roma RM, Italia",41.927961,12.570238,"3,5","5,0"," ","Arena Pizza Kebab", 2, 0),
                new Place (2,"Circonvallazione Gianicolense, 7","Circonvallazione Gianicolense, 7, 00152 Roma RM, Italia",41.8731605,12.4654219,"4,0"," "," ","Kebab Pizza Bar", 5, 0),
                new Place (3,"Via Giovanni Volpato, 17/19","Via Giovanni Volpato, 17/19, 00146 Roma RM, Italia",41.8715038,12.4677002," "," "," ","Gold Istanbul Kebab", 2, 30),
                new Place (4,"Via Luigi Fincati, 22","Via Luigi Fincati, 22, 00154 Roma RM, Italia",41.8772647,12.4366605," "," "," ","Pizza & Kebab", null, null),
                new Place (5,"Viale Eritrea, 23","Viale Eritrea, 23, 00199 Roma RM, Italia",41.9141977,12.4999953," "," "," ","Ciro & Pizza Kebab", 2, 0),
                new Place (6,"Via Pietralata, 309","Via di Pietralata, 309, 00158 Roma RM, Italia",41.9141977,12.4999953," "," "," ","Pizza Kebab Egiziana", null, null),
                new Place (7,"Via Augusto Valenziani, 14","Via Augusto Valenziani, 14, 00187 Roma RM, Italia",41.9101293,12.4968931," "," "," ","Kebab Valenziani", 23, 30),
                new Place (8,"Via Giovanni Giolitti, 89","Via Giovanni Giolitti, 89, 00185 Roma RM, Italia",41.8995851,12.4994453," "," "," ","Istanbul Doner Kebab", 24, 0),
                new Place (9,"Via dei Sabelli, 36","Via dei Sabelli, 36, 00185 Roma RM, Italia",41.8986168,12.5184539," "," "," ","Kebab House", 2, 30),
                new Place (10,"Via di Santa Maria Maggiore, 179","Via di Santa Maria Maggiore, 179, 00184 Roma RM, Italia",41.8972912,12.495441,"4,0"," "," ","Kebab Santa Maria Maggiore Roma", 2, 0),
                new Place (11,"Via Laurentina, 595","Via Laurentina, 595, 00040 Roma RM, Italia",41.8458226,12.4792506,"4,0"," "," ","Tavola Calda Pizza Kebab", 2, 30),
                new Place (12,"Viale America, 139","Viale America, 139, 00144 Roma RM, Italia",41.8293026,12.4694882,"4,0"," "," ","Rim Food Pizzeria Kebab", 23, 0),
                new Place (13,"Via Giustiniano Imperatore, 29","Viale Giustiniano Imperatore, 29, 00145 Roma RM, Italia",41.856866,12.4790261,"4,0"," "," ","Istanbul Kebab", 2, 0),
                new Place (14,"Via Carroceto, 96","Via Carroceto, 96, 00179 Roma RM, Italia",41.8670931,12.537288,"4,0"," ","5,0","Ali Baba", 0, 0),
                new Place (15,"Via S. Francesco a Ripa, 165","Via di S. Francesco a Ripa, 165, 00153 Roma RM, Italia",41.8886791,12.4708006," "," "," ","Kebab & Shisha Roma", 2, 0),
                new Place (16,"Viale di Trastevere, 51","Viale di Trastevere, 51, 00153 Roma RM, Italia",41.8747673,12.4659781," "," "," ","Mr Kebab Turco Trastevere", 2, 0),
                new Place (17,"Corso Vittorio Emanuele II, 347","Corso Vittorio Emanuele II, 347, 00186 Roma RM, Italia",41.9004678,12.465446," "," "," ","Kebab Omar", 23, 0),
                new Place (18,"Via dei Castani, 251","Via dei Castani, 251, 00172 Roma RM, Italia",41.8786949,12.5664118," "," "," ","Ciro Kebab", 2, 0),
                new Place (19,"Piazza Bologna, 7","Piazza Bologna, 7, 00162 Roma RM, Italia",41.9139636,12.5206233," "," "," ","Kebab King Pizza Queen", 0, 0),
                new Place (20,"Pzz.le della Stazione del Lido, 11","Piazzale della Stazione del Lido, 11, 00122 Lido di Ostia RM, Italia",41.7319634,12.2836804," "," "," ","Kebab Turco Istanbul", -1, -1),
                new Place (21,"Corso Regina Maria Pia, 19","Corso Regina Maria Pia, 19, 00122 Lido di Ostia RM, Italia",41.7302637,12.2830038," "," "," ","Casa Kebab Istanbul", 5, 0),
                new Place (22,"Via Danilo Stiepovich, 151","Via Danilo Stiepovich, 151, 00121 Lido di Ostia RM, Italia",41.7400248,12.2719527," "," "," ","Pizza Paradiso e Kebab Ostia", 23, 0),
                new Place (23,"Via Tiburtina, 419","Via Tiburtina, 419, 00157 Roma RM, Italia",41.908568,12.5370616," "," "," ","Ciro Kebab", 0, 0),
                new Place (24,"Circonvallazione Cornelia, 10","Circonvallazione Cornelia, 10, 00165 Roma RM, Italia",41.900561,12.4264789," "," "," ","Da Coriolano Pizza Kebab Roma", 1, 30),
                new Place (25,"Via Nizza, 18","Via Nizza, 18, 00198 Roma RM, Italia",41.9113,12.498500000000035," "," "," ","Ciro Kebab", 0, 0),
                new Place (26,"Via Nomentana, 15","Via Nomentana, 15, 00141 Roma RM, Italia",41.9101881,12.5022067,"3,99"," "," ","Istanbul Kebab", -1, -1),
                new Place (27,"Piazzale Jonio, 43/45","Piazzale Jonio, 43/45, 00139 Roma RM, Italia",41.9459461,12.5257644," "," "," ","Pizzeria Tavola Calda Kebab", -1, -1),
                new Place (28,"Via di Tor Sapienza, 4","Via di Tor Sapienza, 4, 00155 Roma RM, Italia",41.903610,12.589833," "," "," ","Marrakech Kebab", 22, 0),
                new Place (29,"Via del Faro, 154","Via del Faro, 154, 00054 Fiumicino RM, Italia",41.765040,12.2125822," "," "," ","Zaza Istanbul Kebab", 0, 0),
                new Place (30,"Piazza S.Leonardo da P. Maurizio, 31","Piazza S.Leonardo da Porto Maurizio, 31, 00125 Roma RM, Italia",41.7828971,12.3648977," "," "," ","Best Kebab", 23, 0),
                new Place (31,"Via Cesare Maccari, 115","Via Cesare Maccari, 115, 00125 Roma RM, Italia",41.7736961,12.3581171," "," "," ","Casa Kebab Istanbul", 23, 0),
                new Place (32,"Via Adolfo Borgognoni, 21","Via Adolfo Borgognoni, 21, 00124 Roma RM, Italia",41.7348137,12.3530102," "," "," ","Gul Kebab", null, null),
                new Place (33,"Piazza M. Marescotti","Piazza M. Marescotti, 00055 Ladispoli RM, Italia",41.9491496,12.0784378," "," "," ","Istanbul Doner Kebab", null, null),
                new Place (34,"Via Salaria, 222","Via Salaria, 222, 00015 Monterotondo RM, Italia",42.0578963,12.5825965," "," "," ","A tutta Pizza e Kebab", null, null),
                new Place (35,"Via Tuscolana, 1802","Via Tuscolana, 1802, 00173 Roma RM, Italia",41.8421833,12.5846672," "," "," ","Istanbul Kebab Bar Pizza", -1, -1),
                new Place (36,"Via Alberto Ascari, 196","Via Alberto Ascari, 196, 00142 Roma RM, Italia",41.834701,12.5038147," "," "," ","Pizza Nader", 22, 0),
                new Place (38,"Viale dello Statuto, 42","Viale dello Statuto, 42, 04100 Latina LT, Italia",41.466298,12.9112154," "," "," ","Istanbul Pascia' Kebap", 1, 15),
                new Place (39,"Viale della Stazione, 190","Viale della Stazione, 190, 04100 Latina Scalo LT, Italia",41.5321619,12.9461002," "," "," ","Il Melograno Kebab", 0, 45)




        };

        return vector;

    }


}
