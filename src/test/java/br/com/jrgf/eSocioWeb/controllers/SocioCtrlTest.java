package br.com.jrgf.eSocioWeb.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import br.com.jrgf.eSocioWeb.SocioRepository;
import br.com.jrgf.eSocioWeb.DTO.RequestSocio;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@MockitoSettings(strictness = Strictness.LENIENT)
public class SocioCtrlTest {

    @InjectMocks
    private SocioCtrl socioCtrl;

    @Mock
    private SocioRepository socioRepository; 

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(socioCtrl);
    }

    @Test
    public void createdSocioSuccess(){
        RequestSocio reqSocio = new RequestSocio();
        reqSocio.setAtivo(false);
        reqSocio.setNome("josue");
        reqSocio.setRenda(new BigDecimal(1200));
        reqSocio.setSocio_id(1);
        
        BindingResult bindingResult = new BeanPropertyBindingResult(new Object(), "dummy");
        
        String socioSaved = socioCtrl.create(reqSocio, bindingResult);
        assertEquals("sucess", socioSaved);
    }
    @Test
    public void createdSocioFailed(){
        RequestSocio reqSocio = new RequestSocio();
        reqSocio.setAtivo(false);
        reqSocio.setNome("Jor");
        reqSocio.setRenda(new BigDecimal(1200));
        reqSocio.setSocio_id(1);

        BindingResult bindingResult = new BeanPropertyBindingResult(reqSocio, "nome");
        bindingResult.rejectValue("nome", "error.user", "Size name is to low.");
        
        String socioSaved = socioCtrl.create(reqSocio, bindingResult);
        assertEquals("error", socioSaved);
    }
    
}
