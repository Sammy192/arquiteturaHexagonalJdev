![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

# API CALCULA JUROS BOLETO

Projeto desenvolvido com objetivo de conhecer sobre Arquitetura Hexagonal. JdevTreinamentos.

![image](https://github.com/user-attachments/assets/d2d676da-ab79-4798-a97e-32e8e43d196b)

![image](https://github.com/user-attachments/assets/80e96c32-7720-4fa4-a9a2-b16439d98688)



## PROBLEMA:
**ENQUANTO** usuário da API

**QUERO** digitar um código de boleto vencido

**E** quero receber o valor do juros.


## Requisitos Funcionais
- Desenvolver um API
- Incluir um código de boleto válido
- O Boleto deve estar vencido
- Apenas boletos do tipo XPTO podem ser calculados
- Para receber as informações do boleto, consumir a API de Boletos
- Em caso de erro, devolver o motivo do erro
- A definição dos juros de boleto bancário ocorre considerando os dias de atraso, de maneira proporcional.
    - Taxa de juros de 1% ao mes ou 1 / 30 = 0,033% ao dia
- O valor final do boleto deve ser:
    - Valor do boleto +  valor dos juros em atraso
- Salvar em um **banco de dados** todos os cálculos realizados

Request →
```json
{
  "codigo": "string",
  "data_pagamento": "YYY-MM-DD HH:MM:SS"
}
```

Response →
```json
{
  "codigo": "string",
  "data_vencimento": "YYYY-MM-DD",
  "valor": 00.0,
  "tipo": "XPTO|NORMAL"
}
```

<br>
<br>
<br>


# Ferramentas

- Lombok
- Intellij
- Spring boot
- Docker
- Docker-compose
- Swagger
- Spring JPA
- Mysql
- Feign Client
- Map Struct
