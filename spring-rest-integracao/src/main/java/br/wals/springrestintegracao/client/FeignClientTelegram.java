package br.wals.springrestintegracao.client;

import br.wals.springrestintegracao.dto.MessageSend;
import br.wals.springrestintegracao.dto.ResultBotTelegram;
import br.wals.springrestintegracao.dto.ResultBotTelegramList;
import feign.Headers;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(url = "${telegram.api}${telegram.token}", name = "telegram")
public interface FeignClientTelegram {

    @GetMapping("/getUpdates")
    ResponseEntity<ResultBotTelegramList> buscarAtualizacao();

    @GetMapping("/getUpdates")
    @Headers("MEU_HEADER: {meu_header}")
    ResponseEntity<ResultBotTelegramList> buscarAtualizacao1(@Param("meu_header") String header);

    @PostMapping("/sendMessage")
    ResponseEntity<ResultBotTelegram> enviarMensagem(@RequestBody MessageSend msg);

    @PostMapping("/sendMessage")
    @ResponseBody
    ResultBotTelegram enviarMensagem1(@RequestBody MessageSend msg);

    //set header RequestHeader
    @PostMapping(value = "/sendMessage")
    ResultBotTelegram enviarMensagem3(@RequestBody MessageSend msg, @RequestHeader("MEU_HEADER") String header);

    //RequestMapping informando o tipo de método
    @RequestMapping(method = RequestMethod.POST, value = "/sendMessage")
    ResultBotTelegram enviarMensagem5(@RequestBody MessageSend msg);

    //Exemplo de path variable
    @GetMapping("/getUpdates/{meuTeste}")
    ResultBotTelegram examplePathVariable(@PathVariable("meuTeste") String meuTeste);

    //Exemplo de request param
    //www.minhaurl.com.br/getUpdates?nome=nomeInformado
    @GetMapping("/getUpdates")
    ResultBotTelegram exampleRequestParam(@RequestParam("nome") String nome);
}
