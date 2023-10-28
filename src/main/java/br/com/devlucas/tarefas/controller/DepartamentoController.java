package br.com.devlucas.tarefas.controller;

import br.com.devlucas.tarefas.model.Departamento;
import br.com.devlucas.tarefas.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> listarDepartamentos() {
        return ResponseEntity.ok(departamentoService.listarDepartamentos());
    }
}
