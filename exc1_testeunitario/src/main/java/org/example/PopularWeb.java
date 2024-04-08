package org.example;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PopularWeb {

    //servico real/mock do servidor externo
    HaService haService;
    Professor professor;

    //construtor inicializando os membros
    public PopularWeb(HaService haService){
        this.haService = haService;
    }

    //metodo de popular a pagina
    public Professor popularPagina(int matricula){

        String haJson = haService.retornoHA(matricula);

        if(haJson != null){
            JsonObject jsonObject = JsonParser.parseString(haJson).getAsJsonObject();

            professor = new Professor(jsonObject.get("nomeDoProfessor").getAsString(),
                    jsonObject.get("horarioDeAtendimento").getAsString(),
                    jsonObject.get("periodo").getAsString(),
                    jsonObject.get("sala").getAsString(),
                    jsonObject.get("predio").getAsString());

            System.out.print("Estou populando uma pagina web com as informações:\t");
            System.out.println(professor.getNome());

            return professor;
        }
        else return null;
    }
}
