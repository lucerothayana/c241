import org.example.HaService;

public class MockHaService implements HaService {
    public static String luma =
            "{ \"nomeDoProfessor\": \"Luma\", \n " +
                "\"horarioDeAtendimento\": \"19h30\", \n" +
                "\"periodo\": \"noturno\", \n " +
                "\"sala\": \"1\", \n " +
                 "\"predio\": \"[1]\"}";

    public static String ynoguti =
            "{ \"nomeDoProfessor\": \"Ynoguti\", \n " +
                    "\"horarioDeAtendimento\": \"17h30\", \n" +
                    "\"periodo\": \"integral\", \n " +
                    "\"sala\": \"6\", \n " +
                    "\"predio\": \"[2]\"}";
    public static String bueno =
            "{ \"nomeDoProfessor\": \"Bueno\", \n " +
                    "\"horarioDeAtendimento\": \"19h30\", \n" +
                    "\"periodo\": \"noturno\", \n " +
                    "\"sala\": \"11\", \n " +
                    "\"predio\": \"[3]\"}";
    public static String chris =
            "{ \"nomeDoProfessor\": \"Chris\", \n " +
                    "\"horarioDeAtendimento\": \"17h30\", \n" +
                    "\"periodo\": \"integral\", \n " +
                    "\"sala\": \"16\", \n " +
                    "\"predio\": \"[4]\"}";
    public static String elisa =
            "{ \"nomeDoProfessor\": \"Elisa\", \n " +
                    "\"horarioDeAtendimento\": \"10h30\", \n" +
                    "\"periodo\": \"integral\", \n " +
                    "\"sala\": \"21\", \n " +
                    "\"predio\": \"[5]\"}";
    public static String karina =
            "{ \"nomeDoProfessor\": \"Karina\", \n " +
                    "\"horarioDeAtendimento\": \"21h30\", \n" +
                    "\"periodo\": \"noturno\", \n " +
                    "\"sala\": \"26\", \n " +
                    "\"predio\": \"[6]\"}";

    //testes de falha
    public static String vazio =
            "{ \"nomeDoProfessor\": , \n " +
                    "\"horarioDeAtendimento\":, \n" +
                    "\"periodo\": , \n " +
                    "\"sala\":, \n " +
                    "\"predio\": }";
    public static String profErrado =
            "{ \"nomeDoProfessor\": \"Francisco\", \n " +
                    "\"horarioDeAtendimento\": \"19h30\", \n" +
                    "\"periodo\": \"noturno\", \n " +
                    "\"sala\": \"1\", \n " +
                    "\"predio\": \"[1]\"}";

    public static String perErrado =
            "{ \"nomeDoProfessor\": \"Egidio\", \n " +
                    "\"horarioDeAtendimento\": \"10h30\", \n" +
                    "\"periodo\": \"noturno\", \n " +
                    "\"sala\": \"26\", \n " +
                    "\"predio\": \"[6]\"}";
    public static String salaErrada =
            "{ \"nomeDoProfessor\": \"Joao\", \n " +
                    "\"horarioDeAtendimento\": \"21h30\", \n" +
                    "\"periodo\": \"noturno\", \n " +
                    "\"sala\": \"20\", \n " +
                    "\"predio\": \"[6]\"}";
    public static String predioInvalido =
            "{ \"nomeDoProfessor\": \"Joao\", \n " +
                    "\"horarioDeAtendimento\": \"21h30\", \n" +
                    "\"periodo\": \"noturno\", \n " +
                    "\"sala\": \"20\", \n " +
                    "\"predio\": \"[10]\"}";

    public static String SalaInvalidaPos =
            "{ \"nomeDoProfessor\": \"Joao\", \n " +
                    "\"horarioDeAtendimento\": \"21h30\", \n" +
                    "\"periodo\": \"noturno\", \n " +
                    "\"sala\": \"300\", \n " +
                    "\"predio\": \"[10]\"}";
    public static String SalaInvalidaNeg =
            "{ \"nomeDoProfessor\": \"Joao\", \n " +
                    "\"horarioDeAtendimento\": \"21h30\", \n" +
                    "\"periodo\": \"noturno\", \n " +
                    "\"sala\": \"-2\", \n " +
                    "\"predio\": \"[10]\"}";

    @Override
    public String retornoHA(int professor) {
       if(professor == 1){
           return  luma;
       }
       else if(professor == 2){
           return ynoguti;
       }
       else if(professor == 3){
           return bueno;
       }
       else if(professor == 4){
           return chris;
       }
       else if(professor == 5){
           return elisa;
       }
       else if(professor == 6){
           return karina;
       }
       else if(professor == 0){
           return vazio;
       }
       else if(professor == 10){
           return profErrado;
       }
       else if(professor == 11){
           return perErrado;
       }
       else if(professor == 12){
           return salaErrada;
       }
       else if(professor == 13){
           return predioInvalido;
       }
       else return null;
    }
}
