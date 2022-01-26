package com.ensa.backofficeservice.service;

import com.ensa.backofficeservice.domains.Transfer;
import com.ensa.backofficeservice.enums.Status;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
//in this interface we call some methods that already implemented in transfert microservice
//we write the name of the service that we are going to consume
//in this case : transfert-service
// in the url attribute , we write the port on which the transfer-service is running
//pretending that the port = 8083
@FeignClient(name = "transfer-service" , url = "http://localhsot:8083/")
public interface TransferService {

    @PostMapping(path="/cash/{soldAgent}")
    public Transfer transferEspeceAgent(@RequestBody Transfer transfer,@PathVariable double soldAgent);

    @PostMapping(path="/cash/multiple/{soldAgent}")
    public List<Transfer> transferEspeceAgentMult(@RequestBody List<Transfer> transfers, @PathVariable double soldAgent);

    @PostMapping(path="/debit/{soldCompte}")
    public Transfer transferDebAgent(@RequestBody Transfer transfer,@PathVariable double soldCompte);

    @PostMapping(path="/debit/multiple/{soldCompte}")
    public List<Transfer> transferDebitAgentMult(@RequestBody List<Transfer> transfers,@PathVariable double soldCompte);


    @PutMapping(path = "/block/{id}")
    public Transfer blockTransfer(@PathVariable Long id);

    @PutMapping(path = "/deblock/{id}")
    public Transfer deblockTransfer(@PathVariable Long id);

    @GetMapping(path = "/{clientSrc}")
    public List<Transfer> myTransfers(@PathVariable Long clientSrc);

    public List<Transfer> findTransferByexprDate(LocalDateTime exprDate);

    public List<Transfer> findByStatus(Status status);

    public Transfer save(Transfer transfer);
}

