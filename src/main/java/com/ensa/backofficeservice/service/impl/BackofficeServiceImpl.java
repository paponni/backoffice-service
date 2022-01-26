package com.ensa.backofficeservice.service.impl;

import com.ensa.backofficeservice.domains.Compte;
import com.ensa.backofficeservice.domains.Transfer;
import com.ensa.backofficeservice.enums.Status;
import com.ensa.backofficeservice.service.BackofficeService;
import com.ensa.backofficeservice.service.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class BackofficeServiceImpl implements BackofficeService {

    public final TransferService transferService;


    @Override
    public void batchBlocage() {

        //  regroupe l’ensemble des transferts émis par les clients
        // qui ont une date de fin de validité égale à la date du jour

        LocalDateTime exprDate = LocalDateTime.now();
        List<Transfer> transferList=transferService.findTransferByexprDate(exprDate);
        for(Transfer tr:transferList){
            //we need to change to motif of blocking to
            //Bloqué après expiration du délai
            transferService.blockTransfer(tr.getId());

        }

    }
    public void batchDesherence(){
        // regroupe l’ensemble des transferts de la journée à l’état
        // « bloquée après expiration du délai ».
        List<Transfer> transferList = transferService.findByStatus(Status.Endeshérence);
        //Un test du délai est opéré :
        //Tant que ce dernier n’a pas été écoulé, l’état de la mise à disposition est maintenu
        // à « bloquée après expiration du délai»
        //Une fois le délai atteint, le traitement génère une écriture comptable du montant de transfert
        // sur un compte dédié.
        // De ce fait, l’état du transfert transite à l’état « déshérence »
        LocalDateTime expDate = LocalDateTime.now();
        for(Transfer tr:transferList){
            if(tr.getExprDate()==expDate){
                tr.setStatus(Status.Endeshérence);
                //transformation d'argent de transfert vers un compte dédié .
                transferService.save(tr);
            }
        }

    }




}
