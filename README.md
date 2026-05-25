## Objetivo do Projeto

Este serviço monitora continuamente a fila DLQ (Dead Letter Queue) da AWS SQS. Ao receber uma mensagem, realiza a leitura, análise da quantidade de itens do pedido, classificação da severidade do erro e persiste os dados em banco de dados para análise posterior.

O objetivo é garantir que mensagens com falha sejam rastreadas e documentadas de forma estruturada, permitindo investigação e tratamento adequado dos erros.

## Justificativa da Arquitetura em Camadas

A Arquitetura em Camadas foi escolhida por se adequar perfeitamente ao escopo deste serviço, que possui uma responsabilidade bem definida: consumir mensagens, processar e persistir dados.

Esta arquitetura organiza o código em camadas independentes, onde cada uma é responsável por uma função específica. Isso resulta em código mais legível, mantível e escalável, facilitando futuras modificações sem afetar outras partes do sistema.

Arquiteturas alternativas como Hexagonal foram descartadas por introduzirem complexidade desnecessária — esse padrão é mais apropriado para sistemas com múltiplos pontos de entrada e saída. MVC também não se aplica, já que o serviço não possui interface visual ou endpoints REST, funcionando exclusivamente através de fila de mensagens.