package utils;

import org.junit.Assert;
import runner.Runner;

public class Utils extends Runner {

    public void validaTitulo(String tituloEsperado){
        String tituloObtido = driver.getTitle();
        Assert.assertEquals(tituloEsperado, tituloObtido);
    }

}
