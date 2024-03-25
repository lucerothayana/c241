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
    public void testeSalaErrada(){
        Professor testeProf = popularWeb.popularPagina(1);
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
        assertFalse(salaErrada);
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
