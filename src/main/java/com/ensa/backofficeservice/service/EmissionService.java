package com.ensa.backofficeservice.service;

import com.ensa.backofficeservice.domains.Emission;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//we write the name of the service that we are going to consume
//in this case : emission-service
// in the url attribute , we write the port on which the emission-service is running
//pretending that the port = 8083
@FeignClient(name = "emission-service", url = "http://localhost:8083/")
public interface EmissionService {
    @PostMapping("/emissionByAgent")
    public Emission emissionByAgent(@RequestBody Emission emission);

    @PostMapping(path = "/emissionByGab")
    public Emission emissionByGab(@RequestBody Emission emission);
}
