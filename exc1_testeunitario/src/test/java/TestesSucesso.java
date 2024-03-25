import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.HaService;
import org.example.PopularWeb;
import org.example.Professor;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestesSucesso {
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
    public void testeHorarioLuma(){
        Professor testeProf = popularWeb.popularPagina(1);
        assertEquals("Luma",testeProf.getNome());
    }

    @Test
    public void testeHorarioYnoguti(){
        Professor testeProf = popularWeb.popularPagina(2);
        assertEquals("17h30",testeProf.getHora());
    }

    @Test
    public void testeHorarioBueno(){
        Professor testeProf = popularWeb.popularPagina(3);
        assertEquals("noturno",testeProf.getPeriodo());
    }

    @Test
    public void testeHorarioChris(){
        Professor testeProf = popularWeb.popularPagina(4);
        assertEquals("16",testeProf.getSala());
    }

    @Test
    public void testeHorarioElisa(){
        Professor testeProf = popularWeb.popularPagina(5);
        assertEquals("[5]", testeProf.getPredio());
    }
    @Test
    public void testeHorarioKarina(){
        Professor testeProf = popularWeb.popularPagina(6);
        assertNotNull(testeProf);
    }

    @Test
    public void testeLenPredio(){
        Professor testeProf = popularWeb.popularPagina(3);
        //JsonArray predio = testeProf.getPredio();
        //assertEquals(1, predio.size());
    }

    @Test
    public void testeArrayPredio(){
        Professor testeProf = popularWeb.popularPagina(5);
        String predio = testeProf.getPredio();
        assertEquals(predio,"[5]");
    }

    @Test
    public void testeNomes(){
        Professor testeLuma = popularWeb.popularPagina(1);
        Professor testeYnoguti = popularWeb.popularPagina(2);
        assertNotEquals(testeLuma.getNome(),testeYnoguti.getNome());
    }

    @Test
    public void testePeriodo(){
        Professor testeLuma = popularWeb.popularPagina(1);
        Professor testeYnoguti = popularWeb.popularPagina(3);
        assertEquals(testeLuma.getPeriodo(),testeYnoguti.getPeriodo());
    }


}
