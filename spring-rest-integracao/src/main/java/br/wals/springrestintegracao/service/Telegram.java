package br.wals.springrestintegracao.service;

import br.wals.springrestintegracao.client.FeignClientTelegram;
import br.wals.springrestintegracao.client.JavaHttpClient;
import br.wals.springrestintegracao.client.RestTemplateClient;
import br.wals.springrestintegracao.dto.MessageSend;
import br.wals.springrestintegracao.dto.ResultBotTelegram;
import br.wals.springrestintegracao.dto.ResultBotTelegramList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Telegram {
    private RestTemplateClient restTemplateClient;
    private FeignClientTelegram feignClient;
    private JavaHttpClient javaHttpClient;

    public Telegram(RestTemplateClient restTemplateClient, FeignClientTelegram feignClient,
                    JavaHttpClient javaHttpClient) {
        this.restTemplateClient = restTemplateClient;
        this.feignClient = feignClient;
        this.javaHttpClient = javaHttpClient;
    }

    public void enviarMensagem(MessageSend mensagem) {
        //HTTP CLIENT
        ResultBotTelegram resultBotTelegramResponseEntity = javaHttpClient.enviarMensagem(mensagem);

        //RestTemplate
        restTemplateClient.enviarMensagem(mensagem);

        //FeingClient
        ResultBotTelegram resultBotTelegram = feignClient.enviarMensagem1(mensagem);
    }

    public ResultBotTelegramList buscarAtualizacao() {
        //HTTP CLIENT
        ResultBotTelegramList resultBotTelegramList = javaHttpClient.buscarAtualizacao();

        //RestTemplate
        ResultBotTelegramList resultBotTelegramList1 = restTemplateClient.buscarAtualizacao();

        //FeingClient
        feignClient.buscarAtualizacao();
        return resultBotTelegramList;
    }
}
