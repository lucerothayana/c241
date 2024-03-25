import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.HaService;
import org.example.PopularWeb;
import org.example.Professor;
import org.junit.Before;
import org.junit.Test;
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
        assertEquals("",testeProf.getNome());
    }

    @Test
    public void testeVazioPeriodo(){
        Professor testeProf = popularWeb.popularPagina(0);
        assertEquals("",testeProf.getPeriodo());
    }


    @Test
    public void testeMatInvalida(){
        Professor testeProf = popularWeb.popularPagina(-1);
        assertNull(testeProf);
    }

    @Test
    public void testePredioInvalido(){
        Professor testeProf = popularWeb.popularPagina(13);
        int predio = Integer.parseInt(testeProf.getPredio());
        boolean predioinvalido=false;

        if(predio<1 || predio>6)
            predioinvalido = true;

        assertTrue(predioinvalido);
    }
    @Test
    public void testeSalaInvalidaPos(){
        Professor testeProf = popularWeb.popularPagina(13);
        int sala = Integer.parseInt(testeProf.getSala());
        boolean salainvalida=false;

        if(sala>30)
            salainvalida = true;

        assertTrue(salainvalida);
    }

    @Test
    public void testeSalaInvalidaNeg(){
        Professor testeProf = popularWeb.popularPagina(13);
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
        int predio = Integer.parseInt(testeProf.getPredio());
        boolean salaErrada = false;

        switch (predio){
            case 1:
                if(sala>5)
                    salaErrada = true;
                break;
            case 2:
                if(sala>10)
                    salaErrada = true;
                break;
            case 3:
                if(sala>15)
                    salaErrada = true;
                break;
            case 4:
                if(sala>20)
                    salaErrada = true;
                break;
            case 5:
                if(sala>25)
                    salaErrada = true;
                break;
            case 6:
                if(sala>30)
                    salaErrada = true;
                break;
        }
        assertTrue(salaErrada);
    }
    @Test
    public void testePeriodoErrado(){
        Professor testeProf = popularWeb.popularPagina(11);

    }

    @Test
    public void testeProfErrado(){
        Professor testeProf = popularWeb.popularPagina(10);

    }
    @Test
    public void testeProfessoresDiferentes(){
        Professor testeProf = popularWeb.popularPagina(11);

    }

}
