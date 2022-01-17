package com.ensa.backofficeservice.controllers;


import com.ensa.backofficeservice.domains.Transfer;
import com.ensa.backofficeservice.service.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/backoffice/transfer")
@AllArgsConstructor
public class TransferController {

    public final TransferService transferService;

    @PostMapping(path="/cash/{soldAgent}")
    @ResponseStatus(HttpStatus.CREATED)
    public Transfer transferByAgent(@RequestBody Transfer transfer, @PathVariable double soldAgent) {
        return transferService.transferEspeceAgent(transfer,soldAgent);
    }
    @PostMapping(path="/cash/multiple/{soldAgent}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Transfer> transferMultByAgent(@RequestBody List<Transfer> transfers, @PathVariable double soldAgent){
        return transferService.transferEspeceAgentMult(transfers,soldAgent);
    }

    @PostMapping(path="/debit/{soldCompte}")
    @ResponseStatus(HttpStatus.CREATED)
    public Transfer transferDebAgent(@RequestBody Transfer transfer,@PathVariable double soldCompte) throws Exception {
        return transferService.transferDebAgent(transfer,soldCompte);
    }

    @PostMapping(path="/debit/multiple/{soldCompte}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Transfer> transferDebMultAgent(@RequestBody List<Transfer> transfers,@PathVariable double soldCompte){
        return transferService.transferDebitAgentMult(transfers,soldCompte);
    }

    @PutMapping(path = "/block/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Transfer blockTransfer(@PathVariable Long id){
        return transferService.blockTransfer(id);
    }

    @PutMapping(path = "/deblock/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Transfer deblockTransfer(@PathVariable Long id){
        return transferService.deblockTransfer(id);
    }


    @GetMapping(path = "/{clientSrc}")
    @ResponseStatus(HttpStatus.OK)
    public List<Transfer> transferByAgent(@PathVariable Long clientSrc){
        return transferService.myTransfers(clientSrc);
    }


}
