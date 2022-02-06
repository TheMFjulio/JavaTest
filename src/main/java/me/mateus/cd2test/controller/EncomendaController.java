package me.mateus.cd2test.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import me.mateus.cd2test.models.Encomenda;
import me.mateus.cd2test.models.InputModel;
import me.mateus.cd2test.models.ResponseModel;
import me.mateus.cd2test.service.EncomendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URI;

@ResponseBody
@Controller
@RequestMapping("api/v1/sigabem")
public class EncomendaController {

    private final EncomendaService service;

    @Autowired
    public EncomendaController(EncomendaService service) {
        this.service = service;
    }

    @ApiOperation(value = "Adiciona uma encomenda a database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação feita com sucesso", response = Encomenda.class),
            @ApiResponse(code = 400, message = "Formatação errada do CEP")
    })
    @PostMapping(
            value = "post",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Encomenda> postBody(@RequestBody InputModel inputModel) {
        Encomenda encomenda = null;
        try {
            encomenda = new Encomenda(inputModel);
        } catch (IOException e) {
            return ResponseEntity.status(400).build();
        }
        System.out.println("\n\n\n\n\n" + inputModel.getNomeDestinatario());
        service.addNewEncomenda(encomenda);
        return ResponseEntity.created(URI.create(String.format("/encomendas/%s", encomenda.getNomeDestinatario()))).body(encomenda);
    }
}
