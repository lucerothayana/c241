import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.HaService;
import org.example.PopularWeb;
import org.example.Professor;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class TestesFalha {
    HaService service;
    PopularWeb popularWeb;
    PopularWeb popularWeb2;

    @Before
    public void setup(){
        service = new MockHaService();
        popularWeb = new PopularWeb(service);
        popularWeb2 = new PopularWeb(service);
    }

    @Test
    public void testeVazioNome(){
        Professor testeProf = popularWeb.popularPagina(0);
        assertEquals(" ",testeProf.getNome());
    }

    @Test
    public void testeVazioPeriodo(){
        Professor testeProf = popularWeb.popularPagina(0);
        assertEquals(" ",testeProf.getPeriodo());
    }

    //não passa, nao sei o pq, era pra ser null mesmo
    @Test
    public void testeMatInvalida(){
        assertNull(popularWeb.popularPagina(100));
    }

    @Test
    public void testePredioInvalido(){
        Professor testeProf = popularWeb.popularPagina(13);
        String predioS = testeProf.getPredio();
        predioS = predioS.replace("[", "");
        predioS = predioS.replace("]", "");
        int predio = Integer.parseInt(predioS);
        boolean predioinvalido=false;

        if(predio<1 || predio>6)
            predioinvalido = true;

        assertTrue(predioinvalido);
    }
    @Test
    public void testeSalaInvalidaPos(){
        Professor testeProf = popularWeb.popularPagina(15);
        int sala = Integer.parseInt(testeProf.getSala());
        boolean salainvalida=false;

        if(sala>30)
            salainvalida = true;

        assertTrue(salainvalida);
    }

    @Test
    public void testeSalaInvalidaNeg(){
        Professor testeProf = popularWeb.popularPagina(14);
        int sala = Integer.parseInt(testeProf.getSala());
        boolean salainvalida=false;

        if(sala<0)
            salainvalida = true;

        assertTrue(salainvalida);
    }

    @Test
    public void testeSalaErrada(){
        Professor testeProf = popularWeb.popularPagina(12);
        int sala = Integer.parseInt(testeProf.getSala());
        String predioS = testeProf.getPredio();
        predioS = predioS.replace("[", "");
        predioS = predioS.replace("]", "");
        int predio = Integer.parseInt(predioS);

        boolean salaErrada = false;

        switch (predio){
            case 1:
                if(sala>5)
                    salaErrada = true;
                break;
            case 2:
                if(sala<5 || sala>10)
                    salaErrada = true;
                break;
            case 3:
                if(sala<10 || sala>15)
                    salaErrada = true;
                break;
            case 4:
                if(sala<15 || sala>20)
                    salaErrada = true;
                break;
            case 5:
                if(sala<20 || sala>25)
                    salaErrada = true;
                break;
            case 6:
                if(sala<25 || sala>30)
                    salaErrada = true;
                break;
        }
        assertTrue(salaErrada);
    }
    @Test
    public void testePeriodoErrado(){
        Professor testeProf = popularWeb.popularPagina(11);
        String[] horario = testeProf.getHora().split("h");
        int hora = Integer.parseInt(horario[0]);
        boolean errado = false;

        if(hora<=17 && Objects.equals(testeProf.getPeriodo(), "noturno")){
            errado=true;
        }
        assertTrue(errado);
    }

    @Test
    public void testeHorarioInvalido(){
        Professor testeProf = popularWeb.popularPagina(10);
        String[] horario = testeProf.getHora().split("h");
        int hora = Integer.parseInt(horario[0]);
        boolean errado = false;

        if(hora>24 || hora<0){
            errado = true;
        }
        assertTrue(errado);

    }
    @Test
    public void matriculaDuplicada(){
        Professor testeProf1 = popularWeb.popularPagina(1);
        Professor testeProf2 = popularWeb.popularPagina(16);

        assertEquals(testeProf2.getNome(), testeProf1.getNome());
    }

}
