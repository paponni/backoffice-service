package com.ensa.backofficeservice.controllers;


import com.ensa.backofficeservice.domains.Emission;
import com.ensa.backofficeservice.service.EmissionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/backoffice/emission")
@AllArgsConstructor
public class EmissionController {

   public final  EmissionService emissionService ;

   @PostMapping("/emissionByAgent")
   @ResponseStatus(HttpStatus.CREATED)
    public Emission emissionByAgent(@RequestBody Emission emission){
       return emissionService.emissionByAgent(emission);
   }
    @PostMapping(path = "/emissionByGab")
    @ResponseStatus(HttpStatus.CREATED)
    public Emission emissionByGab(@RequestBody Emission emission){
        return  emissionService.emissionByGab(emission);
    }



}
