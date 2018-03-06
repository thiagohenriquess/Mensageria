


# Agendamento de máquinas – API para parceiros

# Introdução

Este documento tem como finalidade prover as informações necessárias para disponibilizar a funcionalidade de agendamento de ambiente de STG para parceiros.

Cada parceiro deverá enviar no Header de todas as requisições um parâmetro &quot;profile&quot;, com o seu respectivo profile previamente acordado.

1.Agendamento de ambiente

   1.1.Formato da requisição


| **HTTP METHOD** | **POST** |
| --- | --- |
| **Content-Type** | application/json |
| **Cache-Control** | no-cache |
| **URL** | /calendar |
| **Body** | {
  "beginDate": "2018-03-10",
   "endDate": "2018-03-11", 
  "beginWindow": "18:00",
  "endWindow": "13:00",
  "service": "adesao-wooza-stg"
}|
| **Header** | profile=wooza |

   1.2.Parâmetros

| **Parâmetro** | **Descrição** | **Formato** |
| --- | --- | --- |
| **beginDate** | Data de inicio da janela agendada | YYYY-MM-dd |
| **endDate** | Data final da janela agendada | YYYY-MM-dd |
| **beginWindow** | Horário de inicio da disponibilização do ambiente. | HH:mm .Entre 00:00 e 23:59 |
| **endWindow** | Horário final da disponibilização do ambiente | HH:mm.  Entre 00:00 e 23:59 |
| **service** | O ambiente desejado para disponibilização | String |


   1.3.Respostas


Sucesso:

| **HTTP RESPONSE CODE** | **200** |
| --- | --- |
| **Content-Type** | application/json |

Falha:

| **HTTP RESPONSE CODE** | **400/403/500/504** |
| --- | --- |
| **Content-Type** | application/json |

